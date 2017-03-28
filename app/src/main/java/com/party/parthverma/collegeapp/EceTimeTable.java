package com.party.parthverma.collegeapp;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by harshit on 27/3/17.
 */

public class EceTimeTable extends Fragment {

    private static final String ARG_SECTION_NUMBER = "section_number";

    public EceTimeTable() {
    }


    public static EceTimeTable newInstance(int sectionNumber) {
        EceTimeTable fragment = new EceTimeTable();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.time_table_ece, container, false);
        return rootView;
    }
}