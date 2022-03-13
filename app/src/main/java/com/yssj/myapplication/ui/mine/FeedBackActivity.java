package com.yssj.myapplication.ui.mine;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;

import com.kongzue.baseokhttp.util.Parameter;
import com.yssj.myapplication.Loginactivity;
import com.yssj.myapplication.base.BaseActivity;
import com.yssj.myapplication.bean.BaseBean;
import com.yssj.myapplication.bean.Constant;
import com.yssj.myapplication.bean.LoginInfoBean;
import com.yssj.myapplication.databinding.ActivityFeedBackBinding;
import com.yssj.myapplication.eventbus.EventEnum;
import com.yssj.myapplication.eventbus.EventMessage;
import com.yssj.myapplication.http.BeanResponseListener;
import com.yssj.myapplication.http.HttpApi;
import com.yssj.myapplication.http.HttpRequest;
import com.yssj.myapplication.utils.TokenUtils;
import com.yssj.myapplication.utils.XToastUtils;

import org.greenrobot.eventbus.EventBus;

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
        binding.btnSubmit.setOnClickListener(this::onClick);
    }
    @Override
    public void onClick(View view) {
        if (view == binding.headviewBackImg) {
            finish();
        }else if(view == binding.btnSubmit){
            if(binding.commentEdit.getText().length()==0){
                XToastUtils.toast("请填写反馈内容");
                return;
            }
            feedbackHttp();
        }
    }

    public void feedbackHttp(){
        mMessageLoader.show();
        Parameter parameter = new Parameter();

        SharedPreferences sp = getActivity().getSharedPreferences("logindata", MODE_PRIVATE);
        int userid = sp.getInt(Constant.USER_ID,0);

        parameter.put("version","V1.32");
        parameter.put("version_no","3.8.5");
        parameter.put("userid",userid);
        parameter.put("content",binding.commentEdit.getText());


        HttpRequest.POST(getActivity(), HttpApi.USER_ADDUSERFEEDBACKINFO, parameter, new BeanResponseListener<BaseBean>() {

            @Override
            public void onResponse(BaseBean lampDeviceListBean, Exception error) {
                mMessageLoader.dismiss();
                if(error == null){
                    XToastUtils.toast("操作成功");
                    finish();
                }
            }

        });

    }
}
