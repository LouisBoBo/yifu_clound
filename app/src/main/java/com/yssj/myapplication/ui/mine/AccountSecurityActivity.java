package com.yssj.myapplication.ui.mine;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;

import com.kongzue.baseokhttp.util.Parameter;
import com.yssj.myapplication.R;
import com.yssj.myapplication.base.BaseActivity;
import com.yssj.myapplication.bean.PhoneBean;
import com.yssj.myapplication.databinding.ActivityAccountSecurityBinding;
import com.yssj.myapplication.databinding.ActivityBindingPhoneBinding;
import com.yssj.myapplication.databinding.ActivitySettingBinding;
import com.yssj.myapplication.http.BeanResponseListener;
import com.yssj.myapplication.http.HttpApi;
import com.yssj.myapplication.http.HttpRequest;

public class AccountSecurityActivity extends BaseActivity implements View.OnClickListener{

    private ActivityAccountSecurityBinding binding;
    private String phone;
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

        binding.viewLoginPwd.imageTitle.setImageResource(R.mipmap.chenggong_icon);
        binding.viewBingPhone.imageTitle.setImageResource(R.mipmap.jinggao_icon);

        binding.viewLoginPwd.getRoot().setOnClickListener(this::onClick);
        binding.viewBingPhone.getRoot().setOnClickListener(this::onClick);
        binding.headviewBackImg.setOnClickListener(this::onClick);

        feedbackHttp();
    }

    @Override
    public void onClick(View view) {
        if(view == binding.viewLoginPwd.getRoot()){
            startActivity(ChangePasswordActivity.class);
        }else if(view == binding.viewBingPhone.getRoot()){
            if(phone!=null)
            {
                startActivity(BindingPhoneActivity.class);
            }else {
                startActivity(DoBindingPhoneActivity.class);
            }
        }else if(view == binding.headviewBackImg){
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
                    phone = basebean.getPhone();
                    binding.viewBingPhone.imageTitle.setImageResource(phone!=null?R.mipmap.chenggong_icon:R.mipmap.jinggao_icon);
                }
            }

        });

    }
}
