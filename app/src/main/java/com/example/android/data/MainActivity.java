package com.example.android.data;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.android.data.model.DataItem;
import com.example.android.data.model.SampleDataProvider;

import java.util.ArrayList;
import java.util.Collections;
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

            for (DataItem item :
                    dataItemList) {
                itemNames.add(item.getItemName());
            }
            Collections.sort(itemNames);

            ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, itemNames);
            ListView listView = (ListView) findViewById(list);
            listView.setAdapter(adapter);

        }
}

