package com.trytara.tara.adapters.business;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.trytara.tara.R;
import com.trytara.tara.models.Business;

import java.util.List;

public class BusinessItemDetailReviewsAdapter extends RecyclerView.Adapter<BusinessItemDetailReviewsAdapter.ViewHolder> {
    private static final String TAG = "BusinessItemDetailReviewsAdapter";

    private List<Business.Review> mDataSet;
    private static Context mContext;

    public BusinessItemDetailReviewsAdapter() {
//        mContext = context;
//        mDataSet = dataSet;
    }


    public static class ViewHolder extends RecyclerView.ViewHolder {


        public ViewHolder(View v) {
            super(v);
            // Define click listener for the ViewHolder's View.
            v.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    /*Intent i = new Intent(mContext, BusinessDetailActivity.class);
                    mContext.startActivity(i);*/
                }
            });


        }


    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        // Create a new view.
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.business_item_detail_review_row, viewGroup, false);

        return new ViewHolder(v);
    }


    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int position) {
        //Log.d(TAG, "Element " + position + " set.");

        //Business.Review review = mDataSet.get(position);

    }

    @Override
    public int getItemCount() {
//        return mDataSet.size();
        return 10;
    }
}
