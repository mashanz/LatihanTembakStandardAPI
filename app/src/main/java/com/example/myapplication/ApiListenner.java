package com.example.myapplication;

import android.util.Log;

import com.androidnetworking.error.ANError;

import okhttp3.Response;

/**
 * Created by Chandra on 11/11/2017.
 * Need some help?
 * Contact me at y.pristyan.chandra@gmail.com
 */

public interface ApiListenner {
    public void succes(Response okHttpResponse, String response, String TAG);

    public void error(ANError anError, String TAG);
}
