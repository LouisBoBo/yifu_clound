package com.exc.myapplication.http.base;
import com.exc.myapplication.http.HttpRequest;

import baseokhttp3.OkHttpClient;

/**
 * @github: https://github.com/kongzue/
 * @homepage: http://kongzue.com/
 * @mail: myzcxhh@live.cn
 * @createTime: 2020/12/9 14:58
 */
public interface GlobalCustomOkHttpClient {
    
    OkHttpClient customBuilder(HttpRequest request, OkHttpClient builder);
}
