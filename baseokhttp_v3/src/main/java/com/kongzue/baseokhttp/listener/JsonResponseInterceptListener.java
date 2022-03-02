package com.kongzue.baseokhttp.listener;

import android.content.Context;

import com.kongzue.baseokhttp.util.JsonMap;

/**
 * @github: https://github.com/kongzue/
 * @homepage: http://kongzue.com/
 * @mail: myzcxhh@live.cn
 */
public abstract class JsonResponseInterceptListener implements BaseResponseInterceptListener {
    
    @Override
    public boolean response(Context context, String url, String response, Exception error) {
        return onResponse(context, url, new JsonMap(response), error);
    }
    
    public abstract boolean onResponse(Context context, String url, JsonMap response, Exception error);
}
