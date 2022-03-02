package com.kongzue.baseokhttp.exceptions;


public class DecodeJsonException extends Exception {
    public DecodeJsonException(String errorInfo){
        super("Json解析失败：\n" + errorInfo);
    }
}
