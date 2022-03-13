package com.yssj.myapplication.http.base;

import com.yssj.myapplication.http.HttpRequest;

import baseokhttp3.OkHttpClient;

/**
 * @github: https://github.com/kongzue/
 * @homepage: http://kongzue.com/
 * @mail: myzcxhh@live.cn
 */
public interface GlobalCustomOkHttpClientBuilder {
    
    OkHttpClient.Builder customBuilder(HttpRequest request, OkHttpClient.Builder builder);
}
