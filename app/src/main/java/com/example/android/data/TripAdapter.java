package com.example.android.data;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.android.data.model.TripItem;

import java.util.List;

public class TripAdapter extends RecyclerView.Adapter<TripAdapter.ViewHolder> {

    public static final String ITEM_ID_KEY = "item_id_key";
    public static final String ITEM_KEY = "item_key";

    private Color mColor;
    private List<TripItem>  mTrips;
    private Context         mContext;

    /*
     * constructor
     * Keep context and a copy of the data list
     */
    public TripAdapter(Context context, List<TripItem> trips) {
        this.mContext = context;
        this.mTrips = trips;
    }


    /*
     * Prepare the list_element layout for new list elements
     */
    @Override
    public TripAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(mContext);
        View itemView = inflater.inflate(R.layout.list_element, parent, false);

        ViewHolder viewHolder = new ViewHolder(itemView);
        return viewHolder;
    }

    /*
     * Display list item number(position) using handles from ViewHolder
     * Also alternate background color on uneven rows
     */
    @Override
    public void onBindViewHolder(TripAdapter.ViewHolder holder, int position) {
        final TripItem trip = mTrips.get(position);

        holder.tvName.setText(trip.getTripName());
        holder.tvDist.setText(String.format("%.2f nm",trip.getTripDistance()));
        holder.tvDate.setText(trip.getTripDate());

        if (position % 2 == 1) {
            holder.mView.setBackgroundColor(Color.LTGRAY);
        } else {
            holder.mView.setBackgroundColor(Color.parseColor("#A4A4A4"));
        }

        // Set click handler for this list element
        // Forward the id of the element to next activity
        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String id = trip.getTripId();
                Intent intent = new Intent(mContext, DetailActivity.class);
                intent.putExtra(ITEM_KEY, id);
                mContext.startActivity(intent);
            }
        });
    }


    @Override
    public int getItemCount() {
        return mTrips.size();
    }


    /*
     * Get handle to fields for display and the layout view because
     * We might need to alternate the background color
     */
    public static class ViewHolder extends RecyclerView.ViewHolder {

        public TextView tvName;
        public TextView tvDist;
        public TextView tvDate;
        public View     mView;

        public ViewHolder(View itemView) {
            super(itemView);
            mView = itemView;
            tvName = (TextView) itemView.findViewById(R.id.tripNameText);
            tvDist = (TextView) itemView.findViewById(R.id.tripDistText);
            tvDate = (TextView) itemView.findViewById(R.id.tripDateText);
        }
    }
}