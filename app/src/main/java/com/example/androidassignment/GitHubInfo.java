package com.example.androidassignment;

import android.util.Log;

import javax.inject.Inject;

public class GitHubInfo {
    private static final String TAG = "GitHubInfo";

    private Info info;

    @Inject
    public GitHubInfo(Info info){
        this.info = info;
    }

    public void test() {

        Log.d(TAG, info.getUserName());
    }

}
