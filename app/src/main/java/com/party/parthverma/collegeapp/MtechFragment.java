package com.party.parthverma.collegeapp;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * Created by harshit on 27/3/17.
 */


public class MtechFragment extends Fragment {

    private static final String ARG_SECTION_NUMBER = "section_number";
    ListView listView;

    public MtechFragment() {
    }

    public static MtechFragment newInstance(int sectionNumber) {
        MtechFragment fragment = new MtechFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.activity_mtech, container, false);
        listView = (ListView) rootView.findViewById(R.id.mtech_syllabus_list);

        // change the number of semesters
        String[] values = new String[]{"Semester 1", "Semester 2", "Semester 3", "Semester 4", "Semester 5", "Semester 6", "Semester 7", "Semester 8"};
        ArrayAdapter<String> adapter;
        adapter = new ArrayAdapter<>(getContext(),android.R.layout.simple_list_item_1,values);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //start download here
            }
        });
        return rootView;


    }
}