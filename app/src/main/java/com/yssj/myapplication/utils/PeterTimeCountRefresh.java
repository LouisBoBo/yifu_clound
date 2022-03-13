package com.yssj.myapplication.utils;

import android.graphics.Color;
import android.os.CountDownTimer;
import android.widget.TextView;

import java.text.DecimalFormat;

public class PeterTimeCountRefresh extends CountDownTimer {
    private TextView button;
    private long millisUntilFinished;

    public PeterTimeCountRefresh(long millisInFuture, long countDownInterval, final TextView button) {
        super(millisInFuture, countDownInterval);//参数依次为总时长,和计时的时间间隔,要显示的按钮
        this.button = button;
    }

    @Override
    public void onTick(long millisUntilFinished) {//计时过程显示
        this.millisUntilFinished = millisUntilFinished;
        button.setTextColor(Color.parseColor("#FFFFFF"));
        //button.setBackgroundResource(R.drawable.send_code_wait);
        button.setClickable(false);
        button.setTextSize((float) 14);
        DecimalFormat dec = new DecimalFormat("##.##");
        button.setText((int) Math.floor(millisUntilFinished / 1000) + "s");
    }

    @Override
    public void onFinish() {//计时完毕时触发
        button.setText("重新获取");
        button.setTextColor(Color.parseColor("#FFFFFF"));
        // button.setBackgroundResource(R.drawable.send_code);
        button.setClickable(true);
    }
}
