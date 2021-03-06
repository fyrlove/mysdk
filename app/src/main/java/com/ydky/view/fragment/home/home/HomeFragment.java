package com.ydky.view.fragment.home.home;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.ydky.R;
import com.ydky.adapter.CourseAdapter;
import com.ydky.constant.Constant;
import com.ydky.module.recommand.BaseRecommandModel;
import com.ydky.module.recommand.RecommandBodyValue;
import com.ydky.network.http.RequestCenter;
import com.ydky.util.Util;
import com.ydky.view.fragment.BaseFragment;
import com.ydky.view.home.HomeHeaderLayout;
import com.ydky.vuandroidadsdk.activity.AdBrowserActivity;
import com.ydky.vuandroidadsdk.okhttp.listener.DisposeDataListener;
import com.ydky.vuandroidadsdk.utils.T;
import com.ydky.zxing.app.CaptureActivity;


/**
 * 主页fragment
 */
public class HomeFragment extends BaseFragment implements View.OnClickListener,AdapterView.OnItemClickListener{
    private static final int REQUEST_QRCODE = 0x01;
    /**
     * UI
     */
    private View mContentView;
    private ListView mListView;
    private TextView mQRCodeView;
    private TextView mCategoryView;
    private TextView mSearchView;
    private ImageView mLoadingView;
    /**
     * data
     */
    private CourseAdapter mAdapter;
    private BaseRecommandModel mRecommandData;

    public HomeFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestRecommandData();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mContext = getActivity();
        mContentView = inflater.inflate(R.layout.fragment_home_layout, container, false);
        initView();
        return mContentView;
    }

    private void initView() {
        mQRCodeView = (TextView) mContentView.findViewById(R.id.qrcode_view);
        mQRCodeView.setOnClickListener(this);
        mCategoryView = (TextView) mContentView.findViewById(R.id.category_view);
        mCategoryView.setOnClickListener(this);
        mSearchView = (TextView) mContentView.findViewById(R.id.search_view);
        mSearchView.setOnClickListener(this);
        mListView = (ListView) mContentView.findViewById(R.id.list_view);
        mListView.setOnItemClickListener(this);
        mLoadingView = (ImageView) mContentView.findViewById(R.id.loading_view);
        AnimationDrawable anim = (AnimationDrawable) mLoadingView.getDrawable();
        anim.start();
    }

    //发送推荐产品请求
    private void requestRecommandData() {
        RequestCenter.requestRecommandData(new DisposeDataListener() {
            @Override
            public void onSuccess(Object responseObj) {
                mRecommandData = (BaseRecommandModel) responseObj;
                //更新UI
                showSuccessView();
            }

            @Override
            public void onFailure(Object reasonObj) {
                //显示请求失败View
                showErrorView();
            }
        });
    }

    //显示请求成功UI
    private void showSuccessView() {
        if (mRecommandData.data.list != null && mRecommandData.data.list.size() > 0) {
            mLoadingView.setVisibility(View.GONE);
            mListView.setVisibility(View.VISIBLE);
            //为listview添加头
            mListView.addHeaderView(new HomeHeaderLayout(mContext, mRecommandData.data.head));
            mAdapter = new CourseAdapter(mContext, mRecommandData.data.list);
            mListView.setAdapter(mAdapter);
            mListView.setOnScrollListener(new AbsListView.OnScrollListener() {
                @Override
                public void onScrollStateChanged(AbsListView view, int scrollState) {
                }

                @Override
                public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
                    mAdapter.updateAdInScrollView();
                }
            });
        } else {
            showErrorView();
        }
    }

    private void showErrorView() {
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.qrcode_view:
                if (hasPermission(Constant.HARDWEAR_CAMERA_PERMISSION)) {
                    doOpenCamera();
                } else {
                    requestPermission(Constant.HARDWEAR_CAMERA_CODE, Constant.HARDWEAR_CAMERA_PERMISSION);
                }
                break;
            case R.id.category_view:
                //与我交谈
                Intent intent2 = new Intent(Intent.ACTION_VIEW, Util.createQQUrl("277451977"));
                intent2.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent2);
                break;
            case R.id.search_view:
//                Intent searchIntent = new Intent(mContext, SearchActivity.class);
//                mContext.startActivity(searchIntent);
                break;
        }
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        RecommandBodyValue value = (RecommandBodyValue) mAdapter.getItem(position - mListView.getHeaderViewsCount());
        if (value.type != 0) {
//            Intent intent = new Intent(mContext, PhotoViewActivity.class);
//            intent.putStringArrayListExtra(PhotoViewActivity.PHOTO_LIST, value.url);
//            startActivity(intent);
        }
    }

    @Override
    public void doOpenCamera() {
        Intent intent = new Intent(mContext, CaptureActivity.class);
        startActivityForResult(intent, REQUEST_QRCODE);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode) {
            case REQUEST_QRCODE:
                if (resultCode == Activity.RESULT_OK) {
                    String code = data.getStringExtra("SCAN_RESULT");
                    if (code.contains("http") || code.contains("https")) {
                        Intent intent = new Intent(mContext, AdBrowserActivity.class);
                        intent.putExtra(AdBrowserActivity.KEY_URL, code);
                        startActivity(intent);
                    } else {
                        Toast.makeText(mContext, code, Toast.LENGTH_SHORT).show();
                    }
                }
                break;
        }
    }
//    private static final int REQUEST_QRCODE = 0x01;
//    /**
//     * UI
//     */
//    private View mContentView;
//    private ListView mListView;
//    private TextView mQRCodeView;
//    private TextView mCategoryView;
//    private TextView mSearchView;
//    private ImageView mLoadingView;
//
//    private CourseAdapter mAdapter;
//    /**
//     * data
//     */
//    private BaseRecommandModel mRecommandData;
//    public HomeFragment() {
//    }
//
//    @Override
//    public void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        requestRecommandData();
//    }
//
//    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
//        mContext = getActivity();
//        mContentView = inflater.inflate(R.layout.fragment_home_layout, container, false);
//        initView();
//        return mContentView;
//    }
//
//    private void initView() {
//        mQRCodeView = (TextView) mContentView.findViewById(R.id.qrcode_view);
//        mQRCodeView.setOnClickListener(this);
//        mCategoryView = (TextView) mContentView.findViewById(R.id.category_view);
//        mCategoryView.setOnClickListener(this);
//        mSearchView = (TextView) mContentView.findViewById(R.id.search_view);
//        mSearchView.setOnClickListener(this);
//        mListView = (ListView) mContentView.findViewById(R.id.list_view);
//        mListView.setOnItemClickListener(this);
//        mLoadingView = (ImageView) mContentView.findViewById(R.id.loading_view);
//        AnimationDrawable anim = (AnimationDrawable) mLoadingView.getDrawable();
//        anim.start();
//    }
//
//    /**
//     * 发送首页列表请求数据
//     */
//    private void requestRecommandData(){
//        RequestCenter.requestRecommandData(new DisposeDataListener() {
//            @Override
//            public void onSuccess(Object responseObj) {
//                //完成真正的功能逻辑
//                Log.i("request", "onSuccess: "+responseObj.toString());
//                mRecommandData = (BaseRecommandModel) responseObj;
//                showSuccessView();
//            }
//
//            @Override
//            public void onFailure(Object reasonObj) {
//                //提示用户网络有问题
//                Log.i("request", "onFailure: "+reasonObj.toString());
//                showErrorView();
//            }
//        });
//    }
//
//    /**
//     * 请求成功执行的方法
//     */
//    private void showSuccessView() {
//        //判断数据是否为空
//        if(mRecommandData.data.list!=null && mRecommandData.data.list.size()>0){
//            mLoadingView.setVisibility(View.GONE);
//            mListView.setVisibility(View.VISIBLE);
//            //为listview添加头
//            mListView.addHeaderView(new HomeHeaderLayout(mContext, mRecommandData.data.head));
//            mAdapter = new CourseAdapter(mContext,mRecommandData.data.list);
//            mListView.setAdapter(mAdapter);
//            mListView.setOnScrollListener(new AbsListView.OnScrollListener() {
//                @Override
//                public void onScrollStateChanged(AbsListView view, int scrollState) {
//                }
//
//                @Override
//                public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
//                    mAdapter.updateAdInScrollView();
//                }
//            });
//        }else{
//            showErrorView();
//        }
//    }
//
//    /**
//     * 请求失败后执行的方法
//     */
//    private void showErrorView() {
//    }
//
//    @Override
//    public void onClick(View view) {
//        switch (view.getId()){
//            case R.id.qrcode_view:
////                startActivity(new Intent(getActivity(),AppCompatActivity.class));
//                if (hasPermission(Constant.HARDWEAR_CAMERA_PERMISSION)) {
//                    doOpenCamera();
//                } else {
//                    requestPermission(Constant.HARDWEAR_CAMERA_CODE, Constant.HARDWEAR_CAMERA_PERMISSION);
//                }
//                break;
//            case R.id.category_view:
//                //与我交谈
//                Intent intent2 = new Intent(Intent.ACTION_VIEW, Util.createQQUrl("277451977"));
//                intent2.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//                startActivity(intent2);
//                break;
//            case R.id.search_view:
////                Intent searchIntent = new Intent(mContext, SearchActivity.class);
////                mContext.startActivity(searchIntent);
//                break;
//        }
//    }
//
//    @Override
//    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//
//    }
//
//    @Override
//    public void doOpenCamera() {
//        Intent intent = new Intent(mContext, CaptureActivity.class);
//        startActivityForResult(intent, REQUEST_QRCODE);
//    }
//
//    @Override
//    public void onActivityResult(int requestCode, int resultCode, Intent data) {
//        switch (requestCode) {
//            case REQUEST_QRCODE:
//                if (resultCode == Activity.RESULT_OK) {
//                    String code = data.getStringExtra("SCAN_RESULT");
//                    T.show(mContext,code, Toast.LENGTH_SHORT);
//                    if (code.contains("http") || code.contains("https")) {
//                        Intent intent = new Intent(mContext, AdBrowserActivity.class);
//                        intent.putExtra(AdBrowserActivity.KEY_URL, code);
//                        startActivity(intent);
//                    } else {
//                        Toast.makeText(mContext, code, Toast.LENGTH_SHORT).show();
//                    }
//                }
//                break;
//        }
//    }
}