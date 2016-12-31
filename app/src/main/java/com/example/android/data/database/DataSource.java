package com.example.android.data.database;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.android.data.model.TripItem;
import com.example.android.data.model.WpItem;

import java.util.ArrayList;
import java.util.List;

public class DataSource {

    private Context mContext;
    private SQLiteDatabase mDb;
    private SQLiteOpenHelper mDbOpenHelper;


    /*
     * Generic Database functionality
     * Constructor, open and close methods
     */
    public DataSource(Context context) {
        mContext = context;
        mDbOpenHelper = new DBhelper(context);
        mDb = mDbOpenHelper.getWritableDatabase();

        Log.d("TBR:", "DataSource constructor");
    }



    public void open() {
        mDb = mDbOpenHelper.getWritableDatabase();
    }


    public void close() {
        mDbOpenHelper.close();
    }


    //
    //Trip Table specifics
    // --------------------


    /*
     * createTrip
     * This is the function responsible for inserting data into the Trips Table. Will be returning
     * the same object in case we need to check if something has been changed.
     *
     * @Args: Trip Object
     *
     * @Return: Trip object
     *
     */

    public TripItem createTrip(TripItem trip) {
        ContentValues values = trip.toValues();

        mDb.insert(TripTable.TABLE_TRIPS, null, values);
        return trip;
    }



    /*
     * getTripCount
     * Return the number of rows in the Trip Table
     *
     * @Args: None
     *
     * @Return: long
     *
     */
    public long getTripCount() {
        return DatabaseUtils.queryNumEntries(mDb, TripTable.TABLE_TRIPS);
    }



    /*
     * seedTripTable
     * Insert all Trip objects into the trip table in the database
     *
     * @Args: List of Trip objects
     *
     * @Return: none
     *
     */
    public void seedTripTable(List<TripItem> tripList) {
        long numDataItems = getTripCount();
        if (numDataItems==0) {
            for (TripItem trip :
                    tripList) {
                try {
                    createTrip(trip);
                } catch (SQLiteException e) {
                    e.printStackTrace();
                }
            }
        }

    }


    /*
     * getAllTrips
     * Lookup matching records in the database and for each create a matching object and return
     * a list with all of these as the result.
     *
     * @Args: category, a filter - if this is null all rows are returned from db, otherwise only
     *                  Trips with a date string matching the filter is returned.
     *
     * @Return: A list of trip objects
     *
     */
    public List<TripItem> getAllTrips(String category){
        List<TripItem> trips = new ArrayList<>();
        Cursor cursor;

        if (category==null) {
            cursor = mDb.query(TripTable.TABLE_TRIPS, TripTable.ALL_COLUMNS, null,null,null,null,TripTable.COLUMN_DATE);
        } else {
            String[] categories = {category};
            cursor = mDb.query(TripTable.TABLE_TRIPS, TripTable.ALL_COLUMNS, TripTable.COLUMN_DATE+"=?",categories,null,null,TripTable.COLUMN_NAME);
        }


        while (cursor.moveToNext()) {
            TripItem trip = new TripItem();
            trip.setTripId(cursor.getString(
                    cursor.getColumnIndex(TripTable.COLUMN_ID)));
            trip.setTripName(cursor.getString(
                    cursor.getColumnIndex(TripTable.COLUMN_NAME)));
            trip.setTripDate(cursor.getString(
                    cursor.getColumnIndex(TripTable.COLUMN_DATE)));
            trip.setTripDistance(cursor.getDouble(
                    cursor.getColumnIndex(TripTable.COLUMN_DIST)));
            trips.add(trip);
        }
        cursor.close();

        return trips;
    }


    //
    // WP Table specifics
    // --------------------

    /*
     * createWp
     * This is the function responsible for inserting data into the WayPoint Table. Will be returning
     * the same object in case we need to check if something has been changed.
     *
     * @Args: WP Object
     *
     * @Return: WP object
     *
     */
    public WpItem createWp(WpItem wp) {
        ContentValues values = wp.toValues();

        mDb.insert(WpTable.TABLE_WPS, null, values);
        return wp;
    }



    /*
      * getWpCount
      * Return the number of rows in the WayPoint Table
      *
      * @Args: None
      *
      * @Return: long
      *
      */
    public long getWpCount() {
        return DatabaseUtils.queryNumEntries(mDb, WpTable.TABLE_WPS);
    }


    /*
     * seedWpTable
     * Insert all Wp objects into the WayPoint table in the database
     *
     * @Args: List of WP objects
     *
     * @Return: none
     *
     */
    public void seedWpTable(List<WpItem> wpList) {
        long numDataItems = getWpCount();

        if (numDataItems==0) {
            for (WpItem wp :
                    wpList) {
                try {
                    createWp(wp);
                } catch (SQLiteException e) {
                    e.printStackTrace();
                }
            }
        }

    }


    /*
     * getAllWps
     * Lookup matching records in the database and for each create a matching object and return
     * a list with all of these as the result.
     *
     * @Args: id,   a filter - if this is null all rows are returned from db, otherwise only
     *              Way Points with a matching ID is returned.
     *
     * @Return: A list of WP objects
     *
     */
    public List<WpItem> getAllWps(String id){
        List<WpItem> wps = new ArrayList<>();
        Cursor cursor;

        if (id==null) {
            cursor = mDb.query(WpTable.TABLE_WPS, WpTable.ALL_COLUMNS, null,null,null,null, WpTable.COLUMN_NAME);
        } else {
            String[] fields = {id};
            cursor = mDb.query(WpTable.TABLE_WPS, WpTable.ALL_COLUMNS, WpTable.COLUMN_TRIP_ID+"=?",fields,null,null,WpTable.COLUMN_NAME);
        }

        while (cursor.moveToNext()) {
            WpItem wp = new WpItem();
            wp.setWpId(cursor.getString(cursor.getColumnIndex(WpTable.COLUMN_ID)));
            wp.setWpName(cursor.getString(cursor.getColumnIndex(WpTable.COLUMN_NAME)));
            wp.setWpAltitude(cursor.getString(cursor.getColumnIndex(WpTable.COLUMN_ALT)));
            wp.setWpDistance(cursor.getDouble(cursor.getColumnIndex(WpTable.COLUMN_DIST)));
            wp.setTripIndex(cursor.getString(cursor.getColumnIndex(WpTable.COLUMN_TRIP_ID)));
            wp.setWpSequenceNumber(cursor.getString(cursor.getColumnIndex(WpTable.COLUMN_SEQUENCE_NUMBER)));
            wps.add(wp);
        }
        cursor.close();

        return wps;
    }
}
