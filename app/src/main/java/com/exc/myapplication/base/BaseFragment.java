package com.exc.myapplication.base;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;

import com.exc.myapplication.R;
import com.xuexiang.xui.widget.dialog.LoadingDialog;

public class BaseFragment extends Fragment {

    private LoadingDialog mLodingDialog;

    /**
     * [页面跳转]
     *
     * @param clz
     */
    public void startActivity(Class<?> clz) {
        startActivity(clz, null);
        getActivity().overridePendingTransition(R.anim.slide_left_in, R.anim.slide_left_out);
    }

    /**
     * [携带数据的页面跳转]
     *
     * @param clz
     * @param bundle
     */
    public void startActivity(Class<?> clz, Bundle bundle) {
        Intent intent = new Intent();
        intent.setClass(getActivity(), clz);
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        startActivity(intent);
        getActivity().overridePendingTransition(R.anim.slide_left_in, R.anim.slide_left_out);
    }

    /**
     * [含有Bundle通过Class打开编辑界面]
     *
     * @param cls
     * @param bundle
     * @param requestCode
     */
    public void startActivityForResult(Class<?> cls, Bundle bundle, int requestCode) {
        Intent intent = new Intent();
        intent.setClass(getActivity(), cls);
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        startActivityForResult(intent, requestCode);
        getActivity().overridePendingTransition(R.anim.slide_left_in, R.anim.slide_left_out);
    }


    /**
     * 加载动画
     */
    public void showLoading() {
        showLoadingDialog();
    }

    public void hideLoading() {
        closeLoadingDialog();
    }
    public void closeLoadingDialog() {
        if (mLodingDialog != null && mLodingDialog.isShowing()) {
            mLodingDialog.dismiss();
        }
    }

    /**
     * 加载...
     */
    public void showLoadingDialog() {
        if (mLodingDialog == null) {
            mLodingDialog = new LoadingDialog(getActivity());
        }
        mLodingDialog.show();
    }

}
