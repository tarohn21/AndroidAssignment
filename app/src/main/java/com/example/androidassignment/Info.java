package com.example.androidassignment;

import javax.inject.Inject;
import java.util.List;

public class Info {

    private String username;
    private String reponame;
    //private List<String> author;
    //private List<String> hash;
    //private List<String> message;

    @Inject
    public Info() {
        this.username = "Tim";
        this.reponame = "";
    }

    String getUserName(){
        return username;
    }

    String getReponNme(){
        return reponame;
    }

}
