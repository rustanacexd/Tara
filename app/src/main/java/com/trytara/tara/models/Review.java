package com.trytara.tara.models;

import android.util.Log;

import com.parse.FindCallback;
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
    private static final String REVIEWED_BY = "reviewedBy";
    private static final String REVIEWED_TO = "reviewedTo";

    public Review() {
    }

    public String getContent() {
        return getString(CONTENT);
    }

    public void setContent(String content) {
        put(CONTENT, content);
        put(REVIEWED_BY, ParseUser.getCurrentUser());
    }

    public double getRating() {
        return getDouble(RATING);
    }

    public void setRating(Double rating) {
        put(RATING, rating);
    }

    public ParseUser getReviewer() {
        return getParseUser(REVIEWED_BY);
    }

    public void setReviewedTo(ParseObject object) {
        put(REVIEWED_TO, object);
    }

    public ParseObject getReviewedTo() {
        return getParseObject(REVIEWED_TO);
    }

    public static void getReviewsByBusiness(Business business,
                                            final OnGetReviewsByBusinessCallback callback) {
        ParseQuery<Review> reviewParseQuery = ParseQuery.getQuery(Review.class);
        reviewParseQuery.setCachePolicy(ParseQuery.CachePolicy.NETWORK_ONLY);
        reviewParseQuery.setLimit(15);
        reviewParseQuery.whereEqualTo(REVIEWED_TO, business);
        reviewParseQuery.include(REVIEWED_BY);
        reviewParseQuery.findInBackground(new FindCallback<Review>() {
            @Override
            public void done(List<Review> list, ParseException e) {
                if (e == null) {
                    if (callback != null) {
                        callback.onGetReviewsByBusiness(list);
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
