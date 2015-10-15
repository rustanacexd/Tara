package com.trytara.tara.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.trytara.tara.R;

public class BusinessStaffAdapter extends RecyclerView.Adapter<BusinessStaffAdapter.ViewHolder> {

    private static final String TAG = "BusinessStaffAdapter";

    //private List<Business> mDataSet;
    int[] imgList = { R.drawable.hotels, R.drawable.restaurant, R.drawable.coffee_shop,
            R.drawable.pharmacy, R.drawable.hotels, R.drawable.coffee_shop, R.drawable.restaurant,
            R.drawable.pharmacy, R.drawable.hotels, R.drawable.restaurant, R.drawable.coffee_shop,
            R.drawable.pharmacy, R.drawable.hotels, R.drawable.coffee_shop, R.drawable.restaurant,
            R.drawable.pharmacy, R.drawable.hotels, R.drawable.restaurant, R.drawable.coffee_shop,
            R.drawable.pharmacy, R.drawable.hotels, R.drawable.coffee_shop, R.drawable.restaurant,
            R.drawable.pharmacy };

    private static Context mContext;

    public BusinessStaffAdapter(Context context) {
        mContext = context;
        //mDataSet = dataSet;
    }


    public static class ViewHolder extends RecyclerView.ViewHolder {

        private final ImageView staffImage;

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

            staffImage = (ImageView) v.findViewById(R.id.staff_image);

        }

        public ImageView getStaffImage() {
            return staffImage;
        }

    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        // Create a new view.
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.staff_row_item, viewGroup, false);

        return new ViewHolder(v);
    }


    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int position) {
        //Log.d(TAG, "Element " + position + " set.");
        viewHolder.getStaffImage().setImageResource(imgList[position]);
    }

    @Override
    public int getItemCount() {
        return imgList.length;
    }
}
