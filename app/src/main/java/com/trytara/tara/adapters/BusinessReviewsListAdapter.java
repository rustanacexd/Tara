package com.trytara.tara.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.trytara.tara.BusinessDetailActivity;
import com.trytara.tara.R;
import com.trytara.tara.models.Business;

import java.util.List;

import static com.trytara.tara.models.Business.*;

public class BusinessReviewsListAdapter extends RecyclerView.Adapter<BusinessReviewsListAdapter.ViewHolder> {
    private static final String TAG = "BusinessReviewsListAdapter";

    private List<Review> mDataSet;
    private static Context mContext;

    public BusinessReviewsListAdapter(Context context, List<Review> dataSet) {
        mContext = context;
        mDataSet = dataSet;
    }


    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final ImageView userThumbnail;
        private final TextView userName;
        private final TextView dateReview;
        private final TextView reviewContent;
        private final RatingBar userRating;

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

            userName = (TextView) v.findViewById(R.id.user_name);
            userThumbnail = (ImageView) v.findViewById(R.id.user_thumbnail);
            dateReview = (TextView) v.findViewById(R.id.date_review);
            reviewContent = (TextView) v.findViewById(R.id.user_review_content);
            userRating = (RatingBar) v.findViewById(R.id.user_rating);

        }


        public TextView getUserName() {
            return userName;
        }

        public ImageView getUserThumbnail() {
            return userThumbnail;
        }

        public TextView getDateReview() {
            return dateReview;
        }

        public TextView getReviewContent() {
            return reviewContent;
        }

        public RatingBar getUserRating() {
            return userRating;
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

        Review review = mDataSet.get(position);
        viewHolder.getUserName().setText(review.getReviewer());
        viewHolder.getDateReview().setText(review.getDate().toString());
        viewHolder.getUserRating().setRating(review.getRating());
        viewHolder.getUserThumbnail().setImageResource(R.drawable.hotels);
        viewHolder.getReviewContent().setText(review.getContent());
    }

    @Override
    public int getItemCount() {
        return mDataSet.size();
    }
}
