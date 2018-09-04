package com.cwzk.environmentmonitor.activity;

import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;

import com.cwzk.environmentmonitor.R;


public class SchoolInfoActivityCJ extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_layout);
        Toolbar toolbar = findViewById(R.id.toolbar);
        CollapsingToolbarLayout collapsingToolbarLayout = findViewById(R.id.collapsing_toolbar);
        ImageView imageView = findViewById(R.id.imageview);
        TextView textView = findViewById(R.id.tvContent);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();

        if(actionBar!=null){
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setDisplayShowTitleEnabled(false);
        }
        //collapsingToolbarLayout.setTitle("学校简介");
        //toolbar.setTitle("学校简介");
        textView.setText(generateContent("just test,"));
    }

    private String generateContent(String str){
        StringBuilder sb = new StringBuilder();
//        for (int i = 0; i < 500; i++) {
//            sb.append(str);
//        }
        sb.append("成都棠湖外国语学校（简称“棠外”，原名四川双流棠湖中学外语实验学校）是经四川省教育厅批准、于2003年建成的一所全寄宿制现代化股份制学校，包括幼儿园、小学部、初中部和高中部（含国际部）。\n" +
                "\n" +
                "学校坐落在双流西南航空港经济开发区核心地带，毗邻双流国际机场，距成都市中心8公里，紧邻机场高速、成雅高速，交通方便快捷。校园被四川大学、西南民族大学、成都信息工程大学等高校的新校区和中科院产业园区环抱，科学文化氛围浓郁，被人们誉为“大学怀抱中的学校”。");
        return sb.toString();
    }
}
