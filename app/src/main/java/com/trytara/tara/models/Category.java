package com.trytara.tara.models;

import android.support.annotation.NonNull;

import com.trytara.tara.R;

import java.util.ArrayList;
import java.util.List;

import static com.trytara.tara.models.Category.CategoryType.*;


public class Category {

    private static final String SLUG_RESTAURANT = "restaurant";
    private static final String SLUG_HOTEL = "hotel";
    private static final String SLUG_COFFEE_SHOP = "coffeeshop";
    private static final String SLUG_PHARMACY = "pharmacy";
    private static final String SLUG_COMPUTER_SHOP = "computershop";
    private static final String SLUG_BAKERY = "bakery";
    private static final String SLUG_GYM = "gym";
    private static final String SLUG_SCHOOL = "school";
    private static final String SLUG_HARDWARE_STORE = "hardwarestore";

    private static final String TITLE_RESTAURANT = "Restaurants";
    private static final String TITLE_HOTEL = "Hotels";
    private static final String TITLE_COFFEE_SHOP = "Coffee Shops";
    private static final String TITLE_PHARMACY = "Pharmacies";
    private static final String TITLE_HARDWARE_STORE = "Hardware Stores";
    private static final String TITLE_COMPUTER_SHOP = "Computer Shops";
    private static final String TITLE_BAKERY = "Bakeries";
    private static final String TITLE_GYM = "Gyms";
    private static final String TITLE_SCHOOL = "Schools";

    public enum CategoryType {
        RESTAURANT, COFFEE_SHOP, PHARMACY, HOTEL, COMPUTER_SHOP, HARDWARE_STORE, BAKERY, GYM, SCHOOL
    }

    public List<CategoryItem> mCategoryItemsList = new ArrayList<>();

    public Category() {
        mCategoryItemsList = createCategories();
    }

    private List<CategoryItem> createCategories() {

        List<CategoryItem> categoryItems = new ArrayList<>();

        categoryItems.add(new CategoryItem(TITLE_RESTAURANT, "Lorem ipsum dolor sit amet dipisicing elit",
                R.drawable.restaurant, RESTAURANT, SLUG_RESTAURANT));

        categoryItems.add(new CategoryItem(TITLE_HOTEL, "Lorem ipsum dolor sit amet dipisicing elit",
                R.drawable.hotels, HOTEL, SLUG_HOTEL));

        categoryItems.add(new CategoryItem(TITLE_COFFEE_SHOP, "Lorem ipsum dolor sit amet dipisicing elit",
                R.drawable.coffee_shop, COFFEE_SHOP, SLUG_COFFEE_SHOP));

        categoryItems.add(new CategoryItem(TITLE_PHARMACY, "Lorem ipsum dolor sit amet dipisicing elit",
                R.drawable.pharmacy, PHARMACY, SLUG_PHARMACY));

        categoryItems.add(new CategoryItem(TITLE_HARDWARE_STORE, "Lorem ipsum dolor sit amet dipisicing elit",
                R.drawable.restaurant, HARDWARE_STORE, SLUG_HARDWARE_STORE));

        categoryItems.add(new CategoryItem(TITLE_COMPUTER_SHOP, "Lorem ipsum dolor sit amet dipisicing elit",
                R.drawable.hotels, COMPUTER_SHOP, SLUG_COMPUTER_SHOP));

        categoryItems.add(new CategoryItem(TITLE_BAKERY, "Lorem ipsum dolor sit amet dipisicing elit",
                R.drawable.coffee_shop, BAKERY, SLUG_BAKERY));

        categoryItems.add(new CategoryItem(TITLE_GYM, "Lorem ipsum dolor sit amet dipisicing elit",
                R.drawable.pharmacy, GYM, SLUG_GYM));

        categoryItems.add(new CategoryItem(TITLE_SCHOOL, "Lorem ipsum dolor sit amet dipisicing elit",
                R.drawable.restaurant, SCHOOL, SLUG_SCHOOL));

        return categoryItems;
    }

    public static class CategoryItem {
        public String mName;
        public String mSlug;
        public String mDescription;
        public int mDrawableResource;
        CategoryType mCategory;

        public CategoryItem(String name, String description, int drawableResource, CategoryType cat,
                            String slug) {
            mName = name;
            mDescription = description;
            mDrawableResource = drawableResource;
            mCategory = cat;
            mSlug = slug;
        }

        @Override
        public String toString() {
            return mName;
        }
    }

    @NonNull
    public static String categoryTypeToString(Category.CategoryType categoryType) {
        String category;
        switch (categoryType) {
            case COFFEE_SHOP:
                category = "coffeeshop";
                break;
            case RESTAURANT:
                category = "restaurant";
                break;
            case PHARMACY:
                category = "pharmacy";
                break;
            case HOTEL:
                category = "hotel";
                break;
            case COMPUTER_SHOP:
                category = "computershop";
                break;
            case HARDWARE_STORE:
                category = "hardwarestore";
                break;
            case BAKERY:
                category = "bakery";
                break;
            case GYM:
                category = "gym";
                break;
            case SCHOOL:
                category = "school";
                break;
            default:
                category = "";
        }
        return category;
    }
}
