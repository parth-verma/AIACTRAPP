package com.party.parthverma.collegeapp;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ListView;

import java.util.ArrayList;

public class Directory extends AppCompatActivity {

    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_directory);


        Toolbar myToolbar = (Toolbar) findViewById(R.id.directory_toolbar);
        setSupportActionBar(myToolbar);
        getSupportActionBar().setTitle("Directory");

        ActionBar ab = getSupportActionBar();
        ab.setDisplayHomeAsUpEnabled(true);

        listView = (ListView) findViewById(R.id.list_of_directory);
        final ArrayList<Direct> directoryList = Direct.getDirectory(this);
        DirectoryAdapter adapter = new DirectoryAdapter(this, directoryList);
        listView.setAdapter(adapter);
    }


}
