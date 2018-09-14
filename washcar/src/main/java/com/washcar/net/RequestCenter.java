package com.washcar.net;

import android.util.Log;

import com.washcar.constant.HttpConstants;
import com.washcar.entity.ResponseRoot;
import com.washcar.utils.DateUtils;
import com.washcar.utils.EncryptUtil;
import com.ydky.vuandroidadsdk.okhttp.CommonOkHttpClient;
import com.ydky.vuandroidadsdk.okhttp.listener.DisposeDataHandle;
import com.ydky.vuandroidadsdk.okhttp.listener.DisposeDataListener;
import com.ydky.vuandroidadsdk.okhttp.request.CommonRequest;
import com.ydky.vuandroidadsdk.okhttp.request.RequestParams;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class RequestCenter {
    private static void postRequest(String url, RequestParams params, DisposeDataListener listener, Class clazz) {
        CommonOkHttpClient.post(CommonRequest.createPostRequest(url, params), new DisposeDataHandle(listener, clazz));
    }

    /**
     * 订购请求
     *
     * @param listener
     */
    public static void requestRecommandData(DisposeDataListener listener) {
        try {


        String sign = getSign();
            Map<String, String> map = new HashMap<>();
            map.put("appKey", "5bcdc32a4f3672b7d285a40de1ceb1774da33d2a");
            map.put("ts", DateUtils.dateToString(new Date(),DateUtils.yyyyMMddHHmmssSSS));
            map.put("mobile", "15208326547");
            map.put("prodCode", "CS001");
            map.put("backUrl", "zlegou.natapp1.cc");
            map.put("transNo", "11111111111111");
        map.put("sign", sign);
        RequestParams params = new RequestParams(map);
        RequestCenter.postRequest(HttpConstants.CARD_ORDER_URL,params,listener, ResponseRoot.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static final String TAG = "RequestCenter";
   public static String getSign(){
        try {
        Map<String, String> map = new HashMap<>();
        map.put("appSecret", "6d72c5d200a7faa3be318e4d70f925c286fbf712");
        map.put("ts", DateUtils.dateToString(new Date(),DateUtils.yyyyMMddHHmmssSSS));
        map.put("mobile", "15208326547");
        map.put("prodCode", "CS001");
        map.put("backUrl", "zlegou.natapp1.cc");
        map.put("transNo", "11111111111111");
        String params = "";
        Collection<String> keyset= map.keySet();

        List list=new ArrayList<String>(keyset);

        Collections.sort(list);
//这种打印出的字符串顺序和微信官网提供的字典序顺序是一致的
        for(int i=0;i<list.size();i++){
            Log.i(TAG, list.get(i)+"="+map.get(list.get(i)));
             if(i!=list.size()-1){
                params+=list.get(i)+"="+map.get(list.get(i))+"&";
            }
            else{
                params+=list.get(i)+"="+map.get(list.get(i));
            }
        }
        Log.i(TAG, params);
       String sign = EncryptUtil.md5(params).toUpperCase();
        Log.i(TAG, "sign:"+sign);
            return sign;
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }

    }
}
