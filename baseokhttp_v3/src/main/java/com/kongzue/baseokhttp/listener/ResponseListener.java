package com.kongzue.baseokhttp.listener;

import android.content.Context;

import com.kongzue.baseokhttp.util.JsonMap;


public abstract class ResponseListener implements BaseResponseListener {
    
    @Override
    public void response(Context context,Object response, Exception error) {
        onResponse(response == null ? "" : response.toString(), error);
    }
    
    public abstract void onResponse(String main, Exception error);
}
