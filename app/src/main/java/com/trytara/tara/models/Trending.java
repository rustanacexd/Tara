package com.trytara.tara.models;


import java.util.List;

public class Trending {
    private String mUsername;
    private String mHashTags;
    private String mContent;

    public Trending(String username, String hashTags, String content) {
        mUsername = username;
        mHashTags = hashTags;
        mContent = content;
    }

    public String getUsername() {
        return mUsername;
    }

    public String getHashTags() {
        return mHashTags;
    }

    public String getContent() {
        return mContent;
    }
}
