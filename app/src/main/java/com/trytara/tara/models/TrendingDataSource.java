package com.trytara.tara.models;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

public class TrendingDataSource {
    private List<Trending> mTrendingList;
    private Context mContext;

    public TrendingDataSource(Context context) {
        mContext = context.getApplicationContext();
        mTrendingList = createTrendingList();
    }

    private List<Trending> createTrendingList() {
        List<Trending> trendingList = new ArrayList<>();

        for (int i = 0; i <= 30; i++) {
            trendingList.add(new Trending("Trending Sharer Username " + i, "#Dummyhashtag",
                    "Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod\n" +
                            "tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam,\n" +
                            "quis "));
        }

        return trendingList;
    }

    public List<Trending> getTrendingList() {
        return mTrendingList;
    }
}
