package com.example.mvvmdesignpatternpractice.model;

import com.google.gson.annotations.SerializedName;

public class GithubUser {
    @SerializedName("login")
    private String userID;

    @SerializedName("avatar_url")
    private String userProfileImgUrl;

    public GithubUser(String userID, String userProfileImgUrl) {
        this.userID = userID;
        this.userProfileImgUrl = userProfileImgUrl;
    }

    public String getUserID() {
        return userID;
    }

    public String getUserProfileImgUrl() {
        return userProfileImgUrl;
    }
}
