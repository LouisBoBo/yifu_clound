package com.yssj.myapplication.ui.mine;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;

import com.yssj.myapplication.base.BaseActivity;
import com.yssj.myapplication.databinding.ActivityChangeNicknameBinding;
import com.yssj.myapplication.databinding.ActivityChangePasswordBinding;

public class ChangeNickNameActivity extends BaseActivity implements View.OnClickListener {
    ActivityChangeNicknameBinding binding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityChangeNicknameBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        initView();
    }

    public void initView(){
        binding.headviewBackImg.setOnClickListener(this::onClick);
    }
    @Override
    public void onClick(View view) {
        if(view == binding.headviewBackImg){
            finish();
        }
    }
}
