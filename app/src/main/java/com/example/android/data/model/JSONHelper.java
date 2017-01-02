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
    public static final String FILE_NAME_TRIPS = "trips.json";
    public static final String FILE_NAME_WPS = "wps.json";
    public static final String TAG = "JSONHelper";




    /*
     * Export Trip data to external storage in JSON format by wrapping trip data in the
     * TripDataItem class structure and encode using Gson.
     */
    public static boolean exportTripsToJSON(Context context, List<TripItem> list) {

        TripDataItems tripItems = new TripDataItems();
        tripItems.setDataItems(list);

        Gson gson = new Gson();
        String jsonString = gson.toJson(tripItems);
        Log.i("TBR", "Trips export to JSON " + jsonString);

        FileOutputStream fileOutputStream = null;
        File file=new File(Environment.getExternalStorageDirectory(), FILE_NAME_TRIPS);

        try {
            fileOutputStream = new FileOutputStream(file);
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



    /*
     * Export WP data to external storage in JSON format by wrapping trip data in the
     * WpDataItem class structure and encode using Gson.
     */
    public static boolean exportWpsToJSON(Context context, List<WpItem> list) {

        WpDataItems wpDataItems = new WpDataItems();
        wpDataItems.setDataItems(list);

        Gson gson = new Gson();
        String jsonString = gson.toJson(wpDataItems);
        Log.i("TBR", "WPs export to JSON " + jsonString);

        FileOutputStream fileOutputStream = null;
        File file=new File(Environment.getExternalStorageDirectory(), FILE_NAME_WPS);

        try {
            fileOutputStream = new FileOutputStream(file);
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



    /*
     * Import Table data in Json format from external storage using Gson to arrange everything
     * into the TripDataItems data structure.
     */

    public static List<TripItem> importTripsFromJSON(Context context) {

        FileReader reader = null;

        try {
            File file=new File(Environment.getExternalStorageDirectory(),FILE_NAME_TRIPS);
            reader = new FileReader(file);

            Gson gson = new Gson();
            TripDataItems dataItems = gson.fromJson(reader, TripDataItems.class);
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



    /*
     * Import WP data in Json format from external storage using Gson to arrange everything
     * into the WpDataItems data structure.
     */

    public static List<WpItem> importWpsFromJSON(Context context) {

        FileReader reader = null;

        try {
            File file=new File(Environment.getExternalStorageDirectory(),FILE_NAME_WPS);
            reader = new FileReader(file);

            Gson gson = new Gson();
            WpDataItems dataItems = gson.fromJson(reader, WpDataItems.class);
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




    /*
     * Class structure used by Gson for Trip data
     */
    static class TripDataItems {
        List<TripItem> dataItems;

        public List<TripItem> getDataItems() {
            return dataItems;
        }

        public void setDataItems(List<TripItem> dataItems) {
            this.dataItems = dataItems;
        }

    }



    /*
     * Class structure used by Gson for Wp data
     */
    static class WpDataItems {
        List<WpItem> dataItems;

        public List<WpItem> getDataItems() {
            return dataItems;
        }

        public void setDataItems(List<WpItem> wpItems) {
            this.dataItems = wpItems;
        }
    }
}
