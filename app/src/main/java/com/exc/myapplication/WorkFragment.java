package com.exc.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.exc.myapplication.ui.cangraborder.Adapter.CangraborderAdapter;
import com.exc.myapplication.ui.cangraborder.CangraborderDetaillActivity;
import com.exc.myapplication.ui.robbedorder.GrabOrderDetailActivity;
import com.exc.myapplication.utils.FTPClientFunctions;

import java.util.ArrayList;

public class WorkFragment extends Fragment implements View.OnClickListener {
    private ViewPager viewpager;
    private View slider;
    private TextView title_one;
    private TextView title_two;
    private TextView title_three;
    private TextView tv_update;

    private ArrayList<View> listViews;
    private int offset = 0;//移动条图片的偏移量
    private int currIndex = 0;//当前页面的编号
    private int bmpWidth;// 移动条图片的长度
    private int one = 0; //移动条滑动一页的距离
    private int two = 0; //滑动条移动两页的距离

    private FTPClientFunctions ftpClient;

    private RecyclerView myrecyclerview;
    private CangraborderAdapter adapter;
    private String content;

    public WorkFragment(String content) {
        this.content = content;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fg_content,container,false);
        myrecyclerview = view.findViewById(R.id.myrecyclerview);

        initView();
        return view;
    }

    public void initView(){

        GridLayoutManager device_manager = new GridLayoutManager(getContext(),1);
        myrecyclerview.setLayoutManager(device_manager);
        adapter = new CangraborderAdapter();
        myrecyclerview.setAdapter(adapter);

        adapter.setOnItemClick(new CangraborderAdapter.OnItemClick() {
            @Override
            public void click(int index) {
                Intent intent = new Intent(getActivity(), GrabOrderDetailActivity.class);
                startActivity(intent);
                getActivity().overridePendingTransition(R.anim.slide_left_in, R.anim.slide_left_out);
            }
        });
    }

    @Override
    public void onClick(View v) {

    }
}
