package com.trytara.tara.adapters.business;

import android.content.Context;
import android.content.Intent;
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

    OnBusinessItemClickListener mListener;

    private List<Item> mDataSet;
    int[] imgList = {R.drawable.hotels, R.drawable.restaurant, R.drawable.coffee_shop,
            R.drawable.pharmacy, R.drawable.hotels, R.drawable.coffee_shop, R.drawable.restaurant,
            R.drawable.pharmacy, R.drawable.hotels, R.drawable.restaurant, R.drawable.coffee_shop,
            R.drawable.pharmacy, R.drawable.hotels, R.drawable.coffee_shop, R.drawable.restaurant,
            R.drawable.pharmacy, R.drawable.hotels, R.drawable.restaurant, R.drawable.coffee_shop,
            R.drawable.pharmacy, R.drawable.hotels, R.drawable.coffee_shop, R.drawable.restaurant,
            R.drawable.pharmacy};

    private static Context mContext;

    public BusinessDetailMenuAdapter(Context context, List<Item> dataSet,
                                     OnBusinessItemClickListener listener) {
        mContext = context;
        mDataSet = dataSet;
        mListener = listener;
    }

    public interface OnBusinessItemClickListener {
        public void onBusinessItemClick(Item item);
    }


    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private final ImageView menuImage;
        private final TextView menuTitle, menuPrice;
        private Item mItem;

        public ViewHolder(View v) {
            super(v);
            // Define click listener for the ViewHolder's View.
            v.setOnClickListener(this);

            menuImage = (ImageView) v.findViewById(R.id.menu_image);
            menuTitle = (TextView) v.findViewById(R.id.menu_title);
            menuPrice = (TextView) v.findViewById(R.id.menu_price);
        }

        public void bindItem(Item item) {
            mItem = item;
            menuTitle.setText(item.getTitle());
            menuPrice.setText(item.getPrice() + " PHP");
        }

        public ImageView getMenuImage() {
            return menuImage;
        }

        @Override
        public void onClick(View v) {
            mListener.onBusinessItemClick(mItem);
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
        viewHolder.bindItem(currentItem);
        viewHolder.getMenuImage().setImageResource(imgList[position]);
    }

    @Override
    public int getItemCount() {
        return mDataSet.size();
    }
}
