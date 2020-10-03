package com.example.mvvmdesignpatternpractice.model;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface GithubService {

    @GET("users/{userID}")
    Call<GithubUser> getUserInfo(@Path("userID") String UserID);
}
