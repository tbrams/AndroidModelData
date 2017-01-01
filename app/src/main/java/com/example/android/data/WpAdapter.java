package com.example.android.data;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.android.data.database.DataSource;
import com.example.android.data.model.WpItem;

import java.util.List;


public class WpAdapter extends RecyclerView.Adapter<WpAdapter.ViewHolder>  {
    public static final String ITEM_ID_KEY = "item_id_key";
    public static final String ITEM_KEY = "item_key";

    private List<WpItem> mWpList;
    private Context    mContext;
    private DataSource mDataSource;


    // Constructor
    // Keep context reference and a copy of the data list
    public WpAdapter(Context context, List<WpItem> wps) {
        this.mContext = context;
        this.mWpList = wps;

        // Get a handle to the database helper and prepare the database
        mDataSource = new DataSource(mContext);
        mDataSource.open();
    }



    /*
     * Inflate the list item view and wrap it in a ViewHolder
     */
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(mContext);
        View view = inflater.inflate(R.layout.list_element, parent, false);
        WpAdapter.ViewHolder viewHolder = new WpAdapter.ViewHolder(view);

        return viewHolder;
    }



    /*
     * Get the object at the indicated position in the list of objects
     * and bind data to the fields of the ViewHolder.
     *
     * Also alternate the background color of the entire view
     *
     */
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        holder.tvName.setText(mWpList.get(position).getWpName());
        if (position % 2 == 1) {
            holder.itemView.setBackgroundColor(Color.LTGRAY);
        } else {
            holder.itemView.setBackgroundColor(Color.parseColor("#A4A4A4"));
        }

    }

    @Override
    public int getItemCount() {
        return mWpList.size();
    }




    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnLongClickListener{
        public TextView tvName;
        public TextView tvDist;
        public TextView tvDate;

        public ViewHolder(View itemView) {
            super(itemView);

            tvName = (TextView) itemView.findViewById(R.id.tripNameText);
            tvDist = (TextView) itemView.findViewById(R.id.tripDistText);
            tvDate = (TextView) itemView.findViewById(R.id.tripDateText);

            itemView.setOnClickListener(this);
            itemView.setOnLongClickListener(this);
        }

        @Override
        public void onClick(View view) {
            // First get a copy of the item to be deleted
            WpItem wp= mWpList.get(this.getAdapterPosition());

            Toast.makeText(mContext, "You selected "+wp.getWpName(), Toast.LENGTH_SHORT).show();
        }


        /*
         * This is the severe action - delete the Way Point
         */
        @Override
        public boolean onLongClick(View view) {

            // First get a copy of the item to be deleted
            WpItem wp= mWpList.get(this.getAdapterPosition());
            Toast.makeText(mContext, "Long click on "+wp.getWpName(), Toast.LENGTH_SHORT).show();

            // Remove from the list and update the listview
            mWpList.remove(this.getAdapterPosition());
            notifyDataSetChanged();

            Toast.makeText(mContext, "You deleted "+wp.getWpName(), Toast.LENGTH_SHORT).show();

            // Drop from database
            mDataSource.deleteWp(wp);

            return false;
        }
    }
}
