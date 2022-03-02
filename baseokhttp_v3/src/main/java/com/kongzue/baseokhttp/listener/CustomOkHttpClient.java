package com.kongzue.baseokhttp.listener;

import baseokhttp3.OkHttpClient;

/**
 * @github: https://github.com/kongzue/
 * @homepage: http://kongzue.com/
 * @mail: myzcxhh@live.cn
 * @createTime: 2020/12/9 14:46
 */
public interface CustomOkHttpClient {
    
    OkHttpClient customBuilder(OkHttpClient builder);
}
