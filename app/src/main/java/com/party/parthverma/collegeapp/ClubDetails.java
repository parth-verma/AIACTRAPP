package com.party.parthverma.collegeapp;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

public class ClubDetails extends AppCompatActivity {

    TextView title, type, desc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_club_details);
        title = (TextView) findViewById(R.id.club_name);
        type = (TextView) findViewById(R.id.club_type);
        desc = (TextView) findViewById(R.id.club_desc);

        int position = this.getIntent().getExtras().getInt("position");

        Club club = Club.getClubs(this).get(position);

        Toolbar myToolbar = (Toolbar) findViewById(R.id.club_detail_toolbar);
        setSupportActionBar(myToolbar);
        getSupportActionBar().setTitle(club.name);

        ActionBar ab = getSupportActionBar();
        ab.setDisplayHomeAsUpEnabled(true);

        title.setText(club.name);
        type.setText(club.type);
        desc.setText(club.desc);



    }
}
