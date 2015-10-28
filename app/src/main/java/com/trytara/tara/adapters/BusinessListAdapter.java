package com.trytara.tara.adapters;

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

public class BusinessListAdapter extends RecyclerView.Adapter<BusinessListAdapter.ViewHolder> {
    private static final String TAG = "BusinessListAdapter";

    private OnBusinessListItemClickListener mListener;

    private List<Business> mDataSet;
    private static Context mContext;

    public BusinessListAdapter(Context context, List<Business> dataSet, OnBusinessListItemClickListener listener) {
        mContext = context;
        mDataSet = dataSet;
        mListener = listener;
    }

    public interface OnBusinessListItemClickListener {
        void OnBusinessListItemClick(Business business);
    }


    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private final TextView businessName;
        private final TextView businessCategory;
        private final TextView businessDistance;
        private final ImageView businessThumbnail;
        private Business mBusiness;
        private final RatingBar mBusinessRating;

        public ViewHolder(View v) {
            super(v);
            // Define click listener for the ViewHolder's View.
            v.setOnClickListener(this);

            businessName = (TextView) v.findViewById(R.id.business_name);
            businessCategory = (TextView) v.findViewById(R.id.business_category);
            businessThumbnail = (ImageView) v.findViewById(R.id.business_thumbnail);
            businessDistance = (TextView) v.findViewById(R.id.business_distance);
            mBusinessRating = (RatingBar) v.findViewById(R.id.business_rating);

        }

        public void bindBusiness(Business business) {
            mBusiness = business;
            businessName.setText(mBusiness.getName());
            businessCategory.setText(String.format("%s%s", mBusiness.getCategory().substring(0, 1).toUpperCase(),
                    mBusiness.getCategory().substring(1)));

            mBusinessRating.setRating(mBusiness.averageRate());
            businessDistance.setText("82km");
        }


        @Override
        public void onClick(View v) {
            mListener.OnBusinessListItemClick(mDataSet.get(getAdapterPosition()));
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
        viewHolder.bindBusiness(business);
    }

    @Override
    public int getItemCount() {
        return mDataSet.size();
    }
}
