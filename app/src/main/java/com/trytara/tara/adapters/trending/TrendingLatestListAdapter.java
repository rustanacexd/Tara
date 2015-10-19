package com.trytara.tara.adapters.trending;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.trytara.tara.R;
import com.trytara.tara.models.Trending;

import java.util.List;

public class TrendingLatestListAdapter extends RecyclerView.Adapter<TrendingLatestListAdapter.ViewHolder> {
    private static final String TAG = "TrendingLatestListAdapter";

    private List<Trending> mDataSet;
    private static Context mContext;

    public TrendingLatestListAdapter(Context context, List<Trending> dataSet) {
        mContext = context;
        mDataSet = dataSet;
    }


    public static class ViewHolder extends RecyclerView.ViewHolder {

        private final ImageView userImage;
        private final TextView userName;
        private final TextView hashTags;
        private final ImageView trendingImage;
        private final TextView trendingContent;


        public ViewHolder(View v) {
            super(v);
            // Define click listener for the ViewHolder's View.
            userImage = (ImageView) v.findViewById(R.id.user_image);
            userName = (TextView) v.findViewById(R.id.user_name);
            hashTags = (TextView) v.findViewById(R.id.hash_tags);
            trendingImage = (ImageView) v.findViewById(R.id.trending_image);
            trendingContent = (TextView) v.findViewById(R.id.trending_content);
        }

        public ImageView getUserImage() {
            return userImage;
        }

        public TextView getUserName() {
            return userName;
        }

        public TextView getHashTags() {
            return hashTags;
        }

        public ImageView getTrendingImage() {
            return trendingImage;
        }

        public TextView getTrendingContent() {
            return trendingContent;
        }
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        // Create a new view.
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.trending_latest_row_item, viewGroup, false);

        return new ViewHolder(v);
    }


    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int position) {
        //Log.d(TAG, "Element " + position + " set.");

        Trending trending = mDataSet.get(position);
        viewHolder.getUserImage().setImageResource(R.drawable.hotels);
        viewHolder.getUserName().setText(trending.getUsername());
        viewHolder.getHashTags().setText(trending.getHashTags());
        viewHolder.getTrendingContent().setText(trending.getContent());

    }

    @Override
    public int getItemCount() {
        return mDataSet.size();
    }
}
