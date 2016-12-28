package com.example.android.data;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.example.android.data.model.DataItem;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        DataItem item = getIntent().getExtras().getParcelable(DataItemAdapter.ITEM_KEY);

        if (item != null) {
            Toast.makeText(this, "Received item "+item.getItemName(), Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Did not receive anything", Toast.LENGTH_SHORT).show();
        }
    }
}
