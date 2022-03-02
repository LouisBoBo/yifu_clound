package com.exc.myapplication;

import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import java.util.ArrayList;

public class MsPagerAdapter extends PagerAdapter {

    private ArrayList<View> mData;

    public MsPagerAdapter(){

    }

    public MsPagerAdapter(ArrayList<View> view_list){
       super();
       this.mData = view_list;
    }

    @Override
    public int getCount() {
        return this.mData.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        container.addView(mData.get(position));
        return mData.get(position);
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView(mData.get(position));
    }
}
