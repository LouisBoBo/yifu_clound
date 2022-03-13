package com.yssj.myapplication.ui.mine;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;

import com.kongzue.baseokhttp.util.Parameter;
import com.yssj.myapplication.base.BaseActivity;
import com.yssj.myapplication.bean.BaseBean;
import com.yssj.myapplication.bean.Constant;
import com.yssj.myapplication.bean.PhoneBean;
import com.yssj.myapplication.databinding.ActivityBindingPhoneBinding;
import com.yssj.myapplication.databinding.ActivityChangePasswordBinding;
import com.yssj.myapplication.http.BeanResponseListener;
import com.yssj.myapplication.http.HttpApi;
import com.yssj.myapplication.http.HttpRequest;
import com.yssj.myapplication.utils.XToastUtils;

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
        feedbackHttp();
    }
    @Override
    public void onClick(View view) {
        if(view == binding.headviewBackImg){
            finish();
        }
    }

    public void feedbackHttp(){
        mMessageLoader.show();
        Parameter parameter = new Parameter();
        parameter.put("version","V1.32");

        HttpRequest.POST(getActivity(), HttpApi.USER_QUERYPHONE, parameter, new BeanResponseListener<PhoneBean>() {

            @Override
            public void onResponse(PhoneBean basebean, Exception error) {
                mMessageLoader.dismiss();
                if(error == null){
                    binding.tvPhoneNum.setText(basebean.getPhone());
                }
            }

        });

    }
}
