package com.exc.myapplication.ui.mine;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.exc.myapplication.MainActivity;
import com.exc.myapplication.R;
import com.exc.myapplication.base.BaseActivity;
import com.exc.myapplication.databinding.ActivityCurrencyBinding;
import com.exc.myapplication.utils.DataCleanManager;
import com.exc.myapplication.utils.XToastUtils;
import com.xuexiang.xui.widget.dialog.DialogLoader;

public class CurrencyActivity extends BaseActivity implements View.OnClickListener {

    private ActivityCurrencyBinding binding;
    private AlertDialog.Builder builder;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityCurrencyBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

       initView();
    }

    public void initView(){
        binding.headviewBackImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        binding.tvData.setText(getCacheSize());
        binding.baseview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                DialogLoader.getInstance().showConfirmDialog(
                        getActivity(),
                        getString(R.string.del_stratety_permission),
                        getString(R.string.tip_yes),
                        (dialog, which) -> {
                            dialog.dismiss();
                            DataCleanManager.clearAllCache(getActivity());
                            XToastUtils.toast("清除成功");
                        },
                        getString(R.string.tip_no),
                        (dialog, which) -> {
                            dialog.dismiss();
                        }
                );
            }
        });
    }

    //获取缓存大小
    private String getCacheSize(){
        String str = "";
        try {
            str =  DataCleanManager.getTotalCacheSize(getActivity());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return str ;
    }

    @Override
    public void onClick(View v) {

    }
}
