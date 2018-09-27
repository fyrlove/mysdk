package com.ydky.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RelativeLayout;

import com.ydky.R;
import com.ydky.vuandroidadsdk.widget.CustomVideoView;

public class TestActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        RelativeLayout mContentLayout = findViewById(R.id.activity_test);
        CustomVideoView customVideoView = new CustomVideoView(this,mContentLayout);
        customVideoView.setDataSource("http://fairee.vicp.net:83/2016rm/0318/sanxing160318.mp4");
        mContentLayout.addView(customVideoView);
    }
}
