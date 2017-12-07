package com.example.acer.anmiatinoshow.Adapters;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.ArrayList;

/**
 * Created by acer on 2017/12/5.
 */

public class My_pager extends PagerAdapter {
    private ArrayList<ImageView>lists;
    public My_pager(ArrayList<ImageView>lists){
        this.lists = lists;
    }
    @Override
    public int getCount() {
        if (lists.size()>0){
            return Integer.MAX_VALUE;
        }

        return 0;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view==object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, final int position) {
        View v=lists.get(position%lists.size());
        ViewGroup view= (ViewGroup) v.getParent();
        if (view!=null){
            view.removeView(v);
        }
        container.addView(v);
        //点击条目跳转
        v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        return v;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
    }
}
