package com.exc.myapplication.http;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;

import com.alibaba.fastjson.JSON;
import com.exc.myapplication.Loginactivity;
import com.exc.myapplication.bean.BaseBean;
import com.exc.myapplication.bean.Constant;
import com.exc.myapplication.utils.PreferencesUtil;
import com.exc.myapplication.utils.XToastUtils;
import com.kongzue.baseokhttp.exceptions.DecodeJsonException;
import com.kongzue.baseokhttp.exceptions.NewInstanceBeanException;
import com.kongzue.baseokhttp.exceptions.ServiceCodeException;
import com.kongzue.baseokhttp.listener.BaseResponseListener;
import com.kongzue.baseokhttp.util.JsonMap;

import java.lang.reflect.ParameterizedType;

/**
 *  回调提前处理
 *
 */
public abstract class BeanResponseListener<T> implements BaseResponseListener {
    
    @Override
    public void response(Context context, Object response, Exception error) {
        T tInstance = null;
        Class<T> tClass;
        try {
            ParameterizedType pt = (ParameterizedType) this.getClass().getGenericSuperclass();
            tClass = (Class<T>) pt.getActualTypeArguments()[0];
            tInstance = tClass.newInstance();
        } catch (Exception e) {
            //这种情况下没办法实例化泛型对象
            onResponse(null, new NewInstanceBeanException("请检查该 Bean 是否为 public 且其构造方法为 public"));
            return;
        }
        if (error == null) {
            JsonMap data = new JsonMap(response.toString());
            if (data.isEmpty()) {
                onResponse(tInstance, new DecodeJsonException(response.toString()));
                return;
            }


            BaseBean baseBean  =  JSON.parseObject(response.toString(),  BaseBean.class);
            if(baseBean.getCode() == 401){//需要重新登录
                PreferencesUtil.putString(context, Constant.USER_TOKEN, "");
                context.startActivity(new Intent(context, Loginactivity.class));
                ((Activity)context).finish();
                return;
            }
            if(baseBean.getCode() != 200){
                onResponse(tInstance, new ServiceCodeException(baseBean.getMessage()));
                XToastUtils.error(baseBean.getMessage());
                return;
            }
            tInstance =  JSON.parseObject(response.toString(),  tClass);


//            tInstance = JsonBean.getBean(data, tClass);



            
            onResponse(tInstance, null);
        } else {
            onResponse(tInstance, error);
            XToastUtils.error(error.getMessage());
        }
    }
    
    public abstract void onResponse(T main, Exception error);
}