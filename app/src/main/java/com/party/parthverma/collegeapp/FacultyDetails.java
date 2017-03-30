package com.party.parthverma.collegeapp;

import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class FacultyDetails extends AppCompatActivity {
    TextView description, name, designation, qualification, email, phone;
    ImageView facultyImage;
    Toolbar toolbar;
    CollapsingToolbarLayout collapsingToolbarLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_faculty_details);
        int position = this.getIntent().getExtras().getInt("position");
        Faculty faculty = Faculty.getFaculties(this).get(position);

        name = (TextView) findViewById(R.id.faculty_name);
        designation = (TextView) findViewById(R.id.faculty_desg);
        qualification = (TextView) findViewById(R.id.faculty_qual);
        email = (TextView) findViewById(R.id.faculty_mail);
        phone = (TextView) findViewById(R.id.faculty_phone);
        description = (TextView) findViewById(R.id.faculty_desc);
        facultyImage = (ImageView) findViewById(R.id.faculty_image);
        toolbar = (Toolbar) findViewById(R.id.toolbar2);
        collapsingToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.CollapsingToolbarLayout2);

        setSupportActionBar(toolbar);

        collapsingToolbarLayout.setTitle(faculty.name);


        /*Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);
        getSupportActionBar().setTitle(faculty.name);*/

        ActionBar ab = getSupportActionBar();
        ab.setDisplayHomeAsUpEnabled(true);

        description.setText(faculty.description);
        name.setText(faculty.name);
        designation.setText(faculty.designation);
        qualification.setText(faculty.qualification);
        email.setText(faculty.email);
        phone.setText(faculty.phone);
        Picasso.with(this).load(faculty.image_loc).into(facultyImage);
    }
}
