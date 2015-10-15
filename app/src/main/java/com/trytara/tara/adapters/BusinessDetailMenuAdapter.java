package com.trytara.tara.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.trytara.tara.BusinessDetailActivity;
import com.trytara.tara.R;
import com.trytara.tara.models.Business;

import java.util.List;

public class BusinessDetailMenuAdapter extends RecyclerView.Adapter<BusinessDetailMenuAdapter.ViewHolder>{

    private static final String TAG = "BusinessDetailMenuAdapter";

    private List<Business> mDataSet;
    private Context mContext;

    public BusinessDetailMenuAdapter(Context context, List<Business> dataSet) {
        mContext = context;
        mDataSet = dataSet;
    }


    public class ViewHolder extends RecyclerView.ViewHolder{
        private final TextView businessName;
        private final TextView businessDescription;
        private final TextView businessDistance;
        private final ImageView businessThumbnail;

        public ViewHolder(View v) {
            super(v);
            // Define click listener for the ViewHolder's View.
            v.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i = new Intent(mContext, BusinessDetailActivity.class);
                    mContext.startActivity(i);
                }
            });

            businessName = (TextView) v.findViewById(R.id.business_name);
            businessDescription = (TextView) v.findViewById(R.id.business_description);
            businessThumbnail = (ImageView) v.findViewById(R.id.business_thumbnail);
            businessDistance = (TextView) v.findViewById(R.id.business_distance);

        }

        public TextView getBusinessDistance() {
            return businessDistance;
        }

        public TextView getBusinessName() {
            return businessName;
        }

        public TextView getBusinessDescription() {
            return businessDescription;
        }

        public ImageView getBusinessThumbnail() {
            return businessThumbnail;
        }

    }



    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        // Create a new view.
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.business_row_item, viewGroup, false);

        return new ViewHolder(v);
    }


    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int position) {
        //Log.d(TAG, "Element " + position + " set.");

        Business business = mDataSet.get(position);
        viewHolder.getBusinessName().setText(business.getName());
        viewHolder.getBusinessDescription().setText(business.getDescription());
        viewHolder.getBusinessDistance().setText("82km");
    }

    @Override
    public int getItemCount() {
        return mDataSet.size();
    }
}