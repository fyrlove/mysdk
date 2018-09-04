package com.ydky.vuandroidadsdk.okhttp;

import com.ydky.vuandroidadsdk.okhttp.https.HttpsUtils;
import com.ydky.vuandroidadsdk.okhttp.listener.DisposeDataHandle;
import com.ydky.vuandroidadsdk.okhttp.response.CommonJsonCallback;

import java.util.concurrent.TimeUnit;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;

/**
 * @function 请求的发送，请求参数的配置，https支持
 *
 */
public class CommonOkHttpClient {

    private static final int TIME_OUT = 30;
    private static OkHttpClient mOkHttpClient;

    //为client配置参数
    static{
        //创建我们client对象的构建者
        OkHttpClient.Builder okHttpBuilder = new OkHttpClient.Builder();
        //为构建者填充超时时间
        okHttpBuilder.connectTimeout(TIME_OUT, TimeUnit.SECONDS);
        okHttpBuilder.readTimeout(TIME_OUT,TimeUnit.SECONDS);
        okHttpBuilder.writeTimeout(TIME_OUT,TimeUnit.SECONDS);

        okHttpBuilder.followRedirects(true);

        //https支持
        okHttpBuilder.hostnameVerifier(new HostnameVerifier() {
            @Override
            public boolean verify(String s, SSLSession sslSession) {
                return true;
            }
        });

        /**
         * trust all the https point
         */
        okHttpBuilder.sslSocketFactory(HttpsUtils.initSSLSocketFactory(), HttpsUtils.initTrustManager());
        mOkHttpClient = okHttpBuilder.build();
    }

    /**
     * 发送具体的http/https请求
     * @param request
     * @param callback
     * @return
     */
    public static Call sendRequest(Request request, CommonJsonCallback callback){
        Call call = mOkHttpClient.newCall(request);
        call.enqueue(callback);
        return call;
    }

    //封装CommonJsonCallback前使用
//    public static Call sendRequest(Request request, Callback callback){
//        Call call = mOkHttpClient.newCall(request);
//        call.enqueue(callback);
//        return call;
//    }


    public static Call get(Request request, DisposeDataHandle handle) {
        Call call = mOkHttpClient.newCall(request);
        call.enqueue(new CommonJsonCallback(handle));
        return call;
    }

    public static Call post(Request request, DisposeDataHandle handle) {
        Call call = mOkHttpClient.newCall(request);
        call.enqueue(new CommonJsonCallback(handle));
        return call;
    }

//    public static Call downloadFile(Request request, DisposeDataHandle handle) {
//        Call call = mOkHttpClient.newCall(request);
//        call.enqueue(new CommonFileCallback(handle));
//        return call;
//    }
}
