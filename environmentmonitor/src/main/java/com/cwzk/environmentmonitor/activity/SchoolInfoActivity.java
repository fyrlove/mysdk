package com.cwzk.environmentmonitor.activity;

import android.animation.ObjectAnimator;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.cwzk.environmentmonitor.MainActivity;
import com.cwzk.environmentmonitor.R;
import com.cwzk.environmentmonitor.fragment.HomeFragment;
import com.cwzk.environmentmonitor.fragment.MyFragment;
import com.heima.tabview.library.TabView;
import com.heima.tabview.library.TabViewChild;
import com.itheima.loopviewpager.LoopViewPager;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


public class SchoolInfoActivity extends AppCompatActivity implements View.OnClickListener {

    @BindView(R.id.tvTitle)
    TextView tvTitle;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.lvp_pager)
    LoopViewPager lvpPager;
    @BindView(R.id.tv_one)
    TextView tvOne;
    @BindView(R.id.tv_two)
    TextView tvTwo;
    @BindView(R.id.tv_three)
    TextView tvThree;
    @BindView(R.id.tv_four)
    TextView tvFour;
    @BindView(R.id.tv_five)
    TextView tvFive;
    @BindView(R.id.tv_six)
    TextView tvSix;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_school_info_layout);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            //actionBar.setDisplayHomeAsUpEnabled(true);
        }
//        initEvent();
//        initSchoolData();
        initTabHost();
    }

    private void initTabHost() {
        List<TabViewChild> tabViewChildList=new ArrayList<>();
        TabViewChild tabViewChild01=new TabViewChild(R.mipmap.ic_home_select,R.mipmap.ic_home_default,"首页",  HomeFragment.newInstance("",""));
        TabViewChild tabViewChild02=new TabViewChild(R.mipmap.ic_account_select,R.mipmap.ic_account_default,"我的",  MyFragment.newInstance("",""
        ));
        tabViewChildList.add(tabViewChild01);
        tabViewChildList.add(tabViewChild02);
        TabView tabView = findViewById(R.id.tabView);
        tabView.setTabViewChild(tabViewChildList,getSupportFragmentManager());

    }

    private void initEvent() {
        tvOne.setOnClickListener(this);
        tvTwo.setOnClickListener(this);
        tvThree.setOnClickListener(this);
        tvFour.setOnClickListener(this);
        tvFive.setOnClickListener(this);
        tvSix.setOnClickListener(this);
    }

    private String generateContent(String str) {
        StringBuilder sb = new StringBuilder();
//        for (int i = 0; i < 500; i++) {
//            sb.append(str);
//        }
        sb.append("成都棠湖外国语学校（简称“棠外”，原名四川双流棠湖中学外语实验学校）是经四川省教育厅批准、于2003年建成的一所全寄宿制现代化股份制学校，包括幼儿园、小学部、初中部和高中部（含国际部）。\n" +
                "\n" +
                "学校坐落在双流西南航空港经济开发区核心地带，毗邻双流国际机场，距成都市中心8公里，紧邻机场高速、成雅高速，交通方便快捷。校园被四川大学、西南民族大学、成都信息工程大学等高校的新校区和中科院产业园区环抱，科学文化氛围浓郁，被人们誉为“大学怀抱中的学校”。");
        return sb.toString();
    }

    private void initSchoolData() {
        List<String> imageList = new ArrayList<>();
        imageList.add("http://www.tangwai.com/ver6/Campus/xiaoyuanhj-01.jpg");
        imageList.add("http://www.tangwai.com/ver6/Campus/xiaoyuanhj-03.jpg");
        imageList.add("http://www.tangwai.com/ver6/Campus/xiaoyuanhj-04.jpg");
        imageList.add("http://www.tangwai.com/ver6/Campus/xiaoyuanhj-05.jpg");
        imageList.add("http://www.tangwai.com/ver6/Campus/xiaoyuanhj-07.jpg");
        List<String> titleList = new ArrayList<>();
        titleList.add("棠外高中部");
        titleList.add("棠外广场一角");
        titleList.add("广场一角夜景");
        titleList.add("中学部行政楼");
        titleList.add("棠外科技楼");
        lvpPager.setImgData(imageList);
        lvpPager.setTitleData(titleList);
        lvpPager.start();
    }


    // 动画实际执行
    private void startPropertyAnim(View view) {
        // 将一个TextView沿垂直方向先从原大小（1f）放大到0.8倍大小（0.8f），然后再变回原大小。
        ObjectAnimator anim = ObjectAnimator.ofFloat(view, "scaleY", 1f, 0.8f, 1f);

        anim.setDuration(500);

//        // 回调监听，可以有也可以无。
//        // 根据情况，如果需要监听动画执行到何种“进度”，那么就监听之。
//        anim.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
//
//            @Override
//            public void onAnimationUpdate(ValueAnimator animation) {
//                float value = (Float) animation.getAnimatedValue();
//            }
//        });

        // 正式开始启动执行动画
        anim.start();
    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent();
        startPropertyAnim(view);
        switch (view.getId()){
            case R.id.tv_one:
                intent.setClass(SchoolInfoActivity.this, MainActivity.class);
                startActivity(intent);
                break;
        }

    }

}
