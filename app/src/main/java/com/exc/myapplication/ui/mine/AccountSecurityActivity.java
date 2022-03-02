package com.exc.myapplication.ui.mine;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;

import com.exc.myapplication.R;
import com.exc.myapplication.base.BaseActivity;
import com.exc.myapplication.databinding.ActivityAccountSecurityBinding;
import com.exc.myapplication.databinding.ActivityBindingPhoneBinding;
import com.exc.myapplication.databinding.ActivitySettingBinding;

public class AccountSecurityActivity extends BaseActivity implements View.OnClickListener{

    private ActivityAccountSecurityBinding binding;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAccountSecurityBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        initView();
    }

    public void initView(){
        binding.viewLoginPwd.contentText.setText("登录密码");
        binding.viewBingPhone.contentText.setText("绑定手机");

        binding.viewLoginPwd.imageTitle.setImageResource(R.mipmap.un_setting);
        binding.viewBingPhone.imageTitle.setImageResource(R.mipmap.un_setting);

        binding.viewLoginPwd.getRoot().setOnClickListener(this::onClick);
        binding.viewBingPhone.getRoot().setOnClickListener(this::onClick);
        binding.headviewBackImg.setOnClickListener(this::onClick);
    }

    @Override
    public void onClick(View view) {
        if(view == binding.viewLoginPwd.getRoot()){
            startActivity(ChangePasswordActivity.class);
        }else if(view == binding.viewBingPhone.getRoot()){
            startActivity(BindingPhoneActivity.class);
        }else if(view == binding.headviewBackImg){
            finish();
        }
    }
}
