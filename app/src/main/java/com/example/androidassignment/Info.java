package com.example.androidassignment;

import org.kohsuke.github.GHCommit;

import javax.inject.Inject;

import java.util.ArrayList;
import java.util.List;

public class Info {

    private String username;
    private String reponame;
    //private List<String> author;
    //private List<String> hash;
    //private List<String> message;
    //private ArrayList combinedinfo;
    private String[] combinedinfo;

    @Inject
    public Info() {
        this.username = "";
        this.reponame = "";
        //this.author = new ArrayList<String>();
        //this.hash = new ArrayList<String>();
       // this.message = new ArrayList<String>();
        //this.combinedinfo = new ArrayList();
        this.combinedinfo = new String[25];
    }

    String getUserName(){
        return username;
    }

    String getReponNme(){
        return reponame;
    }

    /*
    List<String> getAuthor(){
        return author;
    }

    List<String> getHash(){
        return hash;
    }

    List<String> getMessage(){
        return message;
    }
    */

    /*ArrayList getCombinedinfo(){
        return combinedinfo;
    }*/

    String[] getCombinedinfo(){
        return combinedinfo;
    }

    void setUserName(String username){
        this.username = username;
    }

    void setReponame(String reponame){
        this.reponame = reponame;
    }

    /*
    void setAuthor(List<String> author){
        this.author = author;
    }

    void setHash(List<String> hash){
        this.hash = hash;
    }

    void setMessage(List<String> message){
        this.message = message;
    }
     */

    /*void setCombinedinfo(String combinedinfo){
        this.combinedinfo.add(combinedinfo);
    }*/

    void setCombinedinfo(int index, String c){
        this.combinedinfo[index] = c;
    }
}
