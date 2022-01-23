package com.example.androidassignment;

import android.util.Log;

import org.kohsuke.github.GHBranch;
import org.kohsuke.github.GHCommit;
import org.kohsuke.github.GHCommitComment;
import org.kohsuke.github.GHCommitStatus;
import org.kohsuke.github.GHEventInfo;
import org.kohsuke.github.GHRepository;
import org.kohsuke.github.GHSearchBuilder;
import org.kohsuke.github.GHUserSearchBuilder;
import org.kohsuke.github.GitHub;
import org.kohsuke.github.GitHubBuilder;
import org.kohsuke.github.PagedIterable;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.inject.Inject;

public class GitHubInfo {
    private static final String TAG = "GitHubInfo";

    private Info info;
    private GitHub gitHub;
    private GHEventInfo eventInfo;

    @Inject
    public GitHubInfo(Info info){
        this.info = info;
    }

    //Connects to github
    public void connectToGitHub() throws IOException {
        // gitHub = GitHub.connect("tarohn21", "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");

        gitHub = GitHub.connectUsingOAuth("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");

    }

    public void gitHubCommitInfo(String user, String repo) throws IOException {

        Log.d(TAG,  user + " " + repo);

        //Gets the repository from the username and repo name
        info.setReponame(user);
        info.setReponame(repo);
        GHRepository repository = gitHub.getRepository(user + "/" + repo);

        //Gets all the commits in the repository
        PagedIterable<GHCommit> commits =  repository.listCommits();

        //Creates an array of all the commits
        GHCommit[] commitsArray = commits.toArray();

        //Goes through all the commits and gets the commit info
        for (int i = 0; i < 25; i++) {
            GHCommit commit = commitsArray[i];
            info.setCombinedinfo(i,commit.getAuthor().getName() + " " + commit.getSHA1().toString() + " " + commit.getCommitShortInfo().getMessage());

            Log.d(TAG,  "author is " + commit.getAuthor().getName());
            Log.d(TAG,  "hash is " + commit.getSHA1().toString());
            Log.d(TAG,  "message  is " + commit.getCommitShortInfo().getMessage());
        }
    }

    public String[] getCombinedInfo(){
        return  info.getCombinedinfo();
    }

    public String getUserName(){
        return info.getUserName();
    }


  /* Original test methods
    public void getGitHubRepoInfo(String user, String repo) throws IOException {

        //Gets the repository from the username and repo name
        GHRepository repository = gitHub.getRepository("khuedoan/homelab");

    }

    public void getAllCommits(GHRepository repository) throws IOException {

        //Gets all the commits in the repository
        PagedIterable<GHCommit> commits =  repository.listCommits();

        //Creates an array of all the commits
        GHCommit[] commitsArray = commits.toArray();
    }




    public void gitHubTest() throws IOException {
        Log.d(TAG, gitHub.getMyself().getLogin());

        //GHRepository repo = gitHub.getRepository("hub4j/github-api");

        //Gets the repository from the username and repo name
        GHRepository repo = gitHub.getRepository("khuedoan/homelab");

        //GHRepository repo = gitHub.getRepository("tarohn21/AndroidAssignment");

        //turns gets all the commits in the repo
        PagedIterable<GHCommit> commits =  repo.listCommits();


        //creates an array of all the commits
         GHCommit[] commitsArray = commits.toArray();

        for (int i = 0; i < 2; i++) {
            GHCommit commit = commitsArray[i];
            commit.getAuthor().getName();

            Log.d(TAG,  "Size is " + commit.getAuthor().getName());

            info.setUserName(commit.getAuthor().getName());

            Log.d(TAG,  "username is " +  commit.getSHA1().toString());

        }
    }
   */
}
