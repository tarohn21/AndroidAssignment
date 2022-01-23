package com.example.androidassignment;

import android.util.Log;

import org.kohsuke.github.GHEventInfo;
import org.kohsuke.github.GHUserSearchBuilder;
import org.kohsuke.github.GitHub;
import org.kohsuke.github.GitHubBuilder;

import java.io.IOException;
import java.util.List;

import javax.inject.Inject;

public class GitHubInfo {
    private static final String TAG = "GitHubInfo";

    private Info info;
    private GHEventInfo eventInfo;

    @Inject
    public GitHubInfo(Info info){
        this.info = info;
    }

    public void test() {
        Log.d(TAG, "Failed To get info");
    }

    public void getGitHub() throws IOException {
        GitHub gitHub = GitHub.connect("tarohn21", "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");

        //Log.d(TAG, gitHub.getMyself().getName());

    }



    public String getUserName(){
        return info.getUserName();
    }


}
