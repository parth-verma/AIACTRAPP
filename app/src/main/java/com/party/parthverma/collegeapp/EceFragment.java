package com.party.parthverma.collegeapp;

import android.app.DownloadManager;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class EceFragment extends Fragment {

    ListView listView;


    private static final String ARG_SECTION_NUMBER = "section_number";

    public static EceFragment newInstance(int sectionNumber) {
        EceFragment fragment = new EceFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);
        return fragment;
    }

    public EceFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.activity_ece, container, false);


        listView = (ListView) rootView.findViewById(R.id.ece_syllabus_list);
        final ArrayList<FuckingSyllabus> FuckingSyllabus.getSyllabus(this);
        SyllabusAdapter adapter = new SyllabusAdapter(this, syllabusList);
        listView.setAdapter(adapter);

        final Context context = getContext();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        });






        return rootView;
}
}
