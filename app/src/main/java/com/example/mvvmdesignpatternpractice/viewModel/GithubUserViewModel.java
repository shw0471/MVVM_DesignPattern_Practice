package com.example.mvvmdesignpatternpractice.viewModel;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.example.mvvmdesignpatternpractice.callback.GithubUserModelListener;
import com.example.mvvmdesignpatternpractice.model.GithubUser;
import com.example.mvvmdesignpatternpractice.model.GithubUserModel;

public class GithubUserViewModel {

    public MutableLiveData<String> userID = new MutableLiveData<>();
    public MutableLiveData<String> userProfileImgUrl = new MutableLiveData<>();
    private GithubUserModel githubUserModel;

    public GithubUserViewModel() {
        githubUserModel = new GithubUserModel(new GithubUserModelListener() {
            @Override
            public void setUserInfo(GithubUser githubUser) {
                if (githubUser == null) return;
                userID.setValue(githubUser.getUserID());
                userProfileImgUrl.setValue(githubUser.getUserProfileImgUrl());
                Log.d("GithubUserViewModel", userID.toString() + " / " + userProfileImgUrl.toString());
            }
        });
    }

    public void getUserInfo(String userID) {
        githubUserModel.loadGithubUser(userID);
    }
}