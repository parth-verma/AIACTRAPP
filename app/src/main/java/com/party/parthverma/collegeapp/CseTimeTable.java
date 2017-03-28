package com.party.parthverma.collegeapp;

import android.content.Context;
import android.content.Intent;
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

public class CseTimeTable extends Fragment {

    ListView listView;

    private static final String ARG_SECTION_NUMBER = "section_number";

    public CseTimeTable() {
    }


    public static CseTimeTable newInstance(int sectionNumber) {
        CseTimeTable fragment = new CseTimeTable();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.time_table_cse, container, false);

        listView = (ListView) rootView.findViewById(R.id.timetable_cse);
        final ArrayList<TimeTableCse> timetableList = TimeTableCse.getTimeTableCse(getContext());
        TimeTableAdapter adapter = new TimeTableAdapter(getActivity(), timetableList);
        listView.setAdapter(adapter);

        final Context context = getActivity();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {
                Intent intent = new Intent(context,CseTimeTableDetails.class);
                intent.putExtra("position", position);
                startActivity(intent);
            }
        });

        return rootView;
    }
}
