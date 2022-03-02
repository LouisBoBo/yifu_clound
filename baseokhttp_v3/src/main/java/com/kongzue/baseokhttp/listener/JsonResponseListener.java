package com.kongzue.baseokhttp.listener;

import android.content.Context;

import com.kongzue.baseokhttp.exceptions.DecodeJsonException;
import com.kongzue.baseokhttp.util.JsonMap;


public abstract class JsonResponseListener implements BaseResponseListener {
    
    @Override
    public void response(Context context,Object response, Exception error) {
        if (error == null) {
            JsonMap data = new JsonMap(response.toString());
            if (data!=null && !data.isEmpty()) {
                onResponse(data, error);
            } else {
                onResponse(new JsonMap(), new DecodeJsonException(response.toString()));
            }
        } else {
            onResponse(new JsonMap(), error);
        }
    }
    
    public abstract void onResponse(JsonMap main, Exception error);
}
