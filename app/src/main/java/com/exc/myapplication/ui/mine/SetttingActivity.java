package com.exc.myapplication.ui.mine;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;

import com.exc.myapplication.Loginactivity;
import com.exc.myapplication.MainActivity;
import com.exc.myapplication.R;
import com.exc.myapplication.base.BaseActivity;
import com.exc.myapplication.databinding.ActivityCangraborderDatailBinding;
import com.exc.myapplication.databinding.ActivitySettingBinding;
import com.exc.myapplication.eventbus.EventEnum;
import com.exc.myapplication.eventbus.EventMessage;
import com.exc.myapplication.ui.cangraborder.Dialog.CangraborderDialog;
import com.exc.myapplication.utils.TokenUtils;
import com.exc.myapplication.utils.XToastUtils;

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
            XToastUtils.toast("退出登录");

            Intent intent = new Intent(getActivity(), Loginactivity.class);
            Bundle bundle = new Bundle();
            bundle.putString("isfirstlogin", "0");
            intent.putExtras(bundle);
            startActivity(intent);
        }
    }
}
