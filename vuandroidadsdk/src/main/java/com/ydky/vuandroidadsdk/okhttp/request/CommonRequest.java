package com.ydky.vuandroidadsdk.okhttp.request;

import java.util.Map;

import okhttp3.FormBody;
import okhttp3.Request;

/**
 * 接收请求参数，生成Request对象
 */
public class CommonRequest {

    /**
     *
     * @param url
     * @param params
     * @return 返回一个创建好的Request对象
     */
    public static Request createPostRequest(String url,RequestParams params){
        FormBody.Builder mFormBodyBuilder = new FormBody.Builder();
        if(params!=null){
            for (Map.Entry<String,String> entry:params.urlParams.entrySet()) {
                //将请求参数逐一遍历添加到我们的请求类中
                mFormBodyBuilder.add(entry.getKey(),entry.getValue());
            }
        }
        FormBody mFormBody = mFormBodyBuilder.build();
        return  new Request.Builder().url(url).post(mFormBody).build();
    }

    /**
     *
     * @param url
     * @param params
     * @return 返回一个创建好的Get Request对象
     */
    public static Request createGetRequest(String url,RequestParams params){
        StringBuilder urlBuilder = new StringBuilder(url).append("?");
        if(params!=null){
            for (Map.Entry<String,String> entry:params.urlParams.entrySet()) {
                urlBuilder.append(entry.getKey()).append("=").append(
                        entry.getValue()).append("&");
            }
        }
        return new Request.Builder().url(urlBuilder.substring(0,urlBuilder.length()-1)).get().build();
    }
}
