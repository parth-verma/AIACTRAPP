package com.party.parthverma.collegeapp;

import android.app.Notification;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.crash.FirebaseCrash;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {
    private Button about;
    private static FirebaseDatabase fbDatabase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fbDatabase = FirebaseDatabase.getInstance();
        fbDatabase.setPersistenceEnabled(true);

    }
    public void goToActivityContact (View view) {
        Intent intent = new Intent(this, Contact.class);
        startActivity(intent);
    }
    public void gotoActivityClubs(View view)
    {
        Intent intent= new Intent(this,Clubs.class);
        startActivity(intent);
    }
    public void goToActivityAbout(View view) {
        Intent intent = new Intent(this, About.class);
        startActivity(intent);
    }

    public void goToActivityFaculty (View view) {
        Intent intent = new Intent(this, Faculties.class);
        startActivity(intent);
    }
    public void goToActivityNotification (View view) {
        Intent intent = new Intent(this, Notifications.class);
        startActivity(intent);
    }

}
