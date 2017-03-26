package com.party.parthverma.collegeapp;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class Faculties extends AppCompatActivity {
    private GridView gridView;
    ArrayList<Faculty> faculty_list;
    FacultyCardAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_faculties);
        faculty_list = new ArrayList<>(1);
        gridView = (GridView) findViewById(R.id.faculty_list);
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference faculty = database.getReference("faculty");

        faculty.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Faculty fac;
                for (DataSnapshot facultySnapshot : dataSnapshot.getChildren()) {
                    fac = facultySnapshot.getValue(Faculty.class);
                    faculty_list.add(fac);
                }
                ((BaseAdapter) ((GridView) findViewById(R.id.faculty_list)).getAdapter()).notifyDataSetChanged();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.d("paaa",databaseError.getMessage());

            }
        });

        adapter = new FacultyCardAdapter(this, faculty_list);
        Log.d("paaa",Integer.toString(adapter.getCount()));
        gridView.setAdapter(adapter);

        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);
        getSupportActionBar().setTitle("Faculty Profile");

        ActionBar ab = getSupportActionBar();
        ab.setDisplayHomeAsUpEnabled(true);

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
