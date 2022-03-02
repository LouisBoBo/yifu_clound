package com.kongzue.baseokhttp.listener;

import android.content.Context;

import com.kongzue.baseokhttp.util.Parameter;

/**
 * @github: https://github.com/kongzue/
 * @homepage: http://kongzue.com/
 * @mail: myzcxhh@live.cn
 */
public interface HeaderInterceptListener {
    
    Parameter onIntercept(Context context, String url, Parameter header);
    
}
