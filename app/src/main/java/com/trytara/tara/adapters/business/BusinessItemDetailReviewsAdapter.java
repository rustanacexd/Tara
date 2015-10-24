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

import com.trytara.tara.R;
import com.trytara.tara.models.Business.Review;
import com.trytara.tara.models.Business.Item;

import java.util.ArrayList;
import java.util.List;

public class BusinessItemDetailReviewsAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static final int TYPE_HEADER = 0;
    private static final int TYPE_ITEM = 1;
    List<Review> mReviews = new ArrayList<>();
    private Item mItem;

    public BusinessItemDetailReviewsAdapter(Item item) {
        mItem = item;
        mReviews = item.getReviews();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(parent.getContext());

        if (viewType == TYPE_ITEM) {
            //inflate your layout and pass it to view holder
            return new VHItem(inflater.inflate(R.layout.business_item_detail_review_row,
                    parent, false));

        } else if (viewType == TYPE_HEADER) {
            return new VHHeader(inflater.inflate(R.layout.rv_business_item_menu_reviews_header,
                    parent, false));
        }

        throw new RuntimeException("there is no type that matches the type " + viewType + " + make sure your using types correctly");
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof VHItem) {
        } else if (holder instanceof VHHeader) {
            //cast holder to VHHeader and set data for header.
            ((VHHeader) holder).bindItem(mItem);
        }


    }

    @Override
    public int getItemCount() {
        return mReviews.size() + 1;
    }

    @Override
    public int getItemViewType(int position) {
        if (isPositionHeader(position))
            return TYPE_HEADER;

        return TYPE_ITEM;
    }

    private boolean isPositionHeader(int position) {
        return position == 0;
    }

    private Review getItem(int position) {
        return mReviews.get(position - 1);
    }

    public static class VHItem extends RecyclerView.ViewHolder {

        public VHItem(View itemView) {
            super(itemView);
        }
    }

    public static class VHHeader extends RecyclerView.ViewHolder {
        private final TextView itemTitle;
        private final TextView itemPrice;

        public VHHeader(View itemView) {
            super(itemView);
            itemTitle = (TextView) itemView.findViewById(R.id.item_title);
            itemPrice = (TextView) itemView.findViewById(R.id.item_price);
        }

        public void bindItem(Item item) {
            itemTitle.setText(item.getTitle());
            itemPrice.setText(item.getPrice() + " PHP");
        }
    }
}
