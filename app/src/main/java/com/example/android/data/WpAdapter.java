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


public class WpAdapter extends RecyclerView.Adapter<WpAdapter.ViewHolder> {
    public static final String ITEM_ID_KEY = "item_id_key";
    public static final String ITEM_KEY = "item_key";


    private List<WpItem> mWpList;
    private Context mContext;
    DataSource mDataSource;

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
        if (position % 2 == 1) {
            holder.mView.setBackgroundColor(Color.LTGRAY);
        } else {
            holder.mView.setBackgroundColor(Color.parseColor("#A4A4A4"));
        }
        // This is the place to add event listeners
        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(mContext, "You selected "+wp.getWpName(), Toast.LENGTH_SHORT).show();

            }
        });

        holder.mView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {

                Toast.makeText(mContext, "You will be deleting id:"+wp.getWpId(), Toast.LENGTH_SHORT).show();

                return false;
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
