package com.example.android.data;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.TextView;

import com.example.android.data.database.TripDataSource;
import com.example.android.data.model.SampleWpDataProvider;
import com.example.android.data.model.WpItem;

import java.util.List;


@SuppressWarnings("FieldCanBeLocal")
public class DetailActivity extends AppCompatActivity {

    private TextView tvName;

    List<WpItem> wpList = SampleWpDataProvider.sWpList;
    TripDataSource mDataSource;
    List<WpItem> listFromDB;
    RecyclerView mRecyclerView;
    WpAdapter mWpAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String id = getIntent().getExtras().getString(TripAdapter.ITEM_KEY);
        if (id == null) {
            throw new AssertionError("Null data index for wp received!");
        }

        Log.d("TBR:", "id received: "+id);

        mDataSource = new TripDataSource(this);
        mDataSource.open();
        mDataSource.seedWpTable(wpList);


        mRecyclerView = (RecyclerView) findViewById(R.id.rvItems);

        displayWps(id);
    }


    private void displayWps(String id) {
        listFromDB = mDataSource.getAllWps(id);
        Log.d("TBR:", "displayWPS with #pts: " + listFromDB.size());
        mWpAdapter = new WpAdapter(this, listFromDB);
        mRecyclerView.setAdapter(mWpAdapter);
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


}