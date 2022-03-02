package com.kongzue.baseokhttp.listener;

import baseokhttp3.MultipartBody;

/**
 * @github: https://github.com/kongzue/
 * @homepage: http://kongzue.com/
 * @mail: myzcxhh@live.cn
 */
public interface MultipartBuilderInterceptor {
    
    MultipartBody.Builder interceptMultipartBuilder(MultipartBody.Builder multipartBuilder);
}
