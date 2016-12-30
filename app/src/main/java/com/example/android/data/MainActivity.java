package com.example.android.data;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.android.data.database.DataSource;
import com.example.android.data.model.DataItem;
import com.example.android.data.model.SampleDataProvider;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<DataItem> dataItemList = SampleDataProvider.sDataItemList;
    DataSource mDataSource;
    List<DataItem> listFromDB;
    DrawerLayout mDrawerLayout;
    ListView mDrawerList;
    String[] mCategories;
    RecyclerView mRecyclerView;
    DataItemAdapter mItemAdapter;


        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            // code to manage sliding drawer
            mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
            mCategories = getResources().getStringArray(R.array.categories);
            mDrawerList = (ListView) findViewById(R.id.left_drawer);
            mDrawerList.setAdapter(new ArrayAdapter<>(this, R.layout.drawer_list_item, mCategories));

            mDrawerList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    String category = mCategories[position];
                    Toast.makeText(MainActivity.this, "You selected "+category, Toast.LENGTH_SHORT).show();
                    mDrawerLayout.closeDrawer(mDrawerList);

                    displayDataItems(category);
                }
            });


            mDataSource = new DataSource(this);
            mDataSource.open();
            mDataSource.seedDataBase(dataItemList);

            SharedPreferences settings = PreferenceManager.getDefaultSharedPreferences(this);
            boolean grid = settings.getBoolean(getString(R.string.pref_display_grid), false);

            mRecyclerView = (RecyclerView) findViewById(R.id.rvItems);
            if (grid) {
                mRecyclerView.setLayoutManager(new GridLayoutManager(this, 3));
            }


            displayDataItems(null);

        }

    private void displayDataItems(String category) {
        listFromDB = mDataSource.getAllItems(category);
        mItemAdapter = new DataItemAdapter(this, listFromDB);
        mRecyclerView.setAdapter(mItemAdapter);
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
        mRecyclerView.refreshDrawableState();
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

            case R.id.action_all_items:
                // display all items
                displayDataItems(null);
                return true;

            case R.id.action_choose_category:
                //open the drawer
                mDrawerLayout.openDrawer(mDrawerList);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }


}

