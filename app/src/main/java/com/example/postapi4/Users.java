package com.example.postapi4;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Users {



    @SerializedName("username")
    private String username;

    @SerializedName("first_name")
    private String name;

    @SerializedName("last_name")
    private String last_name;

    @SerializedName("email")
    private String email;

    @SerializedName("password")
    private String password;


    public String getUsername() {
        return username;
    }

    public Users(String username, String name, String last_name, String email) {
        this.username = username;
        this.name = name;
        this.last_name = last_name;
        this.email = email;
    }

    public Users(){}



    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
