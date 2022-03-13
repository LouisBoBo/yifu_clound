package com.yssj.myapplication.ui.mine;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;

import com.yssj.myapplication.R;
import com.yssj.myapplication.base.BaseActivity;
import com.yssj.myapplication.databinding.ActivityAboutUsBinding;
import com.yssj.myapplication.utils.XToastUtils;

public class AboutUsActivity extends BaseActivity implements View.OnClickListener {
    private ActivityAboutUsBinding binding;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAboutUsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        initView();
    }

    public void initView(){
        binding.viewAboutUs.contentText.setText("关于我们");
        binding.viewCheckVersion.contentText.setText("检测新版");
        binding.viewFeedBack.contentText.setText("意见反馈");

        binding.viewAboutUs.imageTitle.setVisibility(View.GONE);
        binding.viewCheckVersion.imageTitle.setVisibility(View.GONE);
        binding.viewFeedBack.imageTitle.setVisibility(View.GONE);

        binding.viewAboutUs.getRoot().setOnClickListener(this::onClick);
        binding.viewCheckVersion.getRoot().setOnClickListener(this::onClick);
        binding.viewFeedBack.getRoot().setOnClickListener(this::onClick);
        binding.headviewBackImg.setOnClickListener(this::onClick);
    }

    @Override
    public void onClick(View view) {
        if (view == binding.viewAboutUs.getRoot()) {
            startActivity(AboutUsContentActivity.class);
            overridePendingTransition(R.anim.slide_left_in,R.anim.slide_right_out);
        } else if (view == binding.viewCheckVersion.getRoot()) {
            XToastUtils.toast("已经是最新版本了哦~");
        } else if (view == binding.viewFeedBack.getRoot()) {
            startActivity(FeedBackActivity.class);
        } else if (view == binding.headviewBackImg) {
            finish();
        }
    }
}
