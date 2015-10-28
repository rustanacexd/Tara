package com.trytara.tara.models;

import android.util.Log;

import com.parse.FindCallback;
import com.parse.GetCallback;
import com.parse.ParseClassName;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.ParseUser;
import com.trytara.tara.App;

import java.util.List;

@ParseClassName("Review")
public class Review extends ParseObject {

    private static final String CONTENT = "content";
    private static final String RATING = "rating";
    private static final String REVIEWER = "reviewer";

    public Review() {
    }

    public String getContent() {
        return getString(CONTENT);
    }

    public void setContent(String content) {
        put(CONTENT, content);
        put(REVIEWER, ParseUser.getCurrentUser());
    }

    public double getRating() {
        return getDouble(RATING);
    }

    public void setRating(Double rating) {
        put(RATING, rating);
    }

    public ParseUser getReviewer() {
        return getParseUser(REVIEWER);
    }

    public static void getReviewsByBusiness(String id, final OnGetReviewsByBusinessCallback callback) {
        ParseQuery<Business> businessParseQuery = ParseQuery.getQuery(Business.class);
        businessParseQuery.setCachePolicy(ParseQuery.CachePolicy.CACHE_ELSE_NETWORK);
        businessParseQuery.include("reviews");
        businessParseQuery.getInBackground(id, new GetCallback<Business>() {
            @Override
            public void done(Business business, ParseException e) {
                if (e == null) {
                    if (callback != null) {
                        callback.onGetReviewsByBusiness(business.getReviews());
                    }
                } else {
                    Log.d(App.TAG, e.getLocalizedMessage());
                }
            }
        });

    }


    public interface OnGetReviewsByBusinessCallback {
        void onGetReviewsByBusiness(List<Review> reviewsList);
    }


}
