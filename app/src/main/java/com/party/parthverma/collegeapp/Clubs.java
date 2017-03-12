package com.party.parthverma.collegeapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class Clubs extends AppCompatActivity {
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clubs);
        listView = (ListView)findViewById(R.id.list_of_clubs);
        String clubs[] = new String[]{"Saarang","Immortals","Antriksh","Constant Vision","SR-AIT","Abhivyakti","Manthan","Codeingineers"};
        ArrayAdapter adapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,clubs);
        listView.setAdapter(adapter);
    }
}
