package com.trytara.tara;

import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.trytara.tara.models.Business;
import com.trytara.tara.models.Category;
import com.trytara.tara.models.Item;
import com.trytara.tara.models.Review;

import java.util.List;
import java.util.Random;

public class Helper {

    public static int randomNumber(int min, int max) {
        Random random = new Random();
        return random.nextInt((max - min)) + min;
    }

    public static void deleteAllBusiness() {
        ParseQuery<Business> query = ParseQuery.getQuery(Business.class);
        query.setLimit(1000);
        query.findInBackground(new FindCallback<Business>() {
            @Override
            public void done(List<Business> list, ParseException e) {
                try {
                    ParseObject.deleteAll(list);
                } catch (ParseException e1) {
                    e1.printStackTrace();
                }

            }
        });
    }

    public static void createDummyItems(int numItems) {
        for (int i = 0; i <= numItems; i++) {
            Item item = new Item();
            item.setTitle("Business Item " + i);
            item.setDescription("Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod\n" +
                    "tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam,\n" +
                    "quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo\n" +
                    "consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse\n" +
                    "cillum dolore eu fugiat nulla pariatur.");
            item.setPrice((double) (10 * i));
            item.setAverageRate((double) randomNumber(1, 5));
            item.saveInBackground();
        }
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

    public static void createDummyBusinesses(int numBusiness, Category.CategoryType categoryType) {
        for (int i = 0; i <= numBusiness; i++) {
            Business business = new Business();
            business.setEmail("dummybusinessemail" + i + "@gmail.com");
            business.setCategory(categoryType);
            business.setName("Dummy Business " + i);
            business.setAddress("Dummy Business Address " + i);
            business.setDescription("Dummy Business Description " + i);
            business.setPhoneNumber("062-2142-" + i + 2 * i + 3 * i);
            business.setMobilePhoneNumber("0915828" + i + 2 * i + 3 * i);
            business.setAverageRate((double) randomNumber(1, 5));
            business.setAbout("Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod\n" +
                    "tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam,\n" +
                    "quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo\n" +
                    "consequat.\n\nDuis aute irure dolor in reprehenderit in voluptate velit esse\n" +
                    "cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non\n" +
                    "proident, sunt in culpa qui officia deserunt mollit anim id est laborum.");

            business.saveInBackground();
        }
    }

    public static void createDummyReviews(int numReviews) {
        for (int i = 0; i < numReviews; i++) {
            Review review = new Review();
            review.setContent("Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod\n" +
                    "tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam,\n" +
                    "quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo\n" +
                    "consequat. ");

            review.setRating((double) randomNumber(1, 5));
            review.saveInBackground();
        }
    }

    public static void attachReviewsToBusiness() {
        final ParseQuery<Review> query = ParseQuery.getQuery(Review.class);
        query.setLimit(500);
        query.findInBackground(new FindCallback<Review>() {
            @Override
            public void done(final List<Review> reviewList, ParseException e) {
                ParseQuery<Business> businessParseQuery = ParseQuery.getQuery(Business.class);
                businessParseQuery.setLimit(500);
                businessParseQuery.findInBackground(new FindCallback<Business>() {
                    @Override
                    public void done(List<Business> list, ParseException e) {
                        for (Business business : list) {
                            business.put("reviews", reviewList);
                            business.saveInBackground();
                        }
                    }
                });
            }
        });
    }

    public static void attachReviewsToItems() {
        final ParseQuery<Review> query = ParseQuery.getQuery(Review.class);
        query.setLimit(500);
        query.findInBackground(new FindCallback<Review>() {
            @Override
            public void done(final List<Review> reviewList, ParseException e) {
                ParseQuery<Item> itemParseQuery = ParseQuery.getQuery(Item.class);
                itemParseQuery.setLimit(500);
                itemParseQuery.findInBackground(new FindCallback<Item>() {
                    @Override
                    public void done(List<Item> list, ParseException e) {
                        for (Item item : list) {
                            item.put("reviews", reviewList);
                            item.saveInBackground();
                        }
                    }
                });
            }
        });
    }

}
