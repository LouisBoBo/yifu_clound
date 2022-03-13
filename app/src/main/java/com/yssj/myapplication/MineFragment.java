package com.yssj.myapplication;

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

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.yssj.myapplication.bean.Constant;
import com.yssj.myapplication.eventbus.EventEnum;
import com.yssj.myapplication.eventbus.EventMessage;
import com.yssj.myapplication.http.HttpApi;
import com.yssj.myapplication.ui.mine.AccountBalanceActivity;
import com.yssj.myapplication.ui.mine.SetttingActivity;
import com.yssj.myapplication.ui.mine.UserInfoActivity;
import com.yssj.myapplication.utils.XToastUtils;

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
    private ImageView head_img;
    private TextView head_title;
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
        head_img = view.findViewById(R.id.head_img);
        head_title = view.findViewById(R.id.head_title);

        view_head.setOnClickListener(this::onClick);
        view_yue.setOnClickListener(this::onClick);
        view_dengji.setOnClickListener(this::onClick);
        view_message.setOnClickListener(this::onClick);
        view_setting.setOnClickListener(this::onClick);

        initview();

        return view;
    }

    public void initview(){

        SharedPreferences sp = getActivity().getSharedPreferences("logindata", MODE_PRIVATE);
        String nick_name= sp.getString(Constant.NICK_NAME,"");
        String user_pic = sp.getString(Constant.USET_PIC,"");

        head_title.setText(nick_name);

        RequestOptions options = new RequestOptions().error(R.drawable.bg_base_cycle).bitmapTransform(new RoundedCorners(100));//图片圆角为30
        Glide.with(getActivity()).load("https://img0.baidu.com/it/u=202312204,2771333250&fm=253&fmt=auto&app=138&f=JPEG?w=658&h=439") //图片地址
                .apply(options)
                .into(head_img);



//        Glide.with(getActivity()).load("https://img0.baidu.com/it/u=202312204,2771333250&fm=253&fmt=auto&app=138&f=JPEG?w=658&h=439").into(head_img);


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
