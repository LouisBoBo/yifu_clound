package com.yssj.myapplication.ui.cangraborder.Adapter;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.yssj.myapplication.R;

import java.util.List;

public class CangraborderAdapter extends RecyclerView.Adapter<CangraborderAdapter.VH> {
    private List<String> areaModelList;


    public CangraborderAdapter.OnItemClick mOnItemClick;
    public interface OnItemClick {
        void click(int index);
    }
    public void setOnItemClick(CangraborderAdapter.OnItemClick onItemClick) {
        mOnItemClick = onItemClick;
    }

    public void setmDatas(List<String> modelList) {
        areaModelList = modelList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public CangraborderAdapter.VH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //LayoutInflater.from指定写法
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_cangrab_order, parent, false);
        return new CangraborderAdapter.VH(v);
    }

    @SuppressLint("ResourceAsColor")
    @Override
    public void onBindViewHolder(@NonNull CangraborderAdapter.VH holder, int position) {


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            //item 点击事件
            public void onClick(View v) {
                mOnItemClick.click(position);
            }
        });
    }


    @Override
    public int getItemCount() {
        if(areaModelList == null || areaModelList.size() ==0){
            return 10;
        }else
            return areaModelList.size();
    }

    //② 创建ViewHolder 绑定item元素
    public static class VH extends RecyclerView.ViewHolder {
        public View baseview;


        public VH(View v) {
            super(v);

        }
    }

    public void refreshUI(int position) {
        notifyDataSetChanged();
    }

}
