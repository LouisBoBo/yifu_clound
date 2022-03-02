package com.exc.myapplication;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.exc.myapplication.bean.Constant;
import com.exc.myapplication.eventbus.EventEnum;
import com.exc.myapplication.eventbus.EventMessage;
import com.exc.myapplication.ui.mine.AccountBalanceActivity;
import com.exc.myapplication.ui.mine.SetttingActivity;
import com.exc.myapplication.ui.mine.UserInfoActivity;
import com.exc.myapplication.utils.XToastUtils;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import static android.content.Context.MODE_PRIVATE;

public class MineFragment extends Fragment implements View.OnClickListener{
    private String content;
    private View view_yue;
    private View view_dengji;
    private View view_message;
    private View view_setting;
    private View view_head;
    private Context mcontext;

    public MineFragment(String content) {
        this.content = content;
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEven(EventMessage eventMessage) {
        if (eventMessage.getEventEnum() == EventEnum.LOGIN_OUT_SUCCESS) {

            FragmentManager fManager = getActivity().getSupportFragmentManager();
            FragmentTransaction fTransaction = fManager.beginTransaction();
            fTransaction.hide(this);
            fTransaction.commit();
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fg_mine,container,false);

        EventBus.getDefault().register(this);

        view_head = view.findViewById(R.id.headview);
        view_yue = view.findViewById(R.id.view_yue);
        view_dengji = view.findViewById(R.id.view_dengji);
        view_message = view.findViewById(R.id.view_message);
        view_setting = view.findViewById(R.id.view_setting);

        view_head.setOnClickListener(this::onClick);
        view_yue.setOnClickListener(this::onClick);
        view_dengji.setOnClickListener(this::onClick);
        view_message.setOnClickListener(this::onClick);
        view_setting.setOnClickListener(this::onClick);

        initview();

        return view;
    }

    public void initview(){

        ImageView yue_img =  view_yue.findViewById(R.id.image_title);
        yue_img.setImageResource(R.mipmap.wallet_icon);
        TextView yue_title = view_yue.findViewById(R.id.content_text);
        yue_title.setText("帐户余额");

        ImageView dengji_img =  view_dengji.findViewById(R.id.image_title);
        dengji_img.setImageResource(R.mipmap.dengji_icon);
        TextView dengji_title = view_dengji.findViewById(R.id.content_text);
        dengji_title.setText("我的等级");

        ImageView message_img =  view_message.findViewById(R.id.image_title);
        message_img.setImageResource(R.mipmap.kefu_icon);
        TextView message_title = view_message.findViewById(R.id.content_text);
        message_title.setText("客服");

        ImageView setting_img =  view_setting.findViewById(R.id.image_title);
        setting_img.setImageResource(R.mipmap.setting_icon);
        TextView setting_title = view_setting.findViewById(R.id.content_text);
        setting_title.setText("设置");
    }

    @Override
    public void onClick(View view) {

        SharedPreferences sp = getActivity().getSharedPreferences("logindata", MODE_PRIVATE);
        String token= sp.getString(Constant.USER_TOKEN,"");

        if(token.length() == 0){
            Intent intent = new Intent(getActivity(), Loginactivity.class);
            Bundle bundle = new Bundle();
            bundle.putString("isfirstlogin", "0");
            intent.putExtras(bundle);
            startActivity(intent);
            getActivity().overridePendingTransition(R.anim.slide_left_in, R.anim.slide_left_out);
            return;
        }

        if(view == view_yue){
            Intent intent = new Intent(getActivity(),AccountBalanceActivity.class);
            startActivity(intent);
            getActivity().overridePendingTransition(R.anim.slide_left_in, R.anim.slide_left_out);
        }else if(view == view_dengji){
            XToastUtils.toast("一星师傅，请多多接单，加油哦");
        }else if(view == view_message){

        }else if(view == view_setting){
            Intent intent = new Intent(getActivity(),SetttingActivity.class);
            startActivity(intent);
            getActivity().overridePendingTransition(R.anim.slide_left_in, R.anim.slide_left_out);
        }else if(view == view_head){
            Intent intent = new Intent(getActivity(), UserInfoActivity.class);
            startActivity(intent);
            getActivity().overridePendingTransition(R.anim.slide_left_in, R.anim.slide_left_out);
        }
    }

}
