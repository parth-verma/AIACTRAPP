package com.party.parthverma.collegeapp;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;

public class About extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        final Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar1);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        CollapsingToolbarLayout collapsingToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.CollapsingToolbarLayout1);
        collapsingToolbarLayout.setTitle("AIACTR");
        collapsingToolbarLayout.setTitleEnabled(true);
        Context context = this;
        collapsingToolbarLayout.setContentScrimColor(ContextCompat.getColor(context, R.color.colorPrimary));
        ImageView imageView = (ImageView) findViewById(R.id.college_image);
        Picasso.with(this).load("http://www.planwallpaper.com/static/images/HD-Wallpapers1_FOSmVKg.jpeg").into(imageView);
        TextView about = (TextView) findViewById(R.id.about);
        about.setText(get_about(this));


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId() == android.R.id.home)
            finish();
        return super.onOptionsItemSelected(item);
    }

    public void goToActivityContact1(View view) {
        Intent intent = new Intent(this, Contact.class);
        startActivity(intent);
    }

    private String get_about(Context context) {
        String json = null;
        try {

            InputStream is = context.getAssets().open("about.json");

            int size = is.available();

            byte[] buffer = new byte[size];

            is.read(buffer);

            is.close();

            json = new String(buffer, "UTF-8");


        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        JSONObject obj;
        try {
            obj = new JSONObject(json);
        } catch (JSONException ex) {
            ex.printStackTrace();
            return null;
        }

        try {
            return obj.getString("description");
        } catch (JSONException exp) {
            exp.printStackTrace();
            return null;
        }
    }


}



