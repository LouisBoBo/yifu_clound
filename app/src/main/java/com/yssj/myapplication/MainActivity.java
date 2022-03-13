package com.yssj.myapplication;

import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.yssj.myapplication.base.BaseActivity;
import com.yssj.myapplication.bean.Constant;
import com.yssj.myapplication.eventbus.EventEnum;
import com.yssj.myapplication.eventbus.EventMessage;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class MainActivity extends BaseActivity implements View.OnClickListener {

    //UI Object
    private TextView ms_topbar_title;
    private TextView ms_tab_home;
    private TextView ms_tab_category;
    private TextView ms_tab_discover;
    private TextView ms_tab_cart;
    private FrameLayout ms_content;

    //Fragment Object
    private MsFragment fg1;
    private WorkFragment fg2;
    private MineFragment fg3;
    private FragmentManager fManager;

    private Context mcontext;
    private FragmentTransaction fTransaction;

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEven(EventMessage eventMessage) {
        if (eventMessage.getEventEnum() == EventEnum.LOGIN_OUT_SUCCESS) {

        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EventBus.getDefault().register(this);

        requestWindowFeature(Window.FEATURE_NO_TITLE);

        overridePendingTransition(R.anim.slide_left_in,R.anim.slide_right_out);

        setContentView(R.layout.activity_main);

        fManager = getSupportFragmentManager();
        bindViews();

        mcontext = this;

        ms_tab_home.performClick();   //模拟一次点击，既进去后选择第一项
    }

    //UI组件初始化与事件绑定
    private void bindViews() {
        ms_topbar_title = (TextView) findViewById(R.id.ms_topbar_title);
        ms_tab_home = (TextView) findViewById(R.id.ms_tab_home);
        ms_tab_category = (TextView) findViewById(R.id.ms_tab_category);
        ms_tab_discover = (TextView) findViewById(R.id.ms_tab_discover);
        ms_content = (FrameLayout) findViewById(R.id.ms_content);

        ms_tab_home.setOnClickListener(this);
        ms_tab_category.setOnClickListener(this);
        ms_tab_discover.setOnClickListener(this);
    }

    //重置所有文本的选中状态
    private void setSelected(){
        ms_tab_home.setSelected(false);
        ms_tab_category.setSelected(false);
        ms_tab_discover.setSelected(false);
    }

    //隐藏所有 Fragment
    private void hideAllFragment(FragmentTransaction fragmentTransaction){
        if(fg1 != null) fragmentTransaction.hide(fg1);
        if(fg2 != null) fragmentTransaction.hide(fg2);
        if(fg3 != null) fragmentTransaction.hide(fg3);
    }

    @Override
    public void onClick(View v) {
        fTransaction = fManager.beginTransaction();
        hideAllFragment(fTransaction);
        switch (v.getId()){
            case R.id.ms_tab_home:
                setSelected();
                ms_tab_home.setSelected(true);
                ms_topbar_title.setText("可抢订单");
                if(fg1 == null){
                    fg1 = new MsFragment("第一个 Fragment");
                    fTransaction.add(R.id.ms_content,fg1);
                }else{
                    fTransaction.show(fg1);
                }
                break;
            case R.id.ms_tab_category:
                setSelected();
                ms_topbar_title.setText("已接订单");
                ms_tab_category.setSelected(true);
                if(fg2 == null){
                    fg2 = new WorkFragment("");
                    fTransaction.add(R.id.ms_content,fg2);
                }else{
                    fTransaction.show(fg2);
                }
                break;
            case R.id.ms_tab_discover:

                SharedPreferences sp = mcontext.getSharedPreferences("logindata", MODE_PRIVATE);
                String token= sp.getString(Constant.USER_TOKEN,"");

                if(token.length() >0){
                    setSelected();
                    ms_topbar_title.setText("我的");
                    ms_tab_discover.setSelected(true);
                    if(fg3 == null){
                        fg3 = new MineFragment("第三个 Fragment");
                        fTransaction.add(R.id.ms_content,fg3);
                    }else{
                        fTransaction.show(fg3);
                    }
                }else {
                    if(ms_tab_home.isSelected())
                    {
                        ms_tab_home.setSelected(true);
                        ms_topbar_title.setText("可抢订单");
                        if(fg1 == null){
                            fg1 = new MsFragment("第一个 Fragment");
                            fTransaction.add(R.id.ms_content,fg1);
                        }else{
                            fTransaction.show(fg1);
                        }
                    }else if (ms_tab_category.isSelected()){
                        ms_topbar_title.setText("已接订单");
                        ms_tab_category.setSelected(true);
                        if(fg2 == null){
                            fg2 = new WorkFragment("");
                            fTransaction.add(R.id.ms_content,fg2);
                        }else{
                            fTransaction.show(fg2);
                        }
                    }

                    startActivity(Loginactivity.class);
                }

                break;
        }

        fTransaction.commit();
    }

}