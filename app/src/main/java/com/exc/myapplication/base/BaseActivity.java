package com.exc.myapplication.base;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.transition.Transition;
import android.transition.TransitionInflater;
import android.view.Window;
import android.view.WindowManager;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.exc.myapplication.R;
import com.xuexiang.xui.XUI;
import com.xuexiang.xui.utils.WidgetUtils;
import com.xuexiang.xui.widget.dialog.LoadingDialog;
import com.xuexiang.xui.widget.dialog.materialdialog.MaterialDialog;
import com.xuexiang.xui.widget.progress.loading.IMessageLoader;

public class BaseActivity extends AppCompatActivity {
    private LoadingDialog mLodingDialog;
    private MaterialDialog mDialog;
    /**
     * 消息加载框
     */
    public IMessageLoader mMessageLoader;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        XUI.initTheme(this);
        getMessageLoader("正在加载中");

        setStatusBarColor(getActivity(),R.color.black);

        // 设置activity的窗口属性为contentFeature,即可使用切换动画
        getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS);
    }

    //屏幕适配
    public boolean isBaseOnWidth() {
        return false;
    }

    public float getSizeInDp() {
        return 667;
    }

    //状态栏
    /**
     * 修改状态栏颜色，支持4.4以上版本
     * @param activity
     * @param colorId
     */
    public static void setStatusBarColor(Activity activity, int colorId) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = activity.getWindow();
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(activity.getResources().getColor(colorId));
        }
    }
    /**
     * [页面跳转]
     *
     * @param clz
     */
    public void startActivity(Class<?> clz) {
        startActivity(clz, null);
        overridePendingTransition(R.anim.slide_left_in, R.anim.slide_left_out);
    }


    /**
     * [携带数据的页面跳转]
     *
     * @param clz
     * @param bundle
     */
    public void startActivity(Class<?> clz, Bundle bundle) {
        Intent intent = new Intent();
        intent.setClass(this, clz);
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        startActivity(intent);
        overridePendingTransition(R.anim.slide_left_in, R.anim.slide_left_out);
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
        intent.setClass(this, cls);
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        startActivityForResult(intent, requestCode);
        overridePendingTransition(R.anim.slide_left_in, R.anim.slide_left_in);
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
            mLodingDialog = new LoadingDialog(this);
        }
        mLodingDialog.show();
    }

    //给子类提供一个获取activity对象的方式
    public Activity getActivity() {
        return this;
    }

    public IMessageLoader getMessageLoader() {
        if (mMessageLoader == null) {
            mMessageLoader = WidgetUtils.getMiniLoadingDialog(this);
            mMessageLoader.setCancelable(true);

        }
        return mMessageLoader;
    }

    public IMessageLoader getMessageLoader(String message) {
        if (mMessageLoader == null) {
            mMessageLoader = WidgetUtils.getMiniLoadingDialog(this, message);
            mMessageLoader.setCancelable(true);
        } else {
            mMessageLoader.updateMessage(message);
        }
        return mMessageLoader;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onBackPressed() {
        // TODO Auto-generated method stub
        super.onBackPressed();
        overridePendingTransition(R.anim.slide_match, R.anim.slide_left_out);
    }
}
