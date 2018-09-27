package com.ydky.application;

import android.app.Application;

public class MyApplication extends Application {

    private static MyApplication mApplication = null;

    @Override
    public void onCreate() {
        super.onCreate();
        mApplication = this;
        initShareSDK();
        initJPush();
        initAdSDK();
    }

    public static MyApplication getInstance() {
        return mApplication;
    }

    public void initShareSDK() {
       // ShareManager.initSDK(this);
    }

    private void initJPush() {
//        JPushInterface.setDebugMode(true);
//        JPushInterface.init(this);
    }

    private void initAdSDK() {
//        AdSDKManager.init(this);
    }
}
