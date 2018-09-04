package com.ydky.network.http;

import com.ydky.module.recommand.BaseRecommandModel;
import com.ydky.constant.HttpConstants;
import com.ydky.vuandroidadsdk.okhttp.CommonOkHttpClient;
import com.ydky.vuandroidadsdk.okhttp.listener.DisposeDataHandle;
import com.ydky.vuandroidadsdk.okhttp.listener.DisposeDataListener;
import com.ydky.vuandroidadsdk.okhttp.request.CommonRequest;
import com.ydky.vuandroidadsdk.okhttp.request.RequestParams;

public class RequestCenter {
    private static void postRequest(String url, RequestParams params, DisposeDataListener listener,Class clazz){
        CommonOkHttpClient.get(CommonRequest.createGetRequest(url,params),new DisposeDataHandle(listener,clazz));
    }

    /**
     * 真正的发送我们的首页请求
     * @param listener
     */
    public static void requestRecommandData(DisposeDataListener listener){
        RequestCenter.postRequest(HttpConstants.HOME_RECOMMAND,null,listener, BaseRecommandModel.class);
    }
}
