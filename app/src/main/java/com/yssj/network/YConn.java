package com.yssj.network;

public class YConn {
    static {
        System.loadLibrary("Base64zzq");
    }

    public static native String Base64Encode(String cs); // 第三方库函数


    public static String test(String str){
        String ss = Base64Encode(str.toString());
        return ss;
    }
}
