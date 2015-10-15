package com.trytara.tara;

import android.app.Application;


import com.parse.Parse;
import com.parse.ParseFacebookUtils;

public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        Parse.enableLocalDatastore(this);
        Parse.initialize(this, "VpVpZLSlLazxa8IjudrSWdnZYma3c22SJdiAULkm",
                "AqlegT294eVrHhDaIkJWkTzNI4qsvZasFYNJrtCd");
        ParseFacebookUtils.initialize(this);


    }
}
