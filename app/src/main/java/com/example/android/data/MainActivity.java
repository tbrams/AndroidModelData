package com.example.android.data;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;

import com.example.android.data.database.DataSource;
import com.example.android.data.model.SampleTripDataProvider;
import com.example.android.data.model.TripItem;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<TripItem> tripList = SampleTripDataProvider.sTripList;
    DataSource mDataSource;
    List<TripItem> listFromDB;
    RecyclerView mRecyclerView;
    TripAdapter mTripAdapter;


        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            mDataSource = new DataSource(this);
            mDataSource.open();
            mDataSource.seedTripTable(tripList);

            mRecyclerView = (RecyclerView) findViewById(R.id.rvItems);

            displayTrips(null);

        }

    private void displayTrips(String category) {
        listFromDB = mDataSource.getAllTrips(category);
        mTripAdapter = new TripAdapter(this, listFromDB);
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
                // display all items
        //        displayTrips(null);
                return true;

            case R.id.action_load_db:
                //open the drawer
         //       mDrawerLayout.openDrawer(mDrawerList);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }


}

