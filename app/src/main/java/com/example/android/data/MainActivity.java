package com.example.android.data;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.example.android.data.database.DataSource;
import com.example.android.data.model.DataItem;
import com.example.android.data.model.SampleDataProvider;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    TextView tvOut;
    List<DataItem> dataItemList = SampleDataProvider.sDataItemList;
    List<String> itemNames = new ArrayList<>();
    DataSource mDataSource;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            mDataSource = new DataSource(this);
            mDataSource.open();
            mDataSource.seedDataBase(dataItemList);

//            Collections.sort(dataItemList, new Comparator<DataItem>() {
//                @Override
//                public int compare(DataItem dataItem, DataItem t1) {
//                    return dataItem.getItemName().compareTo(t1.getItemName());
//                }
//            });

            List<DataItem> listFromDB = mDataSource.getAllItems();
            DataItemAdapter adapter = new DataItemAdapter(this, listFromDB);

            RecyclerView recyclerView = (RecyclerView) findViewById(R.id.rcView);
            recyclerView.setAdapter(adapter);

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
}

