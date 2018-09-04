package com.ydky.vuandroidadsdk.okhttp.response;

import android.os.Handler;
import android.os.Looper;

import com.ydky.vuandroidadsdk.adutil.ResponseEntityToModule;
import com.ydky.vuandroidadsdk.okhttp.exception.OkHttpException;
import com.ydky.vuandroidadsdk.okhttp.listener.DisposeDataHandle;
import com.ydky.vuandroidadsdk.okhttp.listener.DisposeDataListener;

import org.json.JSONObject;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

/**
 * 处理json的回调响应
 */
public class CommonJsonCallback implements Callback {

    protected final String RESULT_CODE = "ecode"; // 有返回则对于http请求来说是成功的，但还有可能是业务逻辑上的错误
    protected final int RESULT_CODE_VALUE = 0;
    protected final String ERROR_MSG = "emsg";
    protected final String EMPTY_MSG = "";
    protected final String COOKIE_STORE = "Set-Cookie"; // decide the server it
    // can has the value of
    // set-cookie2

    /**
     * 自定义异常类型
     */
    protected final int NETWORK_ERROR = -1; // the network relative error
    protected final int JSON_ERROR = -2; // the JSON relative error
    protected final int OTHER_ERROR = -3; // the unknow error

    /**
     * 将其它线程的数据转发到UI线程
     */
    private Handler mDeliveryHandler;
    private DisposeDataListener mListener;
    private Class<?> mClass;

    public CommonJsonCallback(DisposeDataHandle handle) {
        this.mListener = handle.mListener;
        this.mClass = handle.mClass;
        this.mDeliveryHandler = new Handler(Looper.getMainLooper());
    }

    //请求失败处理
    @Override
    public void onFailure(Call call, final IOException e) {
        mDeliveryHandler.post(new Runnable() {
            @Override
            public void run() {
                mListener.onFailure(new OkHttpException(NETWORK_ERROR,e));
            }
        });
    }

    //真正的响应处理
    @Override
    public void onResponse(Call call, Response response) throws IOException {
        final String result = response.body().string();
        mDeliveryHandler.post(new Runnable() {
            @Override
            public void run() {
                handleResponse(result);
            }
        });
    }

    /**
     * 处理服务器返回的响应数据
     * @param resopnseObj
     */
    private void handleResponse(Object resopnseObj) {
        if(resopnseObj == null && resopnseObj.toString().trim().equals("")){
            mListener.onFailure(new OkHttpException(NETWORK_ERROR,EMPTY_MSG));
            return;
        }
        try{
            JSONObject result = new JSONObject(resopnseObj.toString());
            if(result.has(RESULT_CODE)){
                //从Json中取出响应码，若为0
                if(result.getInt(RESULT_CODE)==RESULT_CODE_VALUE){
                    if(mClass==null){
                        mListener.onSuccess(resopnseObj);
                    }else{
                        //需要将json转化为实体
                        Object object = ResponseEntityToModule.parseJsonObjectToModule(
                                result,mClass);
                        //表明正确的转为了实体对象
                        if(object!=null){
                            mListener.onSuccess(object);
                        }else{
                            //返回的不是合法json
                            mListener.onFailure(new OkHttpException(JSON_ERROR,EMPTY_MSG));
                        }
                    }
                }
            }else{
                mListener.onFailure(new OkHttpException(OTHER_ERROR,result.get(RESULT_CODE)));
            }
        }catch(Exception ex){
            mListener.onFailure(new OkHttpException(OTHER_ERROR, ex.getMessage()));
        }
    }
}
