package com.party.parthverma.collegeapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button about;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        about = (Button) findViewById(R.id.collapsingToolbar);
        about.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, About.class));
            }
        });
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
}
