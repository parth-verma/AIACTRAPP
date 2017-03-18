package com.party.parthverma.collegeapp;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListView;

import java.util.ArrayList;

public class Faculties extends AppCompatActivity {
    private GridView gridView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_faculties);



        gridView = (GridView) findViewById(R.id.list_of_clubs);
        final ArrayList<Faculty> clubList = Faculty.getFaculties(this);
        FacultyCardAdapter adapter = new FacultyCardAdapter(this, clubList);
        gridView.setAdapter(adapter);

        final Context context = this;

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {
                Intent intent = new Intent(context,FacultyDetails.class);
                intent.putExtra("position", position);
                startActivity(intent);
            }
        });
    }
}
