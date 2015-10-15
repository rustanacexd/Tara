package com.trytara.tara.models;

import com.trytara.tara.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Categories {

    public static List<CategoryItem> sCategoryItemsList = new ArrayList<>();
    public static Map<String, CategoryItem> sCategoryItemsMap = new HashMap<>();

    static {
        // Add 3 sample items.
        addItem(new CategoryItem("Restaurant", "Lorem ipsum dolor sit amet dipisicing elit", R.drawable.restaurant));
        addItem(new CategoryItem("Hotels", "Lorem ipsum dolor sit amet dipisicing elit", R.drawable.hotels));
        addItem(new CategoryItem("Coffee Shop", "Lorem ipsum dolor sit amet dipisicing elit", R.drawable.coffee_shop));
        addItem(new CategoryItem("Pharmacy", "Lorem ipsum dolor sit amet dipisicing elit", R.drawable.pharmacy));
        addItem(new CategoryItem("Sample Category 1", "Lorem ipsum dolor sit amet dipisicing elit", R.drawable.restaurant));
        addItem(new CategoryItem("Sample Category 2", "Lorem ipsum dolor sit amet dipisicing elit", R.drawable.hotels));
        addItem(new CategoryItem("Sample Category 3", "Lorem ipsum dolor sit amet dipisicing elit", R.drawable.coffee_shop));
        addItem(new CategoryItem("Sample Category 4", "Lorem ipsum dolor sit amet dipisicing elit", R.drawable.pharmacy));
        addItem(new CategoryItem("Sample Category 5", "Lorem ipsum dolor sit amet dipisicing elit", R.drawable.restaurant));
    }

    private static void addItem(CategoryItem item) {
        sCategoryItemsList.add(item);
        sCategoryItemsMap.put(item.mName, item);
    }

    public static class CategoryItem {
        public String mName;
        public String mDescription;
        public int mDrawableResource;

        public CategoryItem(String name, String description, int drawableResource) {
            mName = name;
            mDescription = description;
            mDrawableResource = drawableResource;
        }

        @Override
        public String toString() {
            return mName;
        }
    }
}
