package com.example.android.data.database;

public class WpTable {

    public static final String TABLE_WPS = "wps";

    public static final String COLUMN_ID   = "wpId";
    public static final String COLUMN_NAME = "wpName";
    public static final String COLUMN_DIST = "wpDistance";
    public static final String COLUMN_ALT = "wpAltitude";
    public static final String COLUMN_TRIP_ID = "wpTripId";
    public static final String COLUMN_SEQUENCE_NUMBER = "wpSequenceNumber";


    public static final String[] ALL_COLUMNS = {COLUMN_ID, COLUMN_NAME, COLUMN_DIST, COLUMN_ALT, COLUMN_TRIP_ID, COLUMN_SEQUENCE_NUMBER};

    public static final String SQL_CREATE =
            "CREATE TABLE " + TABLE_WPS + "(" +
                    COLUMN_ID + " TEXT PRIMARY KEY," +
                    COLUMN_NAME + " TEXT," +
                    COLUMN_DIST + " REAL," +
                    COLUMN_ALT + " TEXT," +
                    COLUMN_TRIP_ID + " TEXT," +
                    COLUMN_SEQUENCE_NUMBER + " TEXT" + ");";

    public static final String SQL_DELETE =
            "DROP TABLE " + TABLE_WPS;
}