package com.party.parthverma.collegeapp;

import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class FacultyDetails extends AppCompatActivity {
    TextView desc,name,desg,qual,mail,phone;
    ImageView clubImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_faculty_details);
        int position = this.getIntent().getExtras().getInt("position");
        Faculty faculty = Faculty.getFaculties(this).get(position);

        name = (TextView) findViewById(R.id.faculty_name);
        desg = (TextView) findViewById(R.id.faculty_desg);
        qual = (TextView) findViewById(R.id.faculty_qual);
        mail = (TextView) findViewById(R.id.faculty_mail);
        phone = (TextView) findViewById(R.id.faculty_phone);
        desc = (TextView) findViewById(R.id.faculty_desc);
        clubImage = (ImageView) findViewById(R.id.club_image);

        desc.setText(faculty.desc);
        name.setText(faculty.name);
        desg.setText(faculty.desg);
        qual.setText(faculty.qual);
        mail.setText(faculty.mail);
        phone.setText(faculty.phone);
        Picasso.with(this).load(faculty.image_loc).placeholder(R.drawable.output).into(clubImage);
    }
}
