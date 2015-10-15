package com.trytara.tara.models;

import com.trytara.tara.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Categories {

    public enum Category {
        RESTAURANT, COFFEE_SHOP, PHARMACY, HOTEL, COMPUTER_SHOP, HARDWARE_STORE, BAKERY, GYM, SCHOOLS
    }

    public static List<CategoryItem> sCategoryItemsList = new ArrayList<>();
    public static Map<String, CategoryItem> sCategoryItemsMap = new HashMap<>();

    static {
        addItem(new CategoryItem("Restaurant", "Lorem ipsum dolor sit amet dipisicing elit",
                R.drawable.restaurant, Category.RESTAURANT));

        addItem(new CategoryItem("Hotels", "Lorem ipsum dolor sit amet dipisicing elit",
                R.drawable.hotels, Category.HOTEL));

        addItem(new CategoryItem("Coffee Shop", "Lorem ipsum dolor sit amet dipisicing elit",
                R.drawable.coffee_shop, Category.COFFEE_SHOP));

        addItem(new CategoryItem("Pharmacy", "Lorem ipsum dolor sit amet dipisicing elit",
                R.drawable.pharmacy, Category.PHARMACY));

        addItem(new CategoryItem("Sample Category 1", "Lorem ipsum dolor sit amet dipisicing elit",
                R.drawable.restaurant, Category.RESTAURANT));

        addItem(new CategoryItem("Sample Category 2", "Lorem ipsum dolor sit amet dipisicing elit",
                R.drawable.hotels, Category.HOTEL));

        addItem(new CategoryItem("Sample Category 3", "Lorem ipsum dolor sit amet dipisicing elit",
                R.drawable.coffee_shop, Category.COFFEE_SHOP));

        addItem(new CategoryItem("Sample Category 4", "Lorem ipsum dolor sit amet dipisicing elit",
                R.drawable.pharmacy, Category.PHARMACY));

        addItem(new CategoryItem("Sample Category 5", "Lorem ipsum dolor sit amet dipisicing elit",
                R.drawable.restaurant, Category.RESTAURANT));
    }

    private static void addItem(CategoryItem item) {
        sCategoryItemsList.add(item);
        sCategoryItemsMap.put(item.mName, item);
    }

    public static class CategoryItem {
        public String mName;
        public String mDescription;
        public int mDrawableResource;
        Category mCategory;

        public CategoryItem(String name, String description, int drawableResource, Category cat) {
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
