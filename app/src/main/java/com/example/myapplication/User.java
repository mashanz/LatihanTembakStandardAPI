package com.example.myapplication;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Chandra on 11/11/2017.
 * Need some help?
 * Contact me at y.pristyan.chandra@gmail.com
 */

public class User {
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @SerializedName("id_user")
    private String id = null;
    @SerializedName("email")
    private String email = null;
    @SerializedName("name")
    private String name = null;
}
