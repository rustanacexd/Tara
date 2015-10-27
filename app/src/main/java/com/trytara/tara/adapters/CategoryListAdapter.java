package com.trytara.tara.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.trytara.tara.MapsActivity;
import com.trytara.tara.R;
import com.trytara.tara.models.Category;

import java.util.List;

public class CategoryListAdapter extends RecyclerView.Adapter<CategoryListAdapter.ViewHolder> {
    private static final String TAG = "CategoryListAdapter";

    private List<Category.CategoryItem> mDataSet;
    private static Context mContext;

    public CategoryListAdapter(Context context, List<Category.CategoryItem> dataSet) {
        mContext = context;
        mDataSet = dataSet;
    }


    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private final ImageView categoryImage;
        private final TextView categoryName;
        private final TextView categoryDescription;
        private Category.CategoryItem mCategoryItem;

        public ViewHolder(View v) {
            super(v);
            // Define click listener for the ViewHolder's View.
            v.setOnClickListener(this);

            categoryImage = (ImageView) v.findViewById(R.id.category_image);
            categoryName = (TextView) v.findViewById(R.id.category_name);
            categoryDescription = (TextView) v.findViewById(R.id.category_descripton);
        }

        public void bindCategory(Category.CategoryItem categoryItem) {
            mCategoryItem = categoryItem;
            categoryImage.setImageResource(mCategoryItem.mDrawableResource);
            categoryName.setText(mCategoryItem.mName);
            categoryDescription.setText(mCategoryItem.mDescription);
        }

        @Override
        public void onClick(View v) {
            Intent i = MapsActivity.newIntent(mContext, mCategoryItem.mName, mCategoryItem.mSlug);
            mContext.startActivity(i);
        }
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        // Create a new view.
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.category_row_item, viewGroup, false);

        return new ViewHolder(v);
    }


    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int position) {
        //Log.d(TAG, "Element " + position + " set.");
        viewHolder.bindCategory(mDataSet.get(position));
    }

    @Override
    public int getItemCount() {
        return mDataSet.size();
    }
}
