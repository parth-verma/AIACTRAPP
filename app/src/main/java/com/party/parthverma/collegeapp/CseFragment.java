package com.party.parthverma.collegeapp;

import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.thin.downloadmanager.DefaultRetryPolicy;
import com.thin.downloadmanager.DownloadRequest;
import com.thin.downloadmanager.DownloadStatusListenerV1;
import com.thin.downloadmanager.ThinDownloadManager;

/**
 * Created by harshit on 27/3/17.
 */

public class CseFragment extends Fragment {

    private static final String ARG_SECTION_NUMBER = "section_number";
    ListView listView;
    private ThinDownloadManager downloadManager;


    public CseFragment() {
    }

    public static CseFragment newInstance(int sectionNumber) {
        CseFragment fragment = new CseFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.activity_cse, container, false);
        listView = (ListView) rootView.findViewById(R.id.cse_syllabus_list);
        downloadManager = new ThinDownloadManager();
        String[] values = new String[]{"Semester 1", "Semester 2", "Semester 3", "Semester 4", "Semester 5", "Semester 6", "Semester 7", "Semester 8"};

        ArrayAdapter adapter = new ArrayAdapter(getContext(), android.R.layout.simple_list_item_1, values);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, final int position, long id) {
                FirebaseStorage storage = FirebaseStorage.getInstance();
                StorageReference storageRef = storage.getReference();
                Log.d("DOWNLOAD", Integer.toString(position));
                storageRef.child("/Syllabus CSE/cse " + Integer.toString(position + 1) + ".pdf").getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                    @Override
                    public void onSuccess(Uri uri) {
                        Log.d("DOWNLOAD", uri.toString());
                        Uri destinationUri = Uri.parse(getContext().getExternalCacheDir().toString() + "/cse" + Integer.toString(position + 1) + ".pdf");
                        DownloadRequest downloadRequest = new DownloadRequest(uri)
                                .setRetryPolicy(new DefaultRetryPolicy())
                                .setDestinationURI(destinationUri)
                                .setStatusListener(new DownloadStatusListenerV1() {
                                    @Override
                                    public void onDownloadComplete(DownloadRequest downloadRequest) {
                                        Log.d("DOWNLOAD", "complete");
                                        Snackbar.make(getView().findViewById(android.R.id.content), "Downloaded CSE " + Integer.toString(position + 1) + " Syllabus", Snackbar.LENGTH_LONG)
                                                .setAction("Open", mOnClickListener)
                                                .setActionTextColor(Color.RED)
                                                .show();
                                    }

                                    @Override
                                    public void onDownloadFailed(DownloadRequest downloadRequest, int errorCode, String errorMessage) {
                                        Log.d("DOWNLOADError", errorMessage);
                                    }

                                    @Override
                                    public void onProgress(DownloadRequest downloadRequest, long totalBytes, long downloadedBytes, int progress) {
                                        Log.d("Progress: ", Integer.toString(progress));
                                    }
                                });
                        downloadManager.add(downloadRequest);
                    }
                });

            }
        });


        return rootView;
    }
}
