package com.exc.myapplication.activity;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import com.exc.myapplication.HomePageActivity;
import com.exc.myapplication.R;
import com.exc.myapplication.base.BaseActivity;
import com.exc.myapplication.utils.SSLAgent;

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
