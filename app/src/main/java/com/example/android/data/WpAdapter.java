package com.example.android.data;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.android.data.model.WpItem;

import java.util.List;


public class WpAdapter extends RecyclerView.Adapter<WpAdapter.ViewHolder> {
    public static final String ITEM_ID_KEY = "item_id_key";
    public static final String ITEM_KEY = "item_key";


    private List<WpItem> mWpList;
    private Context mContext;

    public WpAdapter(Context context, List<WpItem> wps) {
        this.mContext = context;
        this.mWpList = wps;
    }



    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(mContext);
        View itemView = inflater.inflate(R.layout.list_element, parent, false);
        WpAdapter.ViewHolder viewHolder = new WpAdapter.ViewHolder(itemView);
        return viewHolder;
    }



    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final WpItem wp = mWpList.get(position);

        holder.tvName.setText(wp.getWpName());
//        holder.tvDist.setText(String.format("%.2f nm",trip.getTripDistance()));
//        holder.tvDate.setText(trip.getTripDate());

        if (position % 2 == 1) {
            holder.mView.setBackgroundColor(Color.LTGRAY);
        }
        // This is the place to add event listeners
        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(mContext, "You selected "+wp.getWpName(), Toast.LENGTH_SHORT).show();

//                String id = trip.getTripId();
//                Intent intent = new Intent(mContext, DetailActivity.class);
//                intent.putExtra(ITEM_KEY, trip);
//                mContext.startActivity(intent);
            }
        });


    }

    @Override
    public int getItemCount() {
        return mWpList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView tvName;
        public TextView tvDist;
        public TextView tvDate;
        public View mView;

        public ViewHolder(View itemView) {
            super(itemView);
            mView = itemView;
            tvName = (TextView) itemView.findViewById(R.id.tripNameText);
            tvDist = (TextView) itemView.findViewById(R.id.tripDistText);
            tvDate = (TextView) itemView.findViewById(R.id.tripDateText);
        }
    }
}
