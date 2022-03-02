package com.exc.myapplication.ui.mine.adapter;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.exc.myapplication.R;

import java.util.List;

public class AccountDetailsAdapter extends RecyclerView.Adapter<AccountDetailsAdapter.VH> {
    private List<String> areaModelList;


    public AccountDetailsAdapter.OnItemClick mOnItemClick;
    public interface OnItemClick {
        void click(int index);
    }
    public void setOnItemClick(AccountDetailsAdapter.OnItemClick onItemClick) {
        mOnItemClick = onItemClick;
    }

    public void setmDatas(List<String> modelList) {
        areaModelList = modelList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public AccountDetailsAdapter.VH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //LayoutInflater.from指定写法
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_account_details, parent, false);
        return new AccountDetailsAdapter.VH(v);
    }

    @SuppressLint("ResourceAsColor")
    @Override
    public void onBindViewHolder(@NonNull AccountDetailsAdapter.VH holder, int position) {


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
        public ImageView headImg;
        public TextView tv_count;
        public TextView tv_money;
        public TextView tv_time;
        public TextView tv_mark;

        public VH(View v) {
            super(v);
            headImg = v.findViewById(R.id.head_img);
            tv_count = v.findViewById(R.id.tv_account);
            tv_money = v.findViewById(R.id.tv_money);
            tv_time = v.findViewById(R.id.tv_time);
            tv_mark = v.findViewById(R.id.tv_mark);
        }
    }

    public void refreshUI(int position) {
        notifyDataSetChanged();
    }

}