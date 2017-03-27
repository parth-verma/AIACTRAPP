package com.party.parthverma.collegeapp;

import android.app.DownloadManager;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

/**
 * Created by harshit on 27/3/17.
 */

public class CseFragment extends Fragment {


    String  cse1 = "https://firebasestorage.googleapis.com/v0/b/aiactrapp.appspot.com/o/Syllabus%20CSE%2Fcse%201.pdf?alt=media&token=d1e36cb7-e993-4656-8d40-75c0eab26ab7",
            cse2 = "https://firebasestorage.googleapis.com/v0/b/aiactrapp.appspot.com/o/Syllabus%20CSE%2Fcse%202.pdf?alt=media&token=98ea0c64-3399-486f-b86f-1076ed2b08b3",
            cse3 = "https://firebasestorage.googleapis.com/v0/b/aiactrapp.appspot.com/o/Syllabus%20CSE%2Fcse%203%20sem.pdf?alt=media&token=63361837-b06a-46d6-b32e-ba22c9a63317",
            cse4 = "https://firebasestorage.googleapis.com/v0/b/aiactrapp.appspot.com/o/Syllabus%20CSE%2Fcse%204th%20sem.pdf?alt=media&token=ba06d2c6-0c95-492a-893a-239cdae0bb6e",
            cse5 = "https://firebasestorage.googleapis.com/v0/b/aiactrapp.appspot.com/o/Syllabus%20CSE%2Fcse%205th%20sem.pdf?alt=media&token=c664ba58-deb1-479c-ad86-49bb257c1f1a",
            cse6 = "https://firebasestorage.googleapis.com/v0/b/aiactrapp.appspot.com/o/Syllabus%20CSE%2Fcse%205th%20sem.pdf?alt=media&token=c664ba58-deb1-479c-ad86-49bb257c1f1a",
            cse7 = "https://firebasestorage.googleapis.com/v0/b/aiactrapp.appspot.com/o/Syllabus%20CSE%2Fcse%207th%20sem.pdf?alt=media&token=d6ecf49d-d241-4edb-a875-f83f204eb904",
            cse8 = "https://firebasestorage.googleapis.com/v0/b/aiactrapp.appspot.com/o/Syllabus%20CSE%2Fcse%208th%20sem.pdf?alt=media&token=024d9ffd-bcbf-47f7-a0fc-d911c2497342";

    private static final String ARG_SECTION_NUMBER = "section_number";


    public static CseFragment newInstance(int sectionNumber) {
        CseFragment fragment = new CseFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);
        return fragment;
    }

    public CseFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.activity_cse, container, false);

        Button b1 = (Button) rootView.findViewById(R.id.cse_1);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DownloadManager.Request request = new DownloadManager.Request(Uri.parse(cse1));
                request.setTitle("CSE 1st Semester");
                //request.setDescription("");
                request.setAllowedNetworkTypes(DownloadManager.Request.NETWORK_WIFI | DownloadManager.Request.NETWORK_MOBILE);
                request.allowScanningByMediaScanner();
                request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);

                //String name = URLUtil.guessFileName(url, null, MimeTypeMap.getFileExtensionFromUrl(url));
                //request.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS, name);


                DownloadManager manager = (DownloadManager) getActivity().getSystemService(Context.DOWNLOAD_SERVICE);
                manager.enqueue(request);
                Toast.makeText(getContext(), "Dowmload Started", Toast.LENGTH_LONG).show();
            }
        });


        Button b2 = (Button) rootView.findViewById(R.id.cse_2);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DownloadManager.Request request = new DownloadManager.Request(Uri.parse(cse2));
                request.setTitle("CSE 2nd Semester");
                //request.setDescription("");
                request.setAllowedNetworkTypes(DownloadManager.Request.NETWORK_WIFI | DownloadManager.Request.NETWORK_MOBILE);
                request.allowScanningByMediaScanner();
                request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);

                //String name = URLUtil.guessFileName(url, null, MimeTypeMap.getFileExtensionFromUrl(url));
                //request.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS, name);


                DownloadManager manager = (DownloadManager) getActivity().getSystemService(Context.DOWNLOAD_SERVICE);
                manager.enqueue(request);
                Toast.makeText(getContext(), "Dowmload Started", Toast.LENGTH_LONG).show();
            }
        });



        Button b3 = (Button) rootView.findViewById(R.id.cse_3);
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DownloadManager.Request request = new DownloadManager.Request(Uri.parse(cse3));
                request.setTitle("CSE 3rd Semester");
                //request.setDescription("");
                request.setAllowedNetworkTypes(DownloadManager.Request.NETWORK_WIFI | DownloadManager.Request.NETWORK_MOBILE);
                request.allowScanningByMediaScanner();
                request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);

                //String name = URLUtil.guessFileName(url, null, MimeTypeMap.getFileExtensionFromUrl(url));
                //request.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS, name);


                DownloadManager manager = (DownloadManager) getActivity().getSystemService(Context.DOWNLOAD_SERVICE);
                manager.enqueue(request);
                Toast.makeText(getContext(), "Dowmload Started", Toast.LENGTH_LONG).show();
            }
        });


        Button b4 = (Button) rootView.findViewById(R.id.cse_4);
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DownloadManager.Request request = new DownloadManager.Request(Uri.parse(cse4));
                request.setTitle("CSE 4th Semester");
                //request.setDescription("");
                request.setAllowedNetworkTypes(DownloadManager.Request.NETWORK_WIFI | DownloadManager.Request.NETWORK_MOBILE);
                request.allowScanningByMediaScanner();
                request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);

                //String name = URLUtil.guessFileName(url, null, MimeTypeMap.getFileExtensionFromUrl(url));
                //request.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS, name);


                DownloadManager manager = (DownloadManager) getActivity().getSystemService(Context.DOWNLOAD_SERVICE);
                manager.enqueue(request);
                Toast.makeText(getContext(), "Dowmload Started", Toast.LENGTH_LONG).show();
            }
        });


        Button b5 = (Button) rootView.findViewById(R.id.cse_5);
        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DownloadManager.Request request = new DownloadManager.Request(Uri.parse(cse5));
                request.setTitle("CSE 5th Semester");
                //request.setDescription("");
                request.setAllowedNetworkTypes(DownloadManager.Request.NETWORK_WIFI | DownloadManager.Request.NETWORK_MOBILE);
                request.allowScanningByMediaScanner();
                request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);

                //String name = URLUtil.guessFileName(url, null, MimeTypeMap.getFileExtensionFromUrl(url));
                //request.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS, name);


                DownloadManager manager = (DownloadManager) getActivity().getSystemService(Context.DOWNLOAD_SERVICE);
                manager.enqueue(request);
                Toast.makeText(getContext(), "Dowmload Started", Toast.LENGTH_LONG).show();
            }
        });


        Button b6 = (Button) rootView.findViewById(R.id.cse_6);
        b6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DownloadManager.Request request = new DownloadManager.Request(Uri.parse(cse6));
                request.setTitle("CSE 6th Semester");
                //request.setDescription("");
                request.setAllowedNetworkTypes(DownloadManager.Request.NETWORK_WIFI | DownloadManager.Request.NETWORK_MOBILE);
                request.allowScanningByMediaScanner();
                request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);

                //String name = URLUtil.guessFileName(url, null, MimeTypeMap.getFileExtensionFromUrl(url));
                //request.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS, name);


                DownloadManager manager = (DownloadManager) getActivity().getSystemService(Context.DOWNLOAD_SERVICE);
                manager.enqueue(request);
                Toast.makeText(getContext(), "Dowmload Started", Toast.LENGTH_LONG).show();
            }
        });


        Button b7 = (Button) rootView.findViewById(R.id.cse_7);
        b7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DownloadManager.Request request = new DownloadManager.Request(Uri.parse(cse7));
                request.setTitle("CSE 7th Semester");
                //request.setDescription("");
                request.setAllowedNetworkTypes(DownloadManager.Request.NETWORK_WIFI | DownloadManager.Request.NETWORK_MOBILE);
                request.allowScanningByMediaScanner();
                request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);

                //String name = URLUtil.guessFileName(url, null, MimeTypeMap.getFileExtensionFromUrl(url));
                //request.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS, name);


                DownloadManager manager = (DownloadManager) getActivity().getSystemService(Context.DOWNLOAD_SERVICE);
                manager.enqueue(request);
                Toast.makeText(getContext(), "Dowmload Started", Toast.LENGTH_LONG).show();
            }
        });


        Button b8 = (Button) rootView.findViewById(R.id.cse_8);
        b8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DownloadManager.Request request = new DownloadManager.Request(Uri.parse(cse8));
                request.setTitle("CSE 8th Semester");
                //request.setDescription("");
                request.setAllowedNetworkTypes(DownloadManager.Request.NETWORK_WIFI | DownloadManager.Request.NETWORK_MOBILE);
                request.allowScanningByMediaScanner();
                request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);

                //String name = URLUtil.guessFileName(url, null, MimeTypeMap.getFileExtensionFromUrl(url));
                //request.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS, name);


                DownloadManager manager = (DownloadManager) getActivity().getSystemService(Context.DOWNLOAD_SERVICE);
                manager.enqueue(request);
                Toast.makeText(getContext(), "Dowmload Started", Toast.LENGTH_LONG).show();
            }
        });






        return rootView;
    }
}
