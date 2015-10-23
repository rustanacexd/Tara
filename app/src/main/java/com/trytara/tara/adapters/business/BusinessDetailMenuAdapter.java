package com.trytara.tara.adapters.business;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.trytara.tara.BusinessItemDetailActivity;
import com.trytara.tara.R;
import com.trytara.tara.models.Business.Item;

import java.util.List;

public class BusinessDetailMenuAdapter extends RecyclerView.Adapter<BusinessDetailMenuAdapter.ViewHolder> {

    private static final String TAG = "BusinessDetailMenuAdapter";

    private List<Item> mDataSet;
    int[] imgList = {R.drawable.hotels, R.drawable.restaurant, R.drawable.coffee_shop,
            R.drawable.pharmacy, R.drawable.hotels, R.drawable.coffee_shop, R.drawable.restaurant,
            R.drawable.pharmacy, R.drawable.hotels, R.drawable.restaurant, R.drawable.coffee_shop,
            R.drawable.pharmacy, R.drawable.hotels, R.drawable.coffee_shop, R.drawable.restaurant,
            R.drawable.pharmacy, R.drawable.hotels, R.drawable.restaurant, R.drawable.coffee_shop,
            R.drawable.pharmacy, R.drawable.hotels, R.drawable.coffee_shop, R.drawable.restaurant,
            R.drawable.pharmacy};

    private static Context mContext;

    public BusinessDetailMenuAdapter(Context context, List<Item> dataSet) {
        mContext = context;
        mDataSet = dataSet;
    }


    public static class ViewHolder extends RecyclerView.ViewHolder {

        private final ImageView menuImage;
        private final TextView menuTitle, menuPrice;

        public ViewHolder(View v) {
            super(v);
            // Define click listener for the ViewHolder's View.
            v.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i = new Intent(mContext, BusinessItemDetailActivity.class);
                    mContext.startActivity(i);
                }
            });

            menuImage = (ImageView) v.findViewById(R.id.menu_image);
            menuTitle = (TextView) v.findViewById(R.id.menu_title);
            menuPrice = (TextView) v.findViewById(R.id.menu_price);
        }

        public ImageView getMenuImage() {
            return menuImage;
        }

        public TextView getMenuTitle() {
            return menuTitle;
        }

        public TextView getMenuPrice() {
            return menuPrice;
        }
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        // Create a new view.
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.business_menu_row_item, viewGroup, false);

        return new ViewHolder(v);
    }


    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int position) {
        //Log.d(TAG, "Element " + position + " set.");
        Item currentItem = mDataSet.get(position);
        viewHolder.getMenuTitle().setText(currentItem.getTitle());
        viewHolder.getMenuPrice().setText("PHP " + currentItem.getPrice());
        viewHolder.getMenuImage().setImageResource(imgList[position]);
    }

    @Override
    public int getItemCount() {
        return mDataSet.size();
    }
}
