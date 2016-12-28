package com.example.android.data;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;
import android.widget.TextView;

import com.example.android.data.model.DataItem;
import com.example.android.data.model.SampleDataProvider;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static android.R.id.list;

public class MainActivity extends AppCompatActivity {

    TextView tvOut;
    List<DataItem> dataItemList = SampleDataProvider.sDataItemList;
    List<String> itemNames = new ArrayList<>();

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            Collections.sort(dataItemList, new Comparator<DataItem>() {
                @Override
                public int compare(DataItem dataItem, DataItem t1) {
                    return dataItem.getItemName().compareTo(t1.getItemName());
                }
            });

            DataItemAdapter adapter = new DataItemAdapter(this, dataItemList);

            ListView listView = (ListView) findViewById(list);
            listView.setAdapter(adapter);

        }
}

