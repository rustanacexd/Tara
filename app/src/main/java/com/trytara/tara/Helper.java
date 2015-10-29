package com.trytara.tara;

import android.util.Log;

import com.parse.FindCallback;
import com.parse.GetCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.SaveCallback;
import com.trytara.tara.models.Business;
import com.trytara.tara.models.Category;
import com.trytara.tara.models.Item;
import com.trytara.tara.models.Review;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Helper {

    public static int randomNumber(int min, int max) {
        Random random = new Random();
        return random.nextInt((max - min)) + min;
    }

    public static void attachDummyItemsToBusinesses() {
        ParseQuery<Item> itemParseQuery = ParseQuery.getQuery(Item.class);
        itemParseQuery.setLimit(500);
        itemParseQuery.findInBackground(new FindCallback<Item>() {
            @Override
            public void done(final List<Item> itemList, ParseException e) {
                ParseQuery<Business> businessParseQuery = ParseQuery.getQuery(Business.class);
                businessParseQuery.findInBackground(new FindCallback<Business>() {
                    @Override
                    public void done(List<Business> businessList, ParseException e) {
                        for (Business business : businessList) {
                            business.put("items", itemList);
                            business.saveInBackground();
                        }
                    }
                });
            }
        });
    }

    public static void createDummyBusinessData(int numBusiness, int numItems, final int numReviews, Category.CategoryType categoryType) {

        for (int i = 0; i < numBusiness; i++) {
            final Business business = new Business();
            business.setEmail("dummybusinessemail @gmail.com");
            business.setCategory(categoryType);
            business.setName("Dummy Business " + i);
            business.setAddress("Dummy Business Address ");
            business.setDescription("Dummy Business Description ");
            business.setPhoneNumber("062-2142-231");
            business.setMobilePhoneNumber("091582813131");
            business.setAverageRate((double) randomNumber(1, 5));
            business.setAbout("Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod\n" +
                    "tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam,\n" +
                    "quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo\n" +
                    "consequat.\n\nDuis aute irure dolor in reprehenderit in voluptate velit esse\n" +
                    "cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non\n" +
                    "proident, sunt in culpa qui officia deserunt mollit anim id est laborum.");

            business.saveInBackground(new SaveCallback() {
                @Override
                public void done(ParseException e) {
                    createReviews(numReviews, business);
                }
            });

            for (int j = 0; j < numItems; j++) {
                final Item item = new Item();
                item.setPrice((double) (3 * i + 10));
                item.setCategory("Dummy Category");
                item.setTitle("Dummy Business " + i);
                item.setDescription("Dummy Business Description ");
                item.setAverageRate((double) randomNumber(1, 5));
                item.setBusiness(business);
                item.saveInBackground(new SaveCallback() {
                    @Override
                    public void done(ParseException e) {
                        createReviews(numReviews, item);
                    }
                });

            }
        }
    }

    private static void createReviews(int numReviews, ParseObject object) {
        for (int j = 0; j < numReviews; j++) {

            Review review = new Review();
            review.setContent("Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod\n" +
                    "tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam,\n" +
                    "quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo\n" +
                    "consequat. ");

            review.setRating((double) randomNumber(1, 5));
            review.setReviewedTo(object);
            review.saveInBackground();

        }
    }


}
