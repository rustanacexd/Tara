package com.trytara.tara.models;


import com.trytara.tara.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Category {
    public List<CategoryType> mCategoryList = Arrays.asList(
            CategoryType.RESTAURANT,
            CategoryType.COFFEE_SHOP,
            CategoryType.PHARMACY,
            CategoryType.HOTEL,
            CategoryType.COMPUTER_SHOP,
            CategoryType.HARDWARE_STORE,
            CategoryType.BAKERY,
            CategoryType.GYM,
            CategoryType.SCHOOL
    );

    public enum CategoryType {
        RESTAURANT("restaurant",
                "Restaurants",
                R.drawable.restaurant,
                "Lorem ipsum dolor sit amet, consectetur adipisicing elit"),

        COFFEE_SHOP("coffeeshop",
                "Coffee Shops",
                R.drawable.coffee_shop,
                "Lorem ipsum dolor sit amet, consectetur adipisicing elit"),

        PHARMACY("pharmacy",
                "Pharmacies",
                R.drawable.pharmacy,
                "Lorem ipsum dolor sit amet, consectetur adipisicing elit"),

        HOTEL("hotel",
                "Hotels",
                R.drawable.hotels,
                "Lorem ipsum dolor sit amet, consectetur adipisicing elit"),

        COMPUTER_SHOP("computershop",
                "Computer Shops",
                R.drawable.hotels,
                "Lorem ipsum dolor sit amet, consectetur adipisicing elit"),

        HARDWARE_STORE("hardwarestore",
                "Hardware Stores",
                R.drawable.coffee_shop,
                "Lorem ipsum dolor sit amet, consectetur adipisicing elit"),

        BAKERY("bakery",
                "Bakeries",
                R.drawable.restaurant,
                "Lorem ipsum dolor sit amet, consectetur adipisicing elit"),

        GYM("gym",
                "Gyms",
                R.drawable.pharmacy,
                "Lorem ipsum dolor sit amet, consectetur adipisicing elit"),

        SCHOOL("school",
                "Schools",
                R.drawable.hotels,
                "Lorem ipsum dolor sit amet, consectetur adipisicing elit");

        public final String mSlug;
        public final String mTitle;
        public final int mDrawableResource;
        public final String mDescription;

        CategoryType(String name, String title, int drawableResource, String description) {
            mSlug = name;
            mTitle = title;
            mDrawableResource = drawableResource;
            mDescription = description;
        }

        @Override
        public String toString() {
            return mSlug;
        }
    }
}