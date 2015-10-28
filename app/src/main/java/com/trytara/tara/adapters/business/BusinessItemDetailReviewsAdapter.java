package com.trytara.tara.adapters.business;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.trytara.tara.R;
import com.trytara.tara.models.Item;
import com.trytara.tara.models.Review;

import java.util.ArrayList;
import java.util.List;

public class BusinessItemDetailReviewsAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    List<Review> mReviews = new ArrayList<>();
    private Item mItem;

    public BusinessItemDetailReviewsAdapter(Item item) {
        mItem = item;
        //mReviews = item.getReviews();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        return new ViewHolder(inflater.inflate(R.layout.business_item_detail_review_row,
                parent, false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return mReviews.size();
    }


    public static class ViewHolder extends RecyclerView.ViewHolder {

        public ViewHolder(View itemView) {
            super(itemView);
        }
    }

}
