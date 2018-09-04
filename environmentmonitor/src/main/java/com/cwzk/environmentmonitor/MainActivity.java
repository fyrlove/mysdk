package com.cwzk.environmentmonitor;

import android.content.Intent;
import android.graphics.Rect;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.cwzk.environmentmonitor.activity.BaseActivity;
import com.cwzk.environmentmonitor.activity.LinearChartActivity;
import com.cwzk.environmentmonitor.adapter.MainAdapter;
import com.cwzk.environmentmonitor.adapter.MenuAdapter;
import com.cwzk.environmentmonitor.entity.ItemListEntity;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MainActivity extends BaseActivity {

    private TextView mTitleView;
    private RefreshLayout mRefreshLayoutView;
    private RecyclerView mRecyclerView;
    private MainAdapter mAdapter;
    private Toolbar mToolbar;
    private DrawerLayout mDrawerLayout;

    private RefreshLayout mChildRefreshLayoutView;
    private RecyclerView mChildRecyclerView;
    private String mTitle;

    String[] titles = new String[]{"温度","相对湿度","风速","气压","二氧化碳","光照度","经纬度"
            ,"风向","粉尘","紫外线","太阳总辐射","降雨量","地面温度","声音"};
    String[] contents = new String[]{"26.8℃","5%","1.8 m/s","98.1 kPa","323ppm","50000 lux",
            "1°46′48.1536\r\n-107°37′7.824","-186°北风","5mg/cm³","39w/㎡","175w/㎡",
            "165.6mm","10℃","57dB"};
    Integer[] images = new Integer[]{R.drawable.ic_temperature,R.drawable.ic_humidity,
            R.drawable.ic_wind_speed,R.drawable.ic_pressure,R.drawable.ic_coo,
            R.drawable.ic_illuminance,R.drawable.ic_gps,R.drawable.ic_wind_vane,
            R.drawable.ic_dust,R.drawable.ic_uv_index,R.drawable.ic_solar_radiation,
            R.drawable.ic_rainfall,R.drawable.ic_ground_temperature,R.drawable.ic_voice};
    @Override
    protected void initVariables() {
        mTitle = getIntent().getStringExtra("title");
        if(null==mTitle){
            mTitle = getString(R.string.dorm_monitor);
        }
    }

    @Override
    protected void initViews(Bundle savedInstanceState) {
        setContentView(R.layout.activity_main);
        mTitleView = findViewById(R.id.tvTitle);
        mTitleView.setText(mTitle);
        mToolbar = findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);
        ActionBar actionBar = getSupportActionBar();
        if(actionBar!=null){
            actionBar.setDisplayHomeAsUpEnabled(true);
//            actionBar.setHomeAsUpIndicator(R.drawable.ic_back);
        }
        mDrawerLayout = findViewById(R.id.drawerLayout);
        mRefreshLayoutView = findViewById(R.id.refreshLayout);
        mRefreshLayoutView.setEnableLoadMore(false);
        mRefreshLayoutView.setEnableRefresh(false);
        mRecyclerView = findViewById(R.id.recyclerView);
        mChildRefreshLayoutView = findViewById(R.id.child_refreshLayout);
        mChildRefreshLayoutView.setEnableLoadMore(false);
        mChildRefreshLayoutView.setEnableRefresh(false);
        mChildRecyclerView = findViewById(R.id.child_recyclerView);
//        LinearLayoutManager lm = new LinearLayoutManager(this);
//        mRecyclerView.setLayoutManager(lm);
        final GridLayoutManager gridLayoutManager = new GridLayoutManager(this,2);
        mRecyclerView.addItemDecoration(new RecyclerView.ItemDecoration() {
            @Override
            public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
                GridLayoutManager.LayoutParams layoutParams = (GridLayoutManager.LayoutParams) view.getLayoutParams();
                int spanSize = layoutParams.getSpanSize();
                int spanIndex = layoutParams.getSpanIndex();
                outRect.top = 20;
                if(spanSize!=gridLayoutManager.getSpanCount()){
                    if(spanIndex==1){
                        outRect.left =5;
                        outRect.right = 5;
                    }else{
                        outRect.right = 5;
                        outRect.left =5;
                    }
                }
            }
        });
        mRecyclerView.setLayoutManager(gridLayoutManager);
        mAdapter = new MainAdapter(this);
        mRecyclerView.setAdapter(mAdapter);


        //initNavigationView();
    }
   static List<ItemListEntity> list = new ArrayList<>();
    @Override
    protected void loadData() {
        list.clear();
        for (int i = 0; i < titles.length; i++) {
            ItemListEntity entity = new ItemListEntity();
            entity.title=titles[i];
            entity.content=contents[i];
            entity.imgPath = images[i];
            list.add(entity);
        }
        mAdapter.addList(list);
        mAdapter.notifyDataSetChanged();
    }

    @Override
    protected void initEvent() {
        mRefreshLayoutView.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(@NonNull RefreshLayout refreshLayout) {

            }
        });
        mRefreshLayoutView.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore(@NonNull RefreshLayout refreshLayout) {

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar,menu);
//        menu.add(0,0,0,"设置");
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                finish();
                break;
            case R.id.setting:
                //此处是点击联动按钮打开或者关闭侧边栏
                if(mDrawerLayout.isDrawerOpen(GravityCompat.END)){
                    mDrawerLayout.closeDrawer(GravityCompat.END);
                }else {
                    initMenuItem();
                    mDrawerLayout.openDrawer(GravityCompat.END);
                }
                break;
        }
        return true;
    }


    private void initMenuItem(){
        LinearLayoutManager lm = new LinearLayoutManager(this);
//        mChildRecyclerView.addItemDecoration(new RecyclerView.ItemDecoration() {
//            @Override
//            public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
//                outRect.top = 5;
//            }
//        });
        mChildRecyclerView.setLayoutManager(lm);
        MenuAdapter adapter = new MenuAdapter(new ShowItemListener() {
            @Override
            public void notifyChanged(Map<Integer,Boolean> checkedMap) {
                mAdapter.clearList();
                List<ItemListEntity> showList = new ArrayList<>();
                for(Map.Entry<Integer,Boolean> mm:checkedMap.entrySet()){
                    int index = mm.getKey();
                    list.get(index).isChecked = mm.getValue();
                }
                for(ItemListEntity item : list){
                    if(item.isChecked)
                        showList.add(item);
                }
                mAdapter.addList(showList);
                mAdapter.notifyDataSetChanged();
            }
        },this);
        mChildRecyclerView.setAdapter(adapter);
        adapter.addList(list);
        adapter.notifyDataSetChanged();
    }

    public interface ShowItemListener{
        public void notifyChanged(Map<Integer,Boolean> checkedMap);
    }
    ShowItemListener listener;
}
