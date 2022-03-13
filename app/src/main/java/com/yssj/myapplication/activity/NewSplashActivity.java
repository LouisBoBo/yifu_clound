package com.yssj.myapplication.activity;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;

import com.yssj.myapplication.HomePageActivity;
import com.yssj.myapplication.R;
import com.yssj.myapplication.base.BaseActivity;
import com.yssj.myapplication.utils.SSLAgent;

import java.util.Timer;
import java.util.TimerTask;

public class NewSplashActivity extends BaseActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                SSLAgent.getInstance().trustAllHttpsCertificates();
                loginOrGoMainPage();
            }
        }, 2000);
    }

    private void loginOrGoMainPage() {
        startActivity(new Intent(NewSplashActivity.this, HomePageActivity.class));
        finish();
    }
}
