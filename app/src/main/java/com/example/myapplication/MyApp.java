package com.example.myapplication;

import android.app.Application;

import com.androidnetworking.AndroidNetworking;

/**
 * Created by Chandra on 11/11/2017.
 * Need some help?
 * Contact me at y.pristyan.chandra@gmail.com
 */

public class MyApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        AndroidNetworking.initialize(getApplicationContext());
    }
}
