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
import android.widget.Button;
import android.widget.Toast;

public class EceFragment extends Fragment {

    String  ece1 = "https://firebasestorage.googleapis.com/v0/b/aiactrapp.appspot.com/o/Syllabus%20CSE%2Fcse%201.pdf?alt=media&token=d1e36cb7-e993-4656-8d40-75c0eab26ab7",
            ece2 = "https://firebasestorage.googleapis.com/v0/b/aiactrapp.appspot.com/o/Syllabus%20CSE%2Fcse%202.pdf?alt=media&token=98ea0c64-3399-486f-b86f-1076ed2b08b3",
            ece3 = "https://firebasestorage.googleapis.com/v0/b/aiactrapp.appspot.com/o/Syllabus%20ECE%2Fece%203.pdf?alt=media&token=772bdd5a-2048-45fc-8dbb-c44ce898a526",
            ece4 = "https://firebasestorage.googleapis.com/v0/b/aiactrapp.appspot.com/o/Syllabus%20ECE%2Fece%204.pdf?alt=media&token=0e0c01aa-5568-4707-8d19-a26530a71ae6",
            ece5 = "https://firebasestorage.googleapis.com/v0/b/aiactrapp.appspot.com/o/Syllabus%20ECE%2Fece%205.pdf?alt=media&token=4f1164bf-c3b5-4fc3-9719-4d8f79c5695c",
            ece6 = "https://firebasestorage.googleapis.com/v0/b/aiactrapp.appspot.com/o/Syllabus%20ECE%2Fece%206.pdf?alt=media&token=e32fd7ef-8c93-45f4-aac1-73c363ac1cb6",
            ece7 = "https://firebasestorage.googleapis.com/v0/b/aiactrapp.appspot.com/o/Syllabus%20ECE%2Fece%207.pdf?alt=media&token=4f4541d1-5829-432e-ba64-a7dada00061d",
            ece8 = "https://firebasestorage.googleapis.com/v0/b/aiactrapp.appspot.com/o/Syllabus%20ECE%2Fece%208.pdf?alt=media&token=7e45fefd-55d4-4bf2-be6d-b7c771b1fa4f";

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



        Button b1 = (Button) rootView.findViewById(R.id.ece_1);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    /*DownloadManager.Request request = new DownloadManager.Request(Uri.parse(ece1));
                    request.setTitle("ECE 1st Semester");
                    //request.setDescription("");
                    request.setAllowedNetworkTypes(DownloadManager.Request.NETWORK_WIFI | DownloadManager.Request.NETWORK_MOBILE);
                    request.allowScanningByMediaScanner();
                    request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);

                    //String name = URLUtil.guessFileName(url, null, MimeTypeMap.getFileExtensionFromUrl(url));
                    //request.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS, name);


                    DownloadManager manager = (DownloadManager) getActivity().getSystemService(Context.DOWNLOAD_SERVICE);
                    manager.enqueue(request);
                    Toast.makeText(getContext(), "Dowmload Started", Toast.LENGTH_LONG).show();*/

                //Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(ece1));
                //startActivity(browserIntent);
                    /*Intent intent = new Intent(Intent.ACTION_VIEW);
                    intent.setDataAndType(Uri.parse( "http://docs.google.com/viewer?url=" + ece1), "text/html");
                    startActivity(intent);*/
                Intent intent = new Intent( v.getContext(), Web.class);
                startActivity(intent);
            }
        });


        Button b2 = (Button) rootView.findViewById(R.id.ece_2);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DownloadManager.Request request = new DownloadManager.Request(Uri.parse(ece2));
                request.setTitle("ECE 2nd Semester");
                //request.setDescription("");
                request.setAllowedNetworkTypes(DownloadManager.Request.NETWORK_WIFI  | DownloadManager.Request.NETWORK_MOBILE);
                request.allowScanningByMediaScanner();
                request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);

                //String name = URLUtil.guessFileName(url, null, MimeTypeMap.getFileExtensionFromUrl(url));
                //request.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS, name);


                DownloadManager manager = (DownloadManager) getActivity().getSystemService(Context.DOWNLOAD_SERVICE);
                manager.enqueue(request);
                Toast.makeText(getContext(), "Dowmload Started", Toast.LENGTH_LONG).show();
            }
        });


        Button b3 = (Button) rootView.findViewById(R.id.ece_3);
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DownloadManager.Request request = new DownloadManager.Request(Uri.parse(ece3));
                request.setTitle("ECE 3rd Semester");
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


        Button b4 = (Button) rootView.findViewById(R.id.ece_4);
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DownloadManager.Request request = new DownloadManager.Request(Uri.parse(ece4));
                request.setTitle("ECE 8th Semester");
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


        Button b5 = (Button) rootView.findViewById(R.id.ece_5);
        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DownloadManager.Request request = new DownloadManager.Request(Uri.parse(ece5));
                request.setTitle("ECE 5th Semester");
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


        Button b6 = (Button) rootView.findViewById(R.id.ece_6);
        b6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DownloadManager.Request request = new DownloadManager.Request(Uri.parse(ece6));
                request.setTitle("ECE 6th Semester");
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


        Button b7 = (Button) rootView.findViewById(R.id.ece_7);
        b7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DownloadManager.Request request = new DownloadManager.Request(Uri.parse(ece7));
                request.setTitle("ECE 7th Semester");
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


        Button b8 = (Button) rootView.findViewById(R.id.ece_8);
        b8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DownloadManager.Request request = new DownloadManager.Request(Uri.parse(ece8));
                request.setTitle("ECE 8th Semester");
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
