package com.yssj.myapplication.bean;

import android.text.TextUtils;

import java.security.MessageDigest;


public class MD5Tools {
	/**
	 * 初始�?
	 * @return
	 */
	public static MD5Tools getInit(){
		return new MD5Tools();
	}


	/**
	 *  MD5 加密   转成成大�?
	 * 
	 */
	public static String MD5(String origin) {
		String resultString = MD5Encode(origin,"UTF-8");
		if(resultString != null && !TextUtils.isEmpty(resultString)){
			return resultString.toUpperCase();
		}		
		return resultString;
	}
	
	
	/**
	 *  MD5 加密  
	 * 
	 */
	public static String md5(String origin) {
		String resultString = MD5Encode(origin,"UTF-8");
		return resultString;
	}
	
	/**
	 * MD5 比较 匹配origin 加密后是否等于md5
	 * @param origin 密码�? 未加�?
	 * @param md5 已加密字符串
	 * @return
	 */
	public static boolean ecompareMD5(String origin, String md5) {
		String result =MD5(origin);
		return md5.equals(result);
	}
	

	/**
	 * MD5加密
	 * @param str
	 * @param charsetname
	 * @return
	 */
	public static String MD5Encode(String str, String charsetname) {
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(str.getBytes(charsetname));
			byte[] byteDigest = md.digest();
			int i;
			StringBuffer buf = new StringBuffer("");
			for (int offset = 0; offset < byteDigest.length; offset++) {
				i = byteDigest[offset];
				if (i < 0)
					i += 256;
				if (i < 16)
					buf.append("0");
				buf.append(Integer.toHexString(i));
			}
			return buf.toString();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static void main(String[] args) {
		String md51 = md5("123");
		String md52 = MD5("123");
//		System.out.println(md51);
//		System.out.println(md52);
		
	}
	
	
}