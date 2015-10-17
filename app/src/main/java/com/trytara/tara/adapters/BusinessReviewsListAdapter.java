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

public class BusinessReviewsListAdapter extends RecyclerView.Adapter<BusinessReviewsListAdapter.ViewHolder> {
    private static final String TAG = "BusinessReviewsListAdapter";

    private List<Business> mDataSet;
    private static Context mContext;

    public BusinessReviewsListAdapter(Context context, List<Business> dataSet) {
        mContext = context;
        mDataSet = dataSet;
    }


    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView businessName;

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


        }


        public TextView getBusinessName() {
            return businessName;
        }


    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        // Create a new view.
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.review_row_item, viewGroup, false);

        return new ViewHolder(v);
    }


    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int position) {
        //Log.d(TAG, "Element " + position + " set.");

        Business review = mDataSet.get(position);
        viewHolder.getBusinessName().setText("");

    }

    @Override
    public int getItemCount() {
        return mDataSet.size();
    }
}
