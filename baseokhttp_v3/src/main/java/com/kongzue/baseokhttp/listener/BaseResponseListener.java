package com.kongzue.baseokhttp.listener;

import android.app.Activity;
import android.content.Context;


public interface BaseResponseListener {
    
    /**
     * 此方法用于内部传递未处理的返回值，请使用 ResponseListener 的具体实现
     * @hide
     * @param response
     * @param error
     */
    void response(Context context, Object response, Exception error);
}
