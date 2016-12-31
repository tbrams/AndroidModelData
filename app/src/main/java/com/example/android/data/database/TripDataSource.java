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

public class TripDataSource {

    private Context mContext;
    private SQLiteDatabase mDatabase;
    private SQLiteOpenHelper mDbOpenHelper;


    public TripDataSource(Context context) {
        mContext = context;
        mDbOpenHelper = new DBhelper(context);
        mDatabase = mDbOpenHelper.getWritableDatabase();

        Log.d("TBR:", "TripDataSource constructor");
    }



    public void open() {
        mDatabase = mDbOpenHelper.getWritableDatabase();
    }


    public void close() {
        mDbOpenHelper.close();
    }


    /*
     * Trip Table specifics
     */

    public TripItem createTrip(TripItem trip) {
        ContentValues values = trip.toValues();

        mDatabase.insert(TripTable.TABLE_TRIPS, null, values);
        return trip;
    }



    public long getTripCount() {
        return DatabaseUtils.queryNumEntries(mDatabase, TripTable.TABLE_TRIPS);
    }



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



    public List<TripItem> getAllTrips(String category){
        List<TripItem> trips = new ArrayList<>();
        Cursor cursor;

        if (category==null) {
            cursor = mDatabase.query(TripTable.TABLE_TRIPS, TripTable.ALL_COLUMNS, null,null,null,null,TripTable.COLUMN_DATE);
        } else {
            String[] categories = {category};
            cursor = mDatabase.query(TripTable.TABLE_TRIPS, TripTable.ALL_COLUMNS, TripTable.COLUMN_DATE+"=?",categories,null,null,TripTable.COLUMN_NAME);
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


    /*
     * WP Table specifics
     */

    public WpItem createWp(WpItem wp) {
        ContentValues values = wp.toValues();

        mDatabase.insert(WpTable.TABLE_WPS, null, values);
        return wp;
    }



    public long getWpCount() {
        return DatabaseUtils.queryNumEntries(mDatabase, WpTable.TABLE_WPS);
    }



    public void seedWpTable(List<WpItem> wpList) {
        long numDataItems = getWpCount();
        Log.d("TBR:", "seedWpTable with numDataItems: "+numDataItems);

        if (numDataItems==0) {
            for (WpItem wp :
                    wpList) {
                try {
                    Log.d("TBR:", "creating wp "+wp.getWpName());
                    createWp(wp);
                } catch (SQLiteException e) {
                    e.printStackTrace();
                }
            }
        }

    }



    public List<WpItem> getAllWps(String id){
        List<WpItem> wps = new ArrayList<>();
        Cursor cursor;

        if (id==null) {
            cursor = mDatabase.query(WpTable.TABLE_WPS, WpTable.ALL_COLUMNS, null,null,null,null, WpTable.COLUMN_NAME);
        } else {
            String[] fields = {id};
            cursor = mDatabase.query(WpTable.TABLE_WPS, WpTable.ALL_COLUMNS, WpTable.COLUMN_TRIP_ID+"=?",fields,null,null,WpTable.COLUMN_NAME);
        }

        Log.d("TBR:", "in getAllWps");

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
