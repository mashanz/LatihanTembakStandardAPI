package com.example.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.androidnetworking.common.ANRequest;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.OkHttpResponseAndStringRequestListener;
import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;

import okhttp3.Response;

/**
 * Created by Chandra on 11/11/2017.
 * Need some help?
 * Contact me at y.pristyan.chandra@gmail.com
 */

public class Services extends AppCompatActivity {
    void login(HashMap<String, String> parameter) {
        sendRequest("User/login", parameter, "POST", "LOGIN");
    }

    void getUser(String id ) {
        HashMap<String, String> param = new HashMap<>();
        param.put("id_user", id);
        sendRequest("user", param, "GET", "DETAILS");
    }

    void sendRequest(String path, HashMap<String, String> parameters, String method, final String TAG) {
        String baseUrl = "http://192.168.1.16/mywallet/index.php/api/";
        ANRequest anRequest;

        if (method.equals("POST")) {
            ANRequest.PostRequestBuilder requestBuilder = new ANRequest.PostRequestBuilder(baseUrl + path);
            anRequest = requestBuilder
                    .addBodyParameter(parameters)
                    .setTag(TAG)
                    .setPriority(Priority.IMMEDIATE)
                    .build();
        } else {
            ANRequest.GetRequestBuilder requestBuilder = new ANRequest.GetRequestBuilder(baseUrl + path);
            anRequest = requestBuilder
                    .addQueryParameter(parameters)
                    .setTag(TAG)
                    .setPriority(Priority.IMMEDIATE)
                    .build();
        }

        anRequest.getAsOkHttpResponseAndString(new OkHttpResponseAndStringRequestListener() {
            @Override
            public void onResponse(Response okHttpResponse, String response) {
                succes(okHttpResponse, response, TAG);
            }

            @Override
            public void onError(ANError anError) {
                error(anError, TAG);
            }
        });
    }

    public void succes(Response okHttpResponse, String response, String TAG) {
        Log.i("CODE", String.valueOf(okHttpResponse.code()));
        Log.i("MESSAGE", "" + String.valueOf(okHttpResponse.message()));
        Log.i("CONTENT", "" + response);

    }

    public void error(ANError anError, String TAG) {
        Log.e("CODE", String.valueOf(anError.getErrorCode()));
        Log.e("MESSAGE", "" + anError.getMessage());
        Log.e("CONTENT", "" + anError.getErrorBody());
    }
}
