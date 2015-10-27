package com.trytara.tara;

import android.app.Application;


import com.parse.FindCallback;
import com.parse.Parse;
import com.parse.ParseException;
import com.parse.ParseFacebookUtils;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.trytara.tara.models.Business;
import com.trytara.tara.models.Item;
import com.trytara.tara.models.Review;

import java.util.List;

public class App extends Application {

    public static final String TAG = "DEBUG";

    @Override
    public void onCreate() {
        super.onCreate();

        ParseObject.registerSubclass(Business.class);
        ParseObject.registerSubclass(Item.class);
        ParseObject.registerSubclass(Review.class);

        Parse.initialize(this, "VpVpZLSlLazxa8IjudrSWdnZYma3c22SJdiAULkm",
                "AqlegT294eVrHhDaIkJWkTzNI4qsvZasFYNJrtCd");
        ParseFacebookUtils.initialize(this);

        //AttachDummyItemsToBusiness();

    }

    private void createDummyItems(int numItems) {
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

    private void AttachDummyItemsToBusiness() {

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

    
}
