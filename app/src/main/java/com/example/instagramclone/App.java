package com.example.instagramclone;

import android.app.Application;

import com.parse.Parse;

public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        Parse.initialize(new Parse.Configuration.Builder(this)
                .applicationId("VopPdvJ4YccGftewXDL8p3ilxu05kscTNfWgflDb")
                // if defined
                .clientKey("jaoWkkzuCWS1Wn3PJfXJ19wfIHmA4MLR5zOLTtsh")
                .server("https://parseapi.back4app.com/")
                .build()
        );

    }
}
