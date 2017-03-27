package com.party.parthverma.collegeapp;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by harshit on 27/3/17.
 */


public class MtechFragment extends Fragment {

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
        return rootView;
    }
}