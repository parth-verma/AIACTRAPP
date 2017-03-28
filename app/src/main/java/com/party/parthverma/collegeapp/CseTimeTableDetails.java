package com.party.parthverma.collegeapp;

import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class CseTimeTableDetails extends AppCompatActivity {

    Toolbar toolbar;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cse_time_table_details);

        int position = this.getIntent().getExtras().getInt("position");
        TimeTableCse timeTableCse = TimeTableCse.getTimeTableCse(this).get(position);


        imageView = (ImageView) findViewById(R.id.imageview123);

        toolbar = (Toolbar) findViewById(R.id.cse_timetable_toolbar);
        setSupportActionBar(toolbar);

        ActionBar ab = getSupportActionBar();
        ab.setDisplayHomeAsUpEnabled(true);


        Picasso.with(this).load(timeTableCse.image_loc).into(imageView);
    }
}
