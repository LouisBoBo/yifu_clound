package com.exc.myapplication.ui.mine;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;

import com.exc.myapplication.base.BaseActivity;
import com.exc.myapplication.databinding.ActivityChangePasswordBinding;
import com.exc.myapplication.databinding.ActivityUserinfoBinding;

public class UserInfoActivity extends BaseActivity implements View.OnClickListener {
    ActivityUserinfoBinding binding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityUserinfoBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        initView();
    }

    public void initView(){
        binding.headviewBackImg.setOnClickListener(this::onClick);
        binding.relUserImg.setOnClickListener(this::onClick);
        binding.relUserNickname.setOnClickListener(this::onClick);
    }
    @Override
    public void onClick(View view) {
        if(view == binding.headviewBackImg){
            finish();
        }else if(view == binding.relUserNickname){
            startActivity(ChangeNickNameActivity.class);
        }
    }
}
