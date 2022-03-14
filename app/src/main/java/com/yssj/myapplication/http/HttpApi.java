package com.yssj.myapplication.http;

public class HttpApi {
    //公共
//    public static  String SERVICES_ADDRESS ;
//    public static  String SERVICES_ADDRESS_LAMP_POLE;
//    public static  String SERVICES_ADDRESS_DEVICE_CONTROL;
//    public static  String SERVICES_ADDRESS_DEVICE_POWER_CABINET ;

    //生产环境 15988881001 Exc123456789
    public static  String SERVICES_ADDRESS = "http://42.194.210.113";
    public static  String SERVICES_ADDRESS_LAMP_POLE = "http://42.194.208.18";
    public static  String SERVICES_ADDRESS_DEVICE_CONTROL = "http://106.55.15.212";
    public static  String SERVICES_ADDRESS_DEVICE_POWER_CABINET = "http://42.194.208.18";

    public static String YSS_URL_ANDROID = "http://123.58.33.33/cloud-api/";
    public static String YSS_IMGURL = "http://img.yiline.com/";

    //测试环境 15988888888 Exc741852963
//    public static String SERVICES_ADDRESS = "http://192.168.18.202";
//    public static String SERVICES_ADDRESS_LAMP_POLE = "http://192.168.18.201";
//    public static String SERVICES_ADDRESS_DEVICE_CONTROL = "http://192.168.18.201";
//    public static String SERVICES_ADDRESS_DEVICE_POWER_CABINET = "http://192.168.18.201";


    /**
     * dlm：60027
     * sl：60020
     * ua：60029
     * woa：60028
     */
    public static final String SERVICES_PORT = ":60029";
    public static final String LAMP_LOCATION_PORT = ":60027";
    public static final String ORDER_PORT = ":60028/";
    public static final String DEVICE_CONTROL_PORT = ":60020";
    public static final String LOGIN_PORT = ":62126";


    /***
     * 登陆接口
     */
    public static String ACCOUNT_LOGIN = YSS_URL_ANDROID + "user/login";

    /**
     * 退出登录
     */
    public static String ACCOUNT_LOGINOUT = YSS_URL_ANDROID + "user/loginout";

    /**
     * 意见反馈
     */
    public static String USER_ADDUSERFEEDBACKINFO = YSS_URL_ANDROID + "user/addUserFeedBackInfo";

    /**
     * 修改密码
     */
    public static String USER_UPDATEPWD = YSS_URL_ANDROID + "user/updatePwd";

    /**
     * 查询绑定的手机号吗
     */
    public static String USER_QUERYPHONE = YSS_URL_ANDROID + "user/queryPhone";

    /**
     * 图片验证码
     */
    public static String VCODE_GETVCODE = YSS_URL_ANDROID + "vcode/getVcode";

    /**
     * 获取短信验证码
     */
    public static String USER_GET_PHONE_CODE = YSS_URL_ANDROID + "user/get_phone_code";

    /**
     * 验证手机
     */
    public static String USER_CHECKPHONE = YSS_URL_ANDROID + "user/checkPhone";

    /****
     * 绑定手机-验证短信验证码
     */
    public static String CHECKCODE = YSS_URL_ANDROID + "user/checkCode";














    /**
     * 获取登录公钥
     */
    public static String LOGIN_GET_PUBLIC_KEY = SERVICES_ADDRESS + SERVICES_PORT + "/api/ua/user/public/key";
    /**
     * 登录
     */
    public static String LOGIN = SERVICES_ADDRESS + SERVICES_PORT + "/api/ua/user/login";

    public void setIP(String adress, String address_lamp_pole, String services_address_device_control, String services_address_device_power_cabinet) {
        SERVICES_ADDRESS = adress;
        SERVICES_ADDRESS_LAMP_POLE = address_lamp_pole;
        SERVICES_ADDRESS_DEVICE_CONTROL = services_address_device_control;
        SERVICES_ADDRESS_DEVICE_POWER_CABINET = services_address_device_power_cabinet;

        LOGIN_GET_PUBLIC_KEY = SERVICES_ADDRESS + SERVICES_PORT + "/api/ua/user/public/key";

        LOGIN = SERVICES_ADDRESS + SERVICES_PORT + "/api/ua/user/login";
    }
}
