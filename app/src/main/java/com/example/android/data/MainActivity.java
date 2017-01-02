package com.example.android.data;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.android.data.database.DataSource;
import com.example.android.data.model.JSONHelper;
import com.example.android.data.model.SampleDataProvider;
import com.example.android.data.model.TripItem;
import com.example.android.data.model.WpItem;

import java.io.File;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private static final String LOG = MainActivity.class.getName();
    private static final int REQUEST_PERMISSION_WRITE = 101;
    public static final String FILE_NAME = "mydata.txt";

    List<String>        mTripList = SampleDataProvider.sTrips;
    List<List<WpItem>>  mWpList = SampleDataProvider.sWpListsForTrips;

    DataSource      mDataSource;
    List<TripItem>  mListFromDB;
    RecyclerView    mRecyclerView;
    TripAdapter     mTripAdapter;
    private boolean mPermissionGranted;


    private File getFile() {
        return new File(
                Environment.getExternalStorageDirectory(), FILE_NAME);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Need this for import/export
        if (!mPermissionGranted) {
            mPermissionGranted=checkPermissions();
        }


        // Get a handle to the database helper and prepare the database
        mDataSource = new DataSource(this);
        mDataSource.open();

        populateDatabase();


        // Get a reference to the layout for the recyclerView
        mRecyclerView = (RecyclerView) findViewById(R.id.rvItems);

        displayTrips(null);

    }


    private void populateDatabase() {
        if (mDataSource.getTripCount()==0) {
            // Initialize database tables
            for (int i = 0; i < mTripList.size(); i++) {
                String tripName = mTripList.get(i);
                List<WpItem> wpList = mWpList.get(i);

                mDataSource.addFullTrip(tripName, wpList);
            }
        }
    }

    /*
     * displayTrips
     * Lookup trip data in the database considering the filter. Create a list of
     * matching object for each row returned and feed that to the TripAdapter that will
     * be used for the List.
     *
     * @args:   filter
     * @return: none
     */
    private void displayTrips(String filter) {
        mListFromDB  = mDataSource.getAllTrips(filter);
        mTripAdapter = new TripAdapter(this, mListFromDB);

        mRecyclerView.setAdapter(mTripAdapter);
    }


    @Override
    protected void onPause() {
        super.onPause();
        mDataSource.close();
    }

    @Override
    protected void onResume() {
        super.onResume();
        mDataSource.open();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_settings:
                // Show the settings screen
                Intent settingsIntent = new Intent(this, PrefsActivity.class);
                startActivity(settingsIntent);
                return true;

            case R.id.action_import:
                List<TripItem> dataItems = JSONHelper.importFromJSON(this);
                if (dataItems != null) {
                    for (TripItem trip: dataItems) {
                        Log.i("TBR", "Trip restored: " + trip.getTripName());
                    }
                }
                return true;

            case R.id.action_export:
                boolean result = JSONHelper.exportToJSON(this, mListFromDB);
                if (result) {
                    Toast.makeText(this, "Data Exported", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(this, "Export failed", Toast.LENGTH_SHORT).show();
                }
                return true;
        }
        return super.onOptionsItemSelected(item);
    }


    /* Checks if external storage is available for read and write */
    public boolean isExternalStorageWritable() {
        String state = Environment.getExternalStorageState();
        return Environment.MEDIA_MOUNTED.equals(state);
    }

    /* Checks if external storage is available to at least read */
    public boolean isExternalStorageReadable() {
        String state = Environment.getExternalStorageState();
        return (Environment.MEDIA_MOUNTED.equals(state) ||
                Environment.MEDIA_MOUNTED_READ_ONLY.equals(state));
    }

    // Initiate request for permissions.
    private boolean checkPermissions() {
        Log.d("TBR", "CheckPermissions");

        if (!isExternalStorageReadable() || !isExternalStorageWritable()) {
            Toast.makeText(this, "This app only works on devices with usable external storage",
                    Toast.LENGTH_SHORT).show();
            return false;
        }

        int permissionCheck = ContextCompat.checkSelfPermission(this,
                Manifest.permission.WRITE_EXTERNAL_STORAGE);
        if (permissionCheck != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},
                    REQUEST_PERMISSION_WRITE);

            return false;
        } else {
            return true;
        }
    }

    // Handle permissions result
    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           @NonNull String permissions[],
                                           @NonNull int[] grantResults) {
        switch (requestCode) {
            case REQUEST_PERMISSION_WRITE:
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    mPermissionGranted = true;
                    Toast.makeText(this, "External storage permission granted",
                            Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(this, "You must grant permission!", Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }


}

