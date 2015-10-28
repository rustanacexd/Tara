package com.trytara.tara.adapters.business;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.parse.GetCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseUser;
import com.trytara.tara.R;
import com.trytara.tara.models.Review;

import java.util.List;


public class BusinessReviewsListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static final String TAG = "BusinessReviewsListAdapter";
    private static final int TYPE_HEADER = 0;
    private static final int TYPE_ITEM = 1;

    private List<Review> mDataSet;
    private static Context mContext;

    public BusinessReviewsListAdapter(Context context, List<Review> dataSet) {
        mContext = context;
        mDataSet = dataSet;
    }


    public class VHItem extends RecyclerView.ViewHolder {
        private final ImageView userThumbnail;
        private final TextView userName;
        private final TextView dateReview;
        private final TextView reviewContent;
        private final RatingBar userRating;

        public VHItem(View v) {
            super(v);
            // Define click listener for the ViewHolder's View.
            v.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    /*Intent i = new Intent(mContext, BusinessDetailActivity.class);
                    mContext.startActivity(i);*/
                }
            });

            userName = (TextView) v.findViewById(R.id.user_name);
            userThumbnail = (ImageView) v.findViewById(R.id.user_thumbnail);
            dateReview = (TextView) v.findViewById(R.id.date_review);
            reviewContent = (TextView) v.findViewById(R.id.user_review_content);
            userRating = (RatingBar) v.findViewById(R.id.user_rating);

        }

        public void bindReview(Review review) {

            /*review.getReviewer().fetchIfNeededInBackground(new GetCallback<ParseUser>() {
                @Override
                public void done(ParseUser object, ParseException e) {
                    userName.setText(object.getUsername());
                }
            });*/

            userName.setText(review.getReviewer().getUsername());
            dateReview.setText(review.getCreatedAt().toString());
            reviewContent.setText(review.getContent());
            userRating.setRating((float) review.getRating());
            userThumbnail.setImageResource(R.drawable.restaurant);
        }
    }

    public static class VHHeader extends RecyclerView.ViewHolder {
        Button button;

        public VHHeader(View itemView) {
            super(itemView);
        }
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        // Create a new view.

        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());

        if (viewType == TYPE_ITEM) {
            //inflate your layout and pass it to view holder
            return new VHItem(inflater.inflate(R.layout.review_row_item, viewGroup, false));

        } else if (viewType == TYPE_HEADER) {
            return new VHHeader(inflater.inflate(R.layout.rv_business_reviews_list_header,
                    viewGroup, false));
        }

        throw new RuntimeException("there is no type that matches the type " +
                viewType + " + make sure your using types correctly");

    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof VHItem) {
            VHItem viewHolder = (VHItem) holder;
            viewHolder.bindReview(getItem(position));
        } else if (holder instanceof VHHeader) {
            //cast holder to VHHeader and set data for header.
        }
    }

    @Override
    public int getItemViewType(int position) {
        if (isPositionHeader(position))
            return TYPE_HEADER;

        return TYPE_ITEM;
    }

    private Review getItem(int position) {
        return mDataSet.get(position - 1);
    }

    private boolean isPositionHeader(int position) {
        return position == 0;
    }


    @Override
    public int getItemCount() {
        return mDataSet.size() + 1;
    }
}
