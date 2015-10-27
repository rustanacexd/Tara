package com.trytara.tara.models;

import com.trytara.tara.R;

import java.util.ArrayList;
import java.util.List;


public class Category {

    public enum CategoryType {
        RESTAURANT, COFFEE_SHOP, PHARMACY, HOTEL, COMPUTER_SHOP, HARDWARE_STORE, BAKERY, GYM, SCHOOLS
    }

    private List<CategoryItem> mCategoryItemsList = new ArrayList<>();

    public Category() {
        addItem(new CategoryItem("Restaurants", "Lorem ipsum dolor sit amet dipisicing elit",
                R.drawable.restaurant, CategoryType.RESTAURANT));

        addItem(new CategoryItem("Hotels", "Lorem ipsum dolor sit amet dipisicing elit",
                R.drawable.hotels, CategoryType.HOTEL));

        addItem(new CategoryItem("Coffee Shops", "Lorem ipsum dolor sit amet dipisicing elit",
                R.drawable.coffee_shop, CategoryType.COFFEE_SHOP));

        addItem(new CategoryItem("Pharmacy", "Lorem ipsum dolor sit amet dipisicing elit",
                R.drawable.pharmacy, CategoryType.PHARMACY));

        addItem(new CategoryItem("Hardware Store", "Lorem ipsum dolor sit amet dipisicing elit",
                R.drawable.restaurant, CategoryType.HARDWARE_STORE));

        addItem(new CategoryItem("Computer Shops", "Lorem ipsum dolor sit amet dipisicing elit",
                R.drawable.hotels, CategoryType.COMPUTER_SHOP));

        addItem(new CategoryItem("Bakeries", "Lorem ipsum dolor sit amet dipisicing elit",
                R.drawable.coffee_shop, CategoryType.BAKERY));

        addItem(new CategoryItem("Gyms", "Lorem ipsum dolor sit amet dipisicing elit",
                R.drawable.pharmacy, CategoryType.GYM));

        addItem(new CategoryItem("Schools", "Lorem ipsum dolor sit amet dipisicing elit",
                R.drawable.restaurant, CategoryType.SCHOOLS));
    }

    public List<CategoryItem> getCategoryItemsList() {
        return mCategoryItemsList;
    }

    private void addItem(CategoryItem item) {
        mCategoryItemsList.add(item);
    }

    public static class CategoryItem {
        public String mName;
        public String mDescription;
        public int mDrawableResource;
        CategoryType mCategory;

        public CategoryItem(String name, String description, int drawableResource, CategoryType cat) {
            mName = name;
            mDescription = description;
            mDrawableResource = drawableResource;
            mCategory = cat;
        }

        @Override
        public String toString() {
            return mName;
        }
    }
}
