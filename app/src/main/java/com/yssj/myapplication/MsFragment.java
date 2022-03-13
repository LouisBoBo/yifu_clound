package com.yssj.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.yssj.myapplication.ui.cangraborder.Adapter.CangraborderAdapter;
import com.yssj.myapplication.ui.cangraborder.CangraborderDetaillActivity;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;

public class MsFragment extends Fragment {
    private RecyclerView myrecyclerview;
    private CangraborderAdapter adapter;
    private String content;
    private View pubview;
    private SmartRefreshLayout refreshLayout;


    public MsFragment(String content) {
        this.content = content;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fg_content,container,false);
        myrecyclerview = view.findViewById(R.id.myrecyclerview);
        refreshLayout = view.findViewById(R.id.refreshLayout);

        initView();
        pubview = view;
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
                Intent intent = new Intent(getActivity(), CangraborderDetaillActivity.class);
                startActivity(intent);

//                startActivity(intent, ActivityOptions.makeSceneTransitionAnimation(getActivity()).toBundle());
                getActivity().overridePendingTransition(R.anim.slide_left_in, R.anim.slide_left_out);
            }
        });


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
}
