package com.exc.myapplication.ui.mine;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;

import com.exc.myapplication.base.BaseActivity;
import com.exc.myapplication.databinding.ActivityBindingPhoneBinding;
import com.exc.myapplication.databinding.ActivityChangePasswordBinding;

public class BindingPhoneActivity extends BaseActivity implements View.OnClickListener{

    ActivityBindingPhoneBinding binding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityBindingPhoneBinding.inflate(getLayoutInflater());
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
