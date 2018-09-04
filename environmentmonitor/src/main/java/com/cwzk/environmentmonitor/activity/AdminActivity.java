package com.cwzk.environmentmonitor.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.cwzk.environmentmonitor.R;
import com.cwzk.environmentmonitor.fragment.BoyDormFragment;
import com.cwzk.environmentmonitor.test.DataBean;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItemAdapter;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItems;

import fj.dropdownmenu.lib.concat.DropdownI;
import fj.dropdownmenu.lib.ion.ViewInject;
import fj.dropdownmenu.lib.ion.ViewUtils;
import fj.dropdownmenu.lib.pojo.DropdownItemObject;
import fj.dropdownmenu.lib.utils.DropdownUtils;
import fj.dropdownmenu.lib.view.DropdownButton;
import fj.dropdownmenu.lib.view.DropdownColumnView;

public class AdminActivity extends BaseActivity implements DropdownI.ThreeRow{
    DropdownButton btnRegion;
    View mask;
    @ViewInject(R.id.lvRegion)
    DropdownColumnView lvRegion;

    @Override
    protected void initVariables() {
    }

    @Override
    protected void initViews(Bundle savedInstanceState) {
        setContentView(R.layout.activity_admin_layout);
        btnRegion = findViewById(R.id.btnRegion);
        mask = findViewById(R.id.mask);
        lvRegion = findViewById(R.id.lvRegion);
        DropdownUtils.init(this, mask);
        ViewUtils.injectViews(this, mask);

        lvRegion.setThreeRow(this)
                .setSingleRowList(DataBean.getRegionProvince(), -1)  //单列数据
                .setDoubleRowList(DataBean.getRegionCity(), -1)//双列数据
                .setThreeRowList(DataBean.getRegionArea(), -1)//三列数据
                .setButton(btnRegion) //按钮
                .show();

    }

    @Override
    protected void loadData() {

    }

    @Override
    protected void initEvent() {

    }

    @Override
    public void onThreeSingleChanged(DropdownItemObject dropdownItemObject) {

    }

    @Override
    public void onThreeDoubleChanged(DropdownItemObject dropdownItemObject) {

    }

    @Override
    public void onThreeChanged(DropdownItemObject dropdownItemObject) {

    }
}
