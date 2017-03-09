package com.party.parthverma.collegeapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void goToActivityContact (View view) {
        Intent intent = new Intent(this, Contact.class);
        startActivity(intent);
    }
    public void goToActivityAbout (View view) {
        Intent intent = new Intent(this, About.class);
        startActivity(intent);
    }
}
