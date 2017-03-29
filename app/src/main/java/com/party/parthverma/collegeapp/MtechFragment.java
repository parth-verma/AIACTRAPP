package com.party.parthverma.collegeapp;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by harshit on 27/3/17.
 */


public class MtechFragment extends Fragment {

    ListView listView;
}

    private static final String ARG_SECTION_NUMBER = "section_number";
    public static MtechFragment newInstance(int sectionNumber) {
        MtechFragment fragment = new MtechFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);
        return fragment;
    }
    public MtechFragment() {
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.activity_mtech, container, false);


        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.activity_cse, container, false);

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