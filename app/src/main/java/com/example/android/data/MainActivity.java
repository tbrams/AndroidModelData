package com.example.android.data;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.example.android.data.model.DataItem;
import com.example.android.data.model.SampleDataProvider;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    TextView tvOut;
    List<DataItem> dataItemList = SampleDataProvider.sDataItemList;


        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            tvOut = (TextView) findViewById(R.id.out);
            tvOut.setText("");

            // Sort items alphabetically
            Collections.sort(dataItemList, new Comparator<DataItem>() {
                @Override
                public int compare(DataItem dataItem, DataItem t1) {
                    return dataItem.getItemName().compareTo(t1.getItemName());
                }
            });

            for (DataItem item :
                    dataItemList) {
                tvOut.append(item.getItemName()+"\n");

            }

        }
}
