package com.example.sakkhispot.discovery;

import com.parse.Parse;
import android.app.Application;

public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Parse.enableLocalDatastore(this);

        Parse.initialize(new Parse.Configuration.Builder(this)
                .applicationId("ummo")
                .server("https://app.ummo.xyz/api")
                .enableLocalDataStore()
                .build()
        );
    }
}