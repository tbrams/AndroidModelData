package com.example.android.data;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.android.data.model.TripItem;

import java.util.List;


public class DataItemAdapterListView extends ArrayAdapter<TripItem> {
    List<TripItem> mTripItems;
    LayoutInflater mLayoutInflater;

    public DataItemAdapterListView(Context context, List<TripItem> objects) {
        super(context, R.layout.list_element, objects);

        mTripItems=objects;
        mLayoutInflater = LayoutInflater.from(context);
    }


    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = mLayoutInflater.inflate(R.layout.list_element, parent, false);
        }

        TextView textView = (TextView) convertView.findViewById(R.id.itemNameText);
        ImageView imageView = (ImageView) convertView.findViewById(R.id.imageView);

        TripItem trip = mTripItems.get(position);
        textView.setText(trip.getTripName());

        return convertView;
    }
}
