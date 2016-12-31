package com.example.android.data;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.android.data.model.WpItem;

import java.util.List;


public class WpAdapterListView extends ArrayAdapter {
    List<WpItem> mWpItemList;
    LayoutInflater mLayoutInflater;



    public WpAdapterListView(Context context, List<WpItem> objects) {
        super(context, R.layout.list_element, objects);

        mWpItemList=objects;
        mLayoutInflater = LayoutInflater.from(context);
    }


    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = mLayoutInflater.inflate(R.layout.list_element, parent, false);
        }

        TextView textView = (TextView) convertView.findViewById(R.id.tripNameText);

        WpItem wp = mWpItemList.get(position);
        textView.setText(wp.getWpName());

        return convertView;
    }
}

