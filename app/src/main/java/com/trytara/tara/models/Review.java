package com.trytara.tara.models;

import com.parse.ParseClassName;
import com.parse.ParseObject;
import com.parse.ParseUser;

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


}
