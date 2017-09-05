package com.party.parthverma.collegeapp;

import android.content.ActivityNotFoundException;
import android.content.Intent;
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

import java.io.File;

/**
 * Created by harshit on 27/3/17.
 */

public class CseFragment extends Fragment {

    private static final String ARG_SECTION_NUMBER = "section_number";
    ListView listView;
    View.OnClickListener listener;
    int posi;
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
        final View rootView = inflater.inflate(R.layout.activity_cse, container, false);
        listView = (ListView) rootView.findViewById(R.id.cse_syllabus_list);

        downloadManager = new ThinDownloadManager();
        String[] values = new String[]{"Semester 1", "Semester 2", "Semester 3", "Semester 4", "Semester 5", "Semester 6", "Semester 7", "Semester 8"};

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_list_item_1, values);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, final int position, long id) {
                FirebaseStorage storage = FirebaseStorage.getInstance();
                final String file_path = getContext().getExternalCacheDir().toString() + "/cse" + Integer.toString(position + 1) + ".pdf";
                File file = new File(file_path);
                posi = position;
                if (file.exists()){
                    Log.d("OPENING",file.getAbsolutePath());
                    Intent target = new Intent(Intent.ACTION_VIEW);
                    target.setDataAndType(Uri.fromFile(file), "application/pdf");
                    target.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
                    Intent intent = Intent.createChooser(target, "Open File");
                    try {
                        startActivity(intent);
                    } catch (ActivityNotFoundException e) {
                        // Instruct the user to install a PDF reader here, or something
                    }
                }
                else {
                    StorageReference storageRef = storage.getReference();
                    Log.d("DOWNLOAD", Integer.toString(position));
                    storageRef.child("/Syllabus CSE/cse " + Integer.toString(position + 1) + ".pdf").getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                        @Override
                        public void onSuccess(Uri uri) {
                            Log.d("DOWNLOAD", uri.toString());
                            Uri destinationUri = Uri.parse(file_path);
                            DownloadRequest downloadRequest = new DownloadRequest(uri)
                                    .setRetryPolicy(new DefaultRetryPolicy())
                                    .setDestinationURI(destinationUri)
                                    .setStatusListener(new DownloadStatusListenerV1() {
                                        @Override
                                        public void onDownloadComplete(DownloadRequest downloadRequest) {
                                            Log.d("DOWNLOAD", "complete");
                                            String message = "Downloaded CSE " + Integer.toString(posi + 1) + " Syllabus";
                                            Snackbar.make(getActivity().findViewById(android.R.id.content), message, 2000)
                                                    .setAction("Open", listener)
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

            }
        });

        listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                File file = new File(getContext().getExternalCacheDir().toString() + "/cse" + Integer.toString(posi + 1) + ".pdf");
                Log.d("DOWNLOAD",file.getAbsolutePath());
                Intent target = new Intent(Intent.ACTION_VIEW);
                target.setDataAndType(Uri.fromFile(file), "application/pdf");
                target.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
                Intent intent = Intent.createChooser(target, "Open File");
                try {
                    startActivity(intent);
                } catch (ActivityNotFoundException e) {
                    // Instruct the user to install a PDF reader here, or something
                }
            }

        };
        return rootView;


    }


}
