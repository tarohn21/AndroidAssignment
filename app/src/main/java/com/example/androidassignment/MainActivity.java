package com.example.androidassignment;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity {

    @Inject GitHubInfo gitHubInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        GitHubInfoComponent component = DaggerGitHubInfoComponent.create();

        gitHubInfo = component.getGitHubInfo();
        gitHubInfo.test();

    }
}