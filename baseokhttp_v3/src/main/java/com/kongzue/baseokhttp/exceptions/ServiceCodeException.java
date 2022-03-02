package com.kongzue.baseokhttp.exceptions;


public class ServiceCodeException extends Exception {
    public ServiceCodeException(String errorInfo){
        super("服务端返回码异常：\n" + errorInfo);
    }
}
