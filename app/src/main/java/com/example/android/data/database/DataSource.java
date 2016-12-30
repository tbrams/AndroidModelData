package com.example.android.data.database;


import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.android.data.model.DataItem;

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

    public DataItem createItem(DataItem item) {
        ContentValues values = item.toValues();

        mDatabase.insert(ItemsTable.TABLE_ITEMS, null, values);
        return item;
    }
}
