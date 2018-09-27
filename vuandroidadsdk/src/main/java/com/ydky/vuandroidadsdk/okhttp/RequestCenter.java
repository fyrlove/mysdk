package com.ydky.vuandroidadsdk.okhttp;

import com.ydky.vuandroidadsdk.module.AdInstance;
import com.ydky.vuandroidadsdk.okhttp.listener.DisposeDataHandle;
import com.ydky.vuandroidadsdk.okhttp.listener.DisposeDataListener;
import com.ydky.vuandroidadsdk.okhttp.request.CommonRequest;

/**
 * Created by renzhiqiang on 16/10/27.
 *
 * @function sdk请求发送中心
 */
public class RequestCenter {

    /**
     * 发送广告请求
     */
    public static void sendImageAdRequest(String url, DisposeDataListener listener) {

        CommonOkHttpClient.post(CommonRequest.createPostRequest(url, null),
                new DisposeDataHandle(listener, AdInstance.class));
    }
}
