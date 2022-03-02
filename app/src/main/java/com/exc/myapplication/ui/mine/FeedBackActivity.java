package com.exc.myapplication.ui.mine;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;

import com.exc.myapplication.base.BaseActivity;
import com.exc.myapplication.databinding.ActivityFeedBackBinding;

public class FeedBackActivity extends BaseActivity implements View.OnClickListener {
    ActivityFeedBackBinding binding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityFeedBackBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        initView();
    }

    public void initView(){
        binding.headviewBackImg.setOnClickListener(this::onClick);
    }
    @Override
    public void onClick(View view) {
        if (view == binding.headviewBackImg) {
            finish();
        }
    }
}