package com.example.myapplication;

import android.app.Service;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.ANRequest;
import com.androidnetworking.common.Priority;
import com.androidnetworking.common.RequestBuilder;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.JSONObjectRequestListener;
import com.androidnetworking.interfaces.OkHttpResponseAndStringRequestListener;
import com.androidnetworking.interfaces.StringRequestListener;
import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;

import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.Response;

public class MainActivity extends Services {
    @BindView(R.id.email) EditText email;
    @BindView(R.id.pass) EditText pass;
    @BindView(R.id.submit) Button submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        submit.setOnClickListener(buttonListenner);
    }

    public View.OnClickListener buttonListenner = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (v.getId() == R.id.submit) {
                HashMap<String, String> param = new HashMap<>();
                param.put("email", email.getText().toString());
                param.put("password", pass.getText().toString());
                login(param);
            }
        }
    };

    @Override
    public void succes(Response okHttpResponse, String response, String TAG) {
        super.succes(okHttpResponse, response, TAG);
        if (TAG.equals("LOGIN")) {
            try {
                JSONObject jsonObject = new JSONObject(response);
                Gson gson = new Gson();
                User user = gson.fromJson(jsonObject.getJSONObject("data").toString(), User.class);
                Log.i("USER ID", user.getId());
                email.setText("");
                pass.setText("");
                getUser(user.getId());
            } catch (JSONException e) {

            }
        } else {
            Log.i("HASIL", "DETAIL");
        }

    }

    @Override
    public void error(ANError anError, String TAG) {
        super.error(anError, TAG);
    }
}