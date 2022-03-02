package com.exc.myapplication;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.exc.myapplication.bean.Constant;
import com.exc.myapplication.utils.TokenUtils;
import com.exc.myapplication.utils.XToastUtils;

import java.util.HashMap;
import java.util.Map;

import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.PlatformActionListener;
import cn.sharesdk.framework.ShareSDK;
import cn.sharesdk.wechat.friends.Wechat;

public class Loginactivity extends AppCompatActivity {
    private Context mcontext;
    private TextView login_btn;
    private TextView right_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);//去掉标题栏

        getWindow().setFlags( WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_login);
        mcontext = this;

        login_btn = findViewById(R.id.login_wx_btn);
        login_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//                getWeiXin();

                //存入数据
                SharedPreferences sp = mcontext.getSharedPreferences("logindata", MODE_PRIVATE);

                SharedPreferences.Editor editor = sp.edit();
                editor.putString(Constant.USER_TOKEN, "QWRQRQRWEREWRQRQRQRRQRQ");
                editor.commit();

                onLoginSuccess("QWRQRQRWEREWRQRQRQRRQRQ");
                XToastUtils.toast("登录成功！");

            }
        });

        right_btn = findViewById(R.id.head_right);
        right_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    /**
     * 登录成功的处理
     */
    private void onLoginSuccess(String token) {
        if (TokenUtils.handleLoginSuccess(token)) {
            Intent i = getIntent();
            Bundle b = i.getExtras();
            String isfirstlogin = b.getString("isfirstlogin");

            //判断是否是从homepage跳转过来
            if (isfirstlogin !=null && isfirstlogin.equals("1")) {
                startActivity(new Intent(Loginactivity.this, MainActivity.class));
                finish();
            }else {
                finish();
            }
        }
    }

    /*
     * 第三方微信登录
     * */
    public void getWeiXin(){

        Platform plat = ShareSDK.getPlatform(Wechat.NAME);
        plat.removeAccount(true); //移除授权状态和本地缓存，下次授权会重新授权
        plat.SSOSetting(false); //SSO授权，传false默认是客户端授权，没有客户端授权或者不支持客户端授权会跳web授权
        plat.setPlatformActionListener(new PlatformActionListener() {//授权回调监听，监听oncomplete，onerror，oncancel三种状态
            @Override
            public void onComplete(Platform platform, int i, HashMap<String, Object> hashMap) {
                if(i == Platform.ACTION_AUTHORIZING)//要功能不要数据
                {
                    //直接跳转到登陆成功的界面
                    Log.e("info","登陆成功");
                }
                else if(i == Platform.ACTION_USER_INFOR)//要数据不要功能
                {
                    for (Map.Entry<String, Object> entry : hashMap.entrySet()) {
                        Log.e("info","key:"+entry.getKey()+"\tvalue:"+entry.getValue());
                    }
                }
            }

            @Override
            public void onError(Platform platform, int i, Throwable throwable) {
                Log.e("info","登陆失败");            }

            @Override
            public void onCancel(Platform platform, int i) {
                Log.e("info","登陆失败");            }
        });
        if (plat.isClientValid()) {
            //todo 判断是否存在授权凭条的客户端，true是有客户端，false是无
        }
        if (plat.isAuthValid()) {
            //todo 判断是否已经存在授权状态，可以根据自己的登录逻辑设置
            Toast.makeText(this, "已经授权过了", Toast.LENGTH_SHORT).show();
            return;
        }
        //plat.authorize();    //要功能，不要数据
        plat.showUser(null);    //要数据不要功能，主要体现在不会重复出现授权界面
    }
}
