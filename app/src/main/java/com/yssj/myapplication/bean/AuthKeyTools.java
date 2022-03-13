package com.yssj.myapplication.bean;

import android.text.TextUtils;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

public class AuthKeyTools {

	/**
	 * 生成加密串URL
	 * @param url
	 * @param key
	 * @return
	 * @throws Exception
	 */
	public static String builderURL(String url, String key) throws Exception {
		if(url == null || TextUtils.isEmpty(url)){
			throw new RuntimeException("parameter url con't be null.");
		}
		if(key == null || TextUtils.isEmpty(url)){
			throw new RuntimeException("parameter key con't be null.");
		}
		//转码加密�?
		String authKey = AuthKeyTools.MD5(url, key);
		String m = "&";
		if(url.indexOf("?") < 0){
			 m = "?";
		}
		
		return authKey ;
	}
	
	/**
	 * 生成加密�?
	 * @param url
	 * @param key
	 * @return
	 */
	public static String MD5(String url, String key){
		try {
			//URL进行处理
			url = URLDecoder.decode(url,"UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return  MD5Tools.MD5(url+key);
	}
	
	public static void main(String[] args) throws Exception {
		//http://192.168.40.122:8080/lvchang-cta/adminUser/getAdminUser?version=V1.0&authKey=
		String URL = "http://127.0.0.1:8080/lvchang-cta/companyInfo/queryCompanyInfoByCode?version=V1.0&dept_code=1000&token=EVJBYYUKMS7GGOVOKAPU";
		String AppKey = "lvchangmade";
		String toUrl = AuthKeyTools.builderURL(URL,AppKey);
//		System.out.println(toUrl);
//		System.out.println(MD5Tools.MD5("123456"));
		
		
//		System.out.println(MethodUtil.MD5("123456"));
		
	}
	
	
}
