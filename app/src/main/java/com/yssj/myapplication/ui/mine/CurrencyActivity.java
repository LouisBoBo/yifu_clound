package com.yssj.myapplication.ui.mine;

import android.app.AlertDialog;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;

import com.yssj.myapplication.R;
import com.yssj.myapplication.base.BaseActivity;
import com.yssj.myapplication.databinding.ActivityCurrencyBinding;
import com.yssj.myapplication.utils.DataCleanManager;
import com.yssj.myapplication.utils.XToastUtils;
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
                            binding.tvData.setText("0");
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
