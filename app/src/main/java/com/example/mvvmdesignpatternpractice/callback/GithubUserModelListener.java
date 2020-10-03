package com.example.mvvmdesignpatternpractice.callback;

import com.example.mvvmdesignpatternpractice.model.GithubUser;

public interface GithubUserModelListener {
    void setUserInfo(GithubUser githubUser);
}
