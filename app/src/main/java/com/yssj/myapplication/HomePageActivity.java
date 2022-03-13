package com.yssj.myapplication;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.Toast;

import com.yssj.myapplication.base.BaseActivity;
import com.yssj.myapplication.bean.BaseBean;
import com.yssj.myapplication.databinding.ActivityHomeBinding;
import com.yssj.myapplication.http.BeanResponseListener;
import com.yssj.myapplication.http.HttpApi;
import com.yssj.myapplication.http.HttpRequest;
import com.yssj.myapplication.utils.TokenUtils;
import com.yssj.myapplication.utils.XToastUtils;
import com.kongzue.baseokhttp.util.JsonMap;
import com.kongzue.baseokhttp.util.Parameter;
import com.mob.MobSDK;
import com.xuexiang.xui.XUI;

public class HomePageActivity extends BaseActivity {
    private Context mcontext;
    private TextView myorder_btn;
    private TextView mywork_btn;

    private ActivityHomeBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);//去掉标题栏

        mcontext = this;

        binding = ActivityHomeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        //初始化应用主题
        XUI.initTheme(this);

        //回传用户隐私授权结果
        MobSDK.submitPolicyGrantResult(true, null);

        getWindow().setFlags( WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        binding.myorder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "近期即将上线，敬请期待",
                        Toast.LENGTH_SHORT).show();

                mMessageLoader.show();
                JsonMap map = new JsonMap();
                Parameter parameter = new Parameter();

                HttpRequest.JSONPOST(getActivity(), HttpApi.LOGIN_GET_PUBLIC_KEY, map, new BeanResponseListener<BaseBean>() {
                    @Override
                    public void onResponse(BaseBean lampDeviceListBean, Exception error) {
                        mMessageLoader.dismiss();
                        if(error == null){
                            XToastUtils.toast("请求成功");
                        }
                    }
                });
            }
        });

        binding.mywork.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(TokenUtils.getToken() != null && TokenUtils.getToken().length()>0){
                    startActivity(MainActivity.class);
                    finish();
                }else {

                    Intent intent = new Intent(getActivity(), Loginactivity.class);
                    Bundle bundle = new Bundle();
                    bundle.putString("isfirstlogin", "1");
                    intent.putExtras(bundle);
                    startActivity(intent);
                    overridePendingTransition(R.anim.slide_left_in,R.anim.slide_right_out);

                    finish();
                }

            }
        });
    }

}
