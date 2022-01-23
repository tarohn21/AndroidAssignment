package com.example.androidassignment;

import androidx.appcompat.app.AppCompatActivity;

import android.nfc.Tag;
import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.io.IOException;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "Main";
    ListView listView;

    @Inject GitHubInfo gitHubInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        GitHubInfoComponent component = DaggerGitHubInfoComponent.create();

        gitHubInfo = component.getGitHubInfo();

        try {
            gitHubInfo.connectToGitHub("ghp_Uo8Y", "jeMuSHTFIC75wF2rbDyJUzQM0P", "0IUTk7");
            Log.d(TAG, "Connected successfully");
        }
        catch (IOException e) {
            Log.d(TAG, "Failed to connect");
            e.printStackTrace();
        }

    }

    //Gets the info and adds it to the listview
    public void LoadInfo(View v) throws IOException {
        EditText user = findViewById(R.id.username);
        EditText repo = findViewById(R.id.reponame);

        gitHubInfo.gitHubCommitInfo(user.getText().toString(), repo.getText().toString());

        listView = findViewById(R.id.commitInfo);
        ArrayAdapter<String> array;
        array = new ArrayAdapter<String>(
                this,
                R.layout.support_simple_spinner_dropdown_item,
                gitHubInfo.getCombinedInfo());
        listView.setAdapter(array);
    }

}
