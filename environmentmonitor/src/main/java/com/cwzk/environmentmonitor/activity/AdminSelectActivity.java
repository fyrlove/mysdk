package com.cwzk.environmentmonitor.activity;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.cwzk.environmentmonitor.R;
import com.cwzk.environmentmonitor.adapter.GirlNumberAdapter;
import com.cwzk.environmentmonitor.fragment.BoyDormFragment;
import com.cwzk.environmentmonitor.fragment.GirlDormFragment;
import com.ogaclejapan.smarttablayout.SmartTabLayout;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItemAdapter;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItems;

public class AdminSelectActivity extends BaseActivity {
    SmartTabLayout mSmartTabLayout;
    ViewPager mViewPager;
    TextView mTitle;

    @Override
    protected void initVariables() {

    }

    @Override
    protected void initViews(Bundle savedInstanceState) {
        setContentView(R.layout.activity_admin_select_layout);
        mSmartTabLayout = findViewById(R.id.viewpagertab);
        mViewPager = findViewById(R.id.viewpager);
        mTitle = findViewById(R.id.tvTitle);
        mTitle.setText(R.string.admin_drom_delect_title);
        FragmentPagerItemAdapter adapter = new FragmentPagerItemAdapter(getSupportFragmentManager(), FragmentPagerItems.with(mActivity)
                .add(getString(R.string.fragment_boy_drom), BoyDormFragment.class)
                .add(getString(R.string.fragment_girl_drom), GirlDormFragment.class)
                .create());
        mViewPager.setAdapter(adapter);
        mSmartTabLayout.setViewPager(mViewPager);
    }

    @Override
    protected void loadData() {

    }

    @Override
    protected void initEvent() {

    }
}
