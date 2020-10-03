package com.example.mvvmdesignpatternpractice.model;

import android.util.Log;

import com.example.mvvmdesignpatternpractice.callback.GithubUserModelListener;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class GithubUserModel {

    private GithubUser githubUser = null;
    private GithubService githubService;
    private GithubUserModelListener callback;

    public GithubUserModel(GithubUserModelListener callback) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.github.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        githubService = retrofit.create(GithubService.class);

        this.callback = callback;
    }

    public void loadGithubUser(String userID) {
        Call<GithubUser> call = githubService.getUserInfo(userID);
        call.enqueue(new Callback<GithubUser>() {
            @Override
            public void onResponse(Call<GithubUser> call, Response<GithubUser> response) {
                if (response.isSuccessful()) {
                    githubUser = response.body();
                    Log.d("GithubUserModel", "onResponse: 성공");
                    callback.setUserInfo(githubUser);
                } else {
                    Log.d("GithubUserModel", "onResponse: 실패");
                }
            }

            @Override
            public void onFailure(Call<GithubUser> call, Throwable t) {
                Log.d("GithubUserModel", "onFailure: 실패");
            }
        });
    }
}