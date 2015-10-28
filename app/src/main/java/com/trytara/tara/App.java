package com.trytara.tara;

import android.app.Application;
import android.util.Log;

import com.parse.FindCallback;
import com.parse.Parse;
import com.parse.ParseException;
import com.parse.ParseFacebookUtils;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.trytara.tara.models.Business;
import com.trytara.tara.models.Category.CategoryType;
import com.trytara.tara.models.Item;
import com.trytara.tara.models.Review;

import java.util.List;
import java.util.Random;

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

        /*Helper.createDummyBusinesses(15, CategoryType.COFFEE_SHOP);
        Helper.createDummyBusinesses(15, CategoryType.BAKERY);
        Helper.createDummyBusinesses(15, CategoryType.RESTAURANT);
        Helper.createDummyBusinesses(15, CategoryType.HARDWARE_STORE);
        Helper.createDummyBusinesses(15, CategoryType.PHARMACY);
        Helper.createDummyBusinesses(15, CategoryType.HOTEL);
        Helper.createDummyBusinesses(15, CategoryType.COMPUTER_SHOP);
        Helper.createDummyBusinesses(15, CategoryType.GYM);
        Helper.createDummyBusinesses(15, CategoryType.SCHOOL);*/

        //Helper.createDummyItems(15);
        //Helper.attachDummyItemsToBusinesses();

        /*ParseQuery<Business> query = ParseQuery.getQuery(Business.class);
        query.findInBackground(new FindCallback<Business>() {
            @Override
            public void done(List<Business> list, ParseException e) {
                if (e == null) {
                    for(int i = 0; i < list.size(); i++) {
                        Business business = list.get(i);
                        Random random = new Random();
                        business.setAverageRate((double) (random.nextInt((5 - 1)) + 1));
                        business.saveInBackground();
                    }
                } else {
                    Log.d(App.TAG, e.getLocalizedMessage());
                }
            }
        });*/

        //Helper.createDummyReviews(50);
        //Helper.attachReviewsToBusiness();



    }

}
