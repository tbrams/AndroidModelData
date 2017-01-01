package com.example.android.data;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;

import com.example.android.data.database.DataSource;
import com.example.android.data.model.SampleDataProvider;
import com.example.android.data.model.TripItem;
import com.example.android.data.model.WpItem;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private static final String LOG = MainActivity.class.getName();

    List<String>        mTripList = SampleDataProvider.sTrips;
    List<List<WpItem>>  mWpList = SampleDataProvider.sWpListsForTrips;

    DataSource      mDataSource;
    List<TripItem>  mListFromDB;
    RecyclerView    mRecyclerView;
    TripAdapter     mTripAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Get a handle to the database helper and prepare the database
        mDataSource = new DataSource(this);
        mDataSource.open();

        // Initialize database tables
        for (int i = 0; i < mTripList.size(); i++) {
            String       tripName = mTripList.get(i);
            List<WpItem> wpList   = mWpList.get(i);

            mDataSource.addFullTrip(tripName, wpList);

        }


        // Get a reference to the layout for the recyclerView
        mRecyclerView = (RecyclerView) findViewById(R.id.rvItems);

        displayTrips(null);

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

            case R.id.action_clear_db:
                mDataSource.resetDB();
                return true;

            case R.id.action_load_db:
                return true;
        }
        return super.onOptionsItemSelected(item);
    }


}

