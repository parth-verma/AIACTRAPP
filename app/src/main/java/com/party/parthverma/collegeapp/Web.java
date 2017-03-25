package com.party.parthverma.collegeapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;

public class Web extends AppCompatActivity {

    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);


        /*webView = (WebView) findViewById(R.id.webView1);
        webView.getSettings().setJavaScriptEnabled(true);*/
//        webView.loadUrl("http://www.google.com");

        WebView webview = (WebView) findViewById(R.id.webView1);
        webview.getSettings().setJavaScriptEnabled(true);
        String ece1 = "https://firebasestorage.googleapis.com/v0/b/aiactrapp.appspot.com/o/Syllabus%20CSE%2Fcse%201.pdf?alt=media&token=d1e36cb7-e993-4656-8d40-75c0eab26ab7";
        webview.loadUrl("http://drive.google.com/viewerng/viewer?embedded=true&url=" + ece1);
    }
}
