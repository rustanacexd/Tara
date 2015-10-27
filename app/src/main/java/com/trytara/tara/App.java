package com.trytara.tara;

import android.app.Application;


import com.parse.Parse;
import com.parse.ParseFacebookUtils;
import com.parse.ParseObject;
import com.trytara.tara.models.Business;
import com.trytara.tara.models.Item;
import com.trytara.tara.models.Review;

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


    }
}
