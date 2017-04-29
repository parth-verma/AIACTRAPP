package com.party.parthverma.collegeapp;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class ClubDetails extends AppCompatActivity {

    TextView desc;
    Toolbar toolbar;
    ImageView clubImage;
    CollapsingToolbarLayout collapsingToolbarLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_club_details);
        int position = this.getIntent().getExtras().getInt("position");
        Club club = Club.getClubs(this).get(position);

        desc = (TextView) findViewById(R.id.club_desc);
        clubImage = (ImageView) findViewById(R.id.club_image);

        toolbar = (Toolbar) findViewById(R.id.toolbar1);
        collapsingToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.CollapsingToolbarLayout1);
        Context context = this;
        collapsingToolbarLayout.setContentScrimColor(ContextCompat.getColor(context, R.color.colorPrimary));

        setSupportActionBar(toolbar);

        collapsingToolbarLayout.setTitle(club.name);

        ActionBar ab = getSupportActionBar();
        ab.setDisplayHomeAsUpEnabled(true);

        desc.setText(club.desc);
        Picasso.with(this).load(club.image_loc).into(clubImage);


    }
}
