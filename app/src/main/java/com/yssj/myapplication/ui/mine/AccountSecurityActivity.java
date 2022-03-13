package com.yssj.myapplication.ui.mine;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;

import com.yssj.myapplication.R;
import com.yssj.myapplication.base.BaseActivity;
import com.yssj.myapplication.databinding.ActivityAccountSecurityBinding;
import com.yssj.myapplication.databinding.ActivityBindingPhoneBinding;
import com.yssj.myapplication.databinding.ActivitySettingBinding;

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
//            startActivity(BindingPhoneActivity.class);
            startActivity(DoBindingPhoneActivity.class);
        }else if(view == binding.headviewBackImg){
            finish();
        }
    }
}
