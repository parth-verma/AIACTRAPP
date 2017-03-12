package com.party.parthverma.collegeapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class Clubs extends AppCompatActivity {
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clubs);
        listView = (ListView)findViewById(R.id.list_of_clubs);
        final ArrayList<Club> clubList = Club.getClubs(this);
        ClubsCardAdapter adapter = new ClubsCardAdapter(this,clubList);
        listView.setAdapter(adapter);
    }
}
