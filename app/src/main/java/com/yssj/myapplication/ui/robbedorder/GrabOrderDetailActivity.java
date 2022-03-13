package com.yssj.myapplication.ui.robbedorder;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;

import com.yssj.myapplication.Loginactivity;
import com.yssj.myapplication.base.BaseActivity;
import com.yssj.myapplication.bean.Constant;
import com.yssj.myapplication.databinding.ActivityCangraborderDatailBinding;
import com.yssj.myapplication.databinding.ActivityGraborderDetailBinding;
import com.yssj.myapplication.ui.cangraborder.Dialog.CangraborderDialog;

public class GrabOrderDetailActivity extends BaseActivity implements View.OnClickListener {

    private ActivityGraborderDetailBinding binding;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityGraborderDetailBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        initView();
    }

    public void initView(){
        binding.confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences sp = getActivity().getSharedPreferences("logindata", MODE_PRIVATE);
                String token= sp.getString(Constant.USER_TOKEN,"");

                //没有登录去登录
                if(token.length() == 0){
                    Intent intent = new Intent(getActivity(), Loginactivity.class);
                    Bundle bundle = new Bundle();
                    bundle.putString("isfirstlogin", "0");
                    intent.putExtras(bundle);
                    startActivity(intent);
                    return;
                }else {
                    CangraborderDialog dialog = new CangraborderDialog(getActivity());
                    dialog.show();
                }
            }
        });
        binding.headviewBackImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
    @Override
    public void onClick(View v) {

    }
}
