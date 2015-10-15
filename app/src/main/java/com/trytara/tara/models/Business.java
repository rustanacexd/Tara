package com.trytara.tara.models;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static com.trytara.tara.models.Categories.Category;

public class Business {
    private String mName;
    private String mDescription;
    private String mContactNumber;
    private String mAddress;
    private Category mCategory;

    private static final RandomEnum<Category> r = new RandomEnum<>(Category.class);

    public Business(String name, String description, String contactNumber, String address, RandomEnum<Category> category) {
        mName = name;
        mDescription = description;
        mContactNumber = contactNumber;
        mAddress = address;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public String getDescription() {
        return mDescription;
    }

    public void setDescription(String description) {
        mDescription = description;
    }

    public String getContactNumber() {
        return mContactNumber;
    }

    public void setContactNumber(String contactNumber) {
        mContactNumber = contactNumber;
    }

    public String getAddress() {
        return mAddress;
    }

    public void setAddress(String address) {
        mAddress = address;
    }


    public static List<Business> createBusinessList(int numBusiness) {
        List<Business> businesses = new ArrayList<>();
        for (int i = 1; i <= numBusiness; i++) {
            businesses.add(new Business("Business " + i,"Lorem ipsum nonsense lol" ,"2142406",
                    "Pagadian City", r));
        }

        return businesses;
    }

    private static class RandomEnum<E extends Enum> {

        private static final Random RND = new Random();
        private final E[] values;

        public RandomEnum(Class<E> token) {
            values = token.getEnumConstants();
        }

        public E random() {
            return values[RND.nextInt(values.length)];
        }
    }
}
