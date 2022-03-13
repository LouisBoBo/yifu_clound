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
import com.yssj.myapplication.bean.MD5Tools;
import com.yssj.myapplication.databinding.ActivityChangePasswordBinding;
import com.yssj.myapplication.eventbus.EventEnum;
import com.yssj.myapplication.eventbus.EventMessage;
import com.yssj.myapplication.http.BeanResponseListener;
import com.yssj.myapplication.http.HttpApi;
import com.yssj.myapplication.http.HttpRequest;
import com.yssj.myapplication.utils.TokenUtils;
import com.yssj.myapplication.utils.XToastUtils;

import org.greenrobot.eventbus.EventBus;

public class ChangePasswordActivity extends BaseActivity implements View.OnClickListener {

    ActivityChangePasswordBinding binding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityChangePasswordBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        initView();
    }

    public void initView(){
        binding.headviewBackImg.setOnClickListener(this::onClick);
        binding.btnSubmit.setOnClickListener(this::onClick);
    }
    @Override
    public void onClick(View view) {
        if(view == binding.headviewBackImg){
            finish();
        }else if(view == binding.btnSubmit){
            if(binding.etOldPass.getText().length()==0){
                XToastUtils.toast("请输入旧密码");
                return;
            }
            else if(binding.etNewPass.getText().length()==0){
                XToastUtils.toast("请输入新密码");
                return;
            }
            else if(binding.etConfirmNewPass.getText().length() ==0){
                XToastUtils.toast("请输入新的确认密码");
                return;
            }else if(!binding.etNewPass.getText().toString().equals(binding.etConfirmNewPass.getText().toString())){
                XToastUtils.toast("请确认两次密码输入一样");
            }

            changepwdHttp();
        }
    }

    public void changepwdHttp(){
        mMessageLoader.show();
        Parameter parameter = new Parameter();

        parameter.put("version","V1.32");
        parameter.put("newPwd", MD5Tools.MD5(binding.etNewPass.getText().toString()));
        parameter.put("pwd",MD5Tools.MD5(binding.etOldPass.getText().toString()));

        HttpRequest.POST(getActivity(), HttpApi.USER_UPDATEPWD, parameter, new BeanResponseListener<BaseBean>() {

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
