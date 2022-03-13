package com.yssj.myapplication.ui.mine;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.yssj.myapplication.R;
import com.yssj.myapplication.base.BaseActivity;
import com.yssj.myapplication.ui.mine.adapter.AccountDetailsAdapter;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.xuexiang.xui.widget.picker.widget.OptionsPickerView;
import com.xuexiang.xui.widget.picker.widget.TimePickerView;
import com.xuexiang.xui.widget.picker.widget.builder.OptionsPickerBuilder;
import com.xuexiang.xui.widget.picker.widget.builder.TimePickerBuilder;
import com.xuexiang.xui.widget.picker.widget.listener.OnTimeSelectListener;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class AccountDetailsActivity extends BaseActivity implements View.OnClickListener{
    private RecyclerView myrecyclerview;
    private AccountDetailsAdapter adapter;
    private TextView timeselect;
    private TextView typeselect;
    private TimePickerView pickerView;
    private List<String> mStreeOption = new ArrayList<>();
    private int typeSelectOption = 0;
    private SmartRefreshLayout refreshLayout;
    private Context mconstant;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account_details);
        mconstant = this;

        initView();
    }

    public void initView(){
        refreshLayout = findViewById(R.id.refreshLayout);
        ImageView backimg = findViewById(R.id.headview_back_img);
        backimg.setOnClickListener(this::onClick);

        timeselect = findViewById(R.id.time_select);
        timeselect.setOnClickListener(this::onClick);

        typeselect = findViewById(R.id.type_select);
        typeselect.setOnClickListener(this::onClick);

        myrecyclerview = findViewById(R.id.myrecyclerview);

        GridLayoutManager device_manager = new GridLayoutManager(AccountDetailsActivity.this,1);
        myrecyclerview.setLayoutManager(device_manager);
        adapter = new AccountDetailsAdapter();
        myrecyclerview.setAdapter(adapter);

        mStreeOption.add("全部");
        mStreeOption.add("收入");
        mStreeOption.add("消费");
        mStreeOption.add("提现");

        //下拉刷新
        refreshLayout.setOnRefreshListener(refreshLayout -> {
            refreshLayout.finishRefresh();
            refreshLayout.finishLoadMore();
        });


        //上拉加载
        refreshLayout.setOnLoadMoreListener(refreshLayout -> {
            refreshLayout.finishRefresh();
            refreshLayout.finishLoadMore();
        });
    }

    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.headview_back_img){
            finish();
        }else if(view.getId() == R.id.time_select){
            timePicker();
        }else if(view.getId() == R.id.type_select){
            showStreeConstellationPickerView();
        }
    }

    //选择类型
    private void showStreeConstellationPickerView() {
        OptionsPickerView pvOptions = new OptionsPickerBuilder(getActivity(), (v, options1, options2, options3) -> {
            typeSelectOption = options1;
            typeselect.setText(mStreeOption.get(options1));
            return false;
        })
                .setTitleText("请选择")
                .setSelectOptions(typeSelectOption)
                .build();
        pvOptions.setPicker(mStreeOption);
        pvOptions.show();
    }

    //时间选择器
    private void timePicker(){
        //时间选择器
        TimePickerView pvTime = new TimePickerBuilder(this, new OnTimeSelectListener() {
            @Override
            public void onTimeSelected(Date date, View v) {
                String datetime = getTime(date);
                timeselect.setText(datetime);
            }

        }).build();
        pvTime.setDate(Calendar.getInstance());//注：根据需求来决定是否使用该方法（一般是精确到秒的情况），此项可以在弹出选择器的时候重新设置当前时间，避免在初始化之后由于时间已经设定，导致选中时间与当前时间不匹配的问题。
        pvTime.show();
    }

    //根据需要自行截取数据显示
    private String getTime(Date date) {//可根据需要自行截取数据显示
        SimpleDateFormat format = new SimpleDateFormat("yyyy年MM月");
        return format.format(date);
    }
}
