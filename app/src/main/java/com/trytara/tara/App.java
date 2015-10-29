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


//        Helper.createDummyBusinessData(15, 10, 10, CategoryType.COFFEE_SHOP);
//        Helper.createDummyBusinessData(15, 10, 10, CategoryType.BAKERY);
//        Helper.createDummyBusinessData(15, 10 ,10, CategoryType.HOTEL);
//        Helper.createDummyBusinessData(15, 10 ,10, CategoryType.SCHOOL);
//        Helper.createDummyBusinessData(15, 10 ,10, CategoryType.COMPUTER_SHOP);
//        Helper.createDummyBusinessData(15, 10 ,10, CategoryType.HARDWARE_STORE);


    }

}
