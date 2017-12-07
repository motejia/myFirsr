package com.example.acer.anmiatinoshow.Fragments;

import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.IdRes;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.acer.anmiatinoshow.Json.FirstJson;
import com.example.acer.anmiatinoshow.R;
import com.example.acer.anmiatinoshow.Utils.HttpUtils;
import com.google.gson.Gson;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

//首页
public class FristFragment extends Fragment{
    private Fragment[]fragments = {new shouye_recommnd(),new shouye_changed(),new shouye_sousuo()};
    private int[]ids = {R.id.shouye_but1,R.id.shouye_but2,R.id.shouye_but3};
    private RadioButton[]buttons = new RadioButton[ids.length];
    private FragmentManager manager;
    private RadioGroup group;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.one_fragment,null);
        //关联Fragment
        manager = getChildFragmentManager();
        FragmentTransaction ft = manager.beginTransaction();
        if(!fragments[0].isAdded()){
            ft.add(R.id.shouye_layout,fragments[0]);
            ft.commit();
        }

        for(int i = 0 ; i< buttons.length ; i++){
            buttons[i] = view.findViewById(ids[i]);
        }
        buttons[0].setTextColor(Color.parseColor("#f57fd7"));

        //设置fragment切换
        group = view.findViewById(R.id.shouye_group);
        group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                FragmentTransaction ft = manager.beginTransaction();
                switch (checkedId){
                    case R.id.shouye_but1:
                        ft.replace(R.id.shouye_layout,fragments[0]);
                        changedColor(0);
                        break;
                    case R.id.shouye_but2:
                        ft.replace(R.id.shouye_layout,fragments[1]);
                        changedColor(1);
                        break;
                    case R.id.shouye_but3:
                        ft.replace(R.id.shouye_layout,fragments[2]);
                        changedColor(2);
                        break;
                }
                ft.commit();
            }
        });
        return view;
    }

    public void changedColor(int i){
        for(int o = 0;o<buttons.length;o++){
            if(o == i){
                buttons[o].setTextColor(Color.parseColor("#f57fd7"));
            }else{
                buttons[o].setTextColor(Color.BLACK);
            }
        }
    }

}