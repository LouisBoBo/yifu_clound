package com.yssj.myapplication;

import android.app.Application;

import com.yssj.myapplication.utils.TokenUtils;
import com.mob.MobSDK;

public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        MobSDK.init(this);
        TokenUtils.init(this);
    }
}
