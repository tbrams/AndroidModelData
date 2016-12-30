package com.example.android.data.database;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.android.data.model.TripItem;

import java.util.ArrayList;
import java.util.List;

public class DataSource {

    private Context mContext;
    private SQLiteDatabase mDatabase;
    private SQLiteOpenHelper mDbOpenHelper;


    public DataSource(Context context) {
        mContext = context;
        mDbOpenHelper = new DBhelper(context);
        mDatabase = mDbOpenHelper.getWritableDatabase();
    }



    public void open() {
        mDatabase = mDbOpenHelper.getWritableDatabase();
    }


    public void close() {
        mDbOpenHelper.close();
    }



    public TripItem createTrip(TripItem trip) {
        ContentValues values = trip.toValues();

        mDatabase.insert(TripTable.TABLE_TRIPS, null, values);
        return trip;
    }



    public long getTripCount() {
        return DatabaseUtils.queryNumEntries(mDatabase, TripTable.TABLE_TRIPS);
    }



    public void seedDataBase(List<TripItem> tripList) {
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
            cursor = mDatabase.query(TripTable.TABLE_TRIPS, TripTable.ALL_COLUMNS, null,null,null,null,TripTable.COLUMN_NAME);
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
}
