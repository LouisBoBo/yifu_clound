package com.yssj.myapplication.ui.mine;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;

import com.yssj.myapplication.Loginactivity;
import com.yssj.myapplication.R;
import com.yssj.myapplication.base.BaseActivity;
import com.yssj.myapplication.bean.LoginInfoBean;
import com.yssj.myapplication.databinding.ActivityCangraborderDatailBinding;
import com.yssj.myapplication.databinding.ActivitySettingBinding;
import com.yssj.myapplication.eventbus.EventEnum;
import com.yssj.myapplication.eventbus.EventMessage;
import com.yssj.myapplication.http.BeanResponseListener;
import com.yssj.myapplication.http.HttpApi;
import com.yssj.myapplication.http.HttpRequest;
import com.yssj.myapplication.utils.TokenUtils;
import com.yssj.myapplication.utils.XToastUtils;
import com.kongzue.baseokhttp.util.Parameter;

import org.greenrobot.eventbus.EventBus;

public class SetttingActivity extends BaseActivity implements View.OnClickListener{
    private ActivitySettingBinding binding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySettingBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        initView();
    }

    public void initView(){
        binding.viewSecurity.contentText.setText("账号与安全");
        binding.viewCurrency.contentText.setText("通用");
        binding.viewAbout.contentText.setText("关于");
        binding.viewHelp.contentText.setText("帮助");

        binding.viewSecurity.imageTitle.setImageResource(R.mipmap.safe_num);
        binding.viewCurrency.imageTitle.setImageResource(R.mipmap.safe_num);
        binding.viewAbout.imageTitle.setImageResource(R.mipmap.safe_num);
        binding.viewHelp.imageTitle.setImageResource(R.mipmap.safe_num);

        binding.viewSecurity.getRoot().setOnClickListener(this::onClick);
        binding.viewCurrency.getRoot().setOnClickListener(this::onClick);
        binding.viewAbout.getRoot().setOnClickListener(this::onClick);
        binding.loginOut.setOnClickListener(this::onClick);

        binding.headviewBackImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    @Override
    public void onClick(View view) {
        if(view == binding.viewSecurity.getRoot()){
            startActivity(AccountSecurityActivity.class);
        }else if(view == binding.viewCurrency.getRoot()){
            startActivity(CurrencyActivity.class);
        }else if(view == binding.viewAbout.getRoot()){
            startActivity(AboutUsActivity.class);
        }else if(view == binding.loginOut){

            loginoutHttp();

        }
    }

    public void loginoutHttp(){
        mMessageLoader.show();
        Parameter parameter = new Parameter();

        parameter.put("version","V1.32");


        HttpRequest.POST(getActivity(), HttpApi.ACCOUNT_LOGINOUT, parameter, new BeanResponseListener<LoginInfoBean>() {

            @Override
            public void onResponse(LoginInfoBean lampDeviceListBean, Exception error) {
                mMessageLoader.dismiss();
                if(error == null){
                    XToastUtils.toast("请求成功");

                    //退出登录
                    SharedPreferences sp = getSharedPreferences("logindata", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sp.edit();
                    editor.clear();
                    editor.commit();

                    TokenUtils.clearToken();

                    EventMessage eventMessage = new EventMessage();
                    eventMessage.setEventEnum(EventEnum.LOGIN_OUT_SUCCESS);
                    EventBus.getDefault().post(eventMessage);

                    finish();

                    Intent intent = new Intent(getActivity(), Loginactivity.class);
                    Bundle bundle = new Bundle();
                    bundle.putString("isfirstlogin", "0");
                    intent.putExtras(bundle);
                    startActivity(intent);
                }
            }

        });

    }
}
