package com.example.android.data;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.android.data.model.TripItem;

import java.util.List;

public class DataItemAdapter extends RecyclerView.Adapter<DataItemAdapter.ViewHolder> {

    public static final String ITEM_ID_KEY = "item_id_key";
    public static final String ITEM_KEY = "item_key";
    private List<TripItem> mTrips;
    private Context mContext;

    public DataItemAdapter(Context context, List<TripItem> trips) {
        this.mContext = context;
        this.mTrips = trips;
    }

    @Override
    public DataItemAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        SharedPreferences settings = PreferenceManager.getDefaultSharedPreferences(mContext);
        boolean grid = settings.getBoolean(mContext.getString(R.string.pref_display_grid), false);
        int layoutId = grid? R.layout.grid_item : R.layout.list_element;

        LayoutInflater inflater = LayoutInflater.from(mContext);
        View itemView = inflater.inflate(layoutId, parent, false);
        ViewHolder viewHolder = new ViewHolder(itemView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(DataItemAdapter.ViewHolder holder, int position) {
        final TripItem trip = mTrips.get(position);

        holder.tvName.setText(trip.getTripName());

        // This is the place to add event listeners
        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Toast.makeText(mContext, "You selected "+trip.getTripName(), Toast.LENGTH_SHORT).show();

                String id = trip.getTripId();
                Intent intent = new Intent(mContext, DetailActivity.class);
                intent.putExtra(ITEM_KEY, trip);
                mContext.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mTrips.size();
    }


    public static class ViewHolder extends RecyclerView.ViewHolder {

        public TextView tvName;
        public View mView;
        public ViewHolder(View itemView) {
            super(itemView);
            mView = itemView;
            tvName = (TextView) itemView.findViewById(R.id.itemNameText);
        }
    }
}