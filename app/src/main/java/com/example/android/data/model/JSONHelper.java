package com.example.android.data.model;


import android.content.Context;
import android.os.Environment;
import android.util.Log;

import com.google.gson.Gson;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class JSONHelper {
    public static final String FILE_NAME = "trips1.json";
    public static final String TAG = "JSONHelper";

    public static boolean exportToJSON(Context context, List<TripItem> list) {

        DataItems tripItems = new DataItems();
        tripItems.setDataItems(list);

        Gson gson = new Gson();
        String jsonString = gson.toJson(tripItems);
        Log.i("TBR", "exportToJSON " + jsonString);

        FileOutputStream fileOutputStream = null;
        try {
            File file=new File(Environment.getExternalStorageDirectory(), FILE_NAME);
            fileOutputStream.write(jsonString.getBytes());
            return true;
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return false;
    }

    public static List<TripItem> importFromJSON(Context context) {

        FileReader reader = null;

        try {
            File file=new File(Environment.getExternalStorageDirectory(),FILE_NAME);
            reader = new FileReader(file);

            Gson gson = new Gson();
            DataItems dataItems = gson.fromJson(reader, DataItems.class);
            return dataItems.getDataItems();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


        return null;
    }

    static class DataItems {
        List<TripItem> dataItems;

        public List<TripItem> getDataItems() {
            return dataItems;
        }

        public void setDataItems(List<TripItem> dataItems) {
            this.dataItems = dataItems;
        }

    }
}
