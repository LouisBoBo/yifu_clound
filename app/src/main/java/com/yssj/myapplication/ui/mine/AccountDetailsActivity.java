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

        mStreeOption.add("??????");
        mStreeOption.add("??????");
        mStreeOption.add("??????");
        mStreeOption.add("??????");

        //????????????
        refreshLayout.setOnRefreshListener(refreshLayout -> {
            refreshLayout.finishRefresh();
            refreshLayout.finishLoadMore();
        });


        //????????????
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

    //????????????
    private void showStreeConstellationPickerView() {
        OptionsPickerView pvOptions = new OptionsPickerBuilder(getActivity(), (v, options1, options2, options3) -> {
            typeSelectOption = options1;
            typeselect.setText(mStreeOption.get(options1));
            return false;
        })
                .setTitleText("?????????")
                .setSelectOptions(typeSelectOption)
                .build();
        pvOptions.setPicker(mStreeOption);
        pvOptions.show();
    }

    //???????????????
    private void timePicker(){
        //???????????????
        TimePickerView pvTime = new TimePickerBuilder(this, new OnTimeSelectListener() {
            @Override
            public void onTimeSelected(Date date, View v) {
                String datetime = getTime(date);
                timeselect.setText(datetime);
            }

        }).build();
        pvTime.setDate(Calendar.getInstance());//??????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????
        pvTime.show();
    }

    //????????????????????????????????????
    private String getTime(Date date) {//???????????????????????????????????????
        SimpleDateFormat format = new SimpleDateFormat("yyyy???MM???");
        return format.format(date);
    }
}
