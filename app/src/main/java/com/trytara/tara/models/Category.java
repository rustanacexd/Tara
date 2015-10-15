package com.trytara.tara.models;

public class Category {
    String mCategoryName;
    String mCategoryDescription;
    int mCategoryPictureURL;

    public Category(String categoryName, String categoryDescription, int categoryPictureURL) {
        mCategoryName = categoryName;
        mCategoryDescription = categoryDescription;
        mCategoryPictureURL = categoryPictureURL;
    }

    public String getCategoryName() {
        return mCategoryName;
    }

    public String getCategoryDescription() {
        return mCategoryDescription;
    }


    public int getCategoryPictureURL() {
        return mCategoryPictureURL;
    }

    @Override
    public String toString() {
        return  mCategoryName;
    }
}
