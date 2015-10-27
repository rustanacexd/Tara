package com.trytara.tara;

import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.trytara.tara.models.Business;
import com.trytara.tara.models.Category;
import com.trytara.tara.models.Item;

import java.util.List;

public class Helper {

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
            item.saveInBackground();
        }
    }

    public static void AttachDummyItemsToBusinesses() {
        ParseQuery<Item> itemParseQuery = ParseQuery.getQuery(Item.class);
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
            business.setAbout("Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod\n" +
                    "tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam,\n" +
                    "quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo\n" +
                    "consequat.\n\nDuis aute irure dolor in reprehenderit in voluptate velit esse\n" +
                    "cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non\n" +
                    "proident, sunt in culpa qui officia deserunt mollit anim id est laborum.");

            business.saveInBackground();
        }
    }

}
