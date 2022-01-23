package com.example.androidassignment;

import androidx.appcompat.app.AppCompatActivity;

import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.io.IOException;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "Main";

    @Inject GitHubInfo gitHubInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        GitHubInfoComponent component = DaggerGitHubInfoComponent.create();

        gitHubInfo = component.getGitHubInfo();
        //gitHubInfo.test();

        try {
            gitHubInfo.getGitHub();
        }
        catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void LoadInfo(View v) throws IOException {
        ((EditText) findViewById(R.id.username)).setText(gitHubInfo.getUserName());

    }
}