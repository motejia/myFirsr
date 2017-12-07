package com.example.acer.anmiatinoshow;

import android.content.Intent;
import android.graphics.Color;
import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.acer.anmiatinoshow.Fragments.FristFragment;
import com.example.acer.anmiatinoshow.Fragments.SecondFragment;
import com.example.acer.anmiatinoshow.Fragments.ThirdFragment;

import java.util.ArrayList;

//主要页面
public class TwoActivity extends AppCompatActivity {
    private Fragment[]fragments = {new FristFragment(),new SecondFragment(),new ThirdFragment()};
    private int[]ids = {R.id.but1,R.id.but2,R.id.but3};
    private RadioButton[]buttons = new RadioButton[ids.length];
    private FragmentManager manager;
    private RadioGroup group;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two);
        //获取点击过来的数据
        Intent intent = getIntent();
        ArrayList<String> list = intent.getStringArrayListExtra("list");

        //关联Fragment
        manager = getSupportFragmentManager();
        FragmentTransaction ft = manager.beginTransaction();
        ft.add(R.id.layout,fragments[0]);
        ft.commit();

        for(int i = 0 ; i< buttons.length ; i++){
            buttons[i] = (RadioButton) findViewById(ids[i]);
        }
        buttons[0].setSelected(true);
        buttons[0].setTextColor(Color.RED);

        //设置fragment切换
        group = (RadioGroup) findViewById(R.id.group);
        group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                FragmentTransaction ft = manager.beginTransaction();
                switch (checkedId){
                    case R.id.but1:
                        ft.replace(R.id.layout,fragments[0]);
                        changColor(0);
                        break;
                    case R.id.but2:
                        ft.replace(R.id.layout,fragments[1]);
                        changColor(1);
                        break;
                    case R.id.but3:
                        ft.replace(R.id.layout,fragments[2]);
                        changColor(2);
                        break;
                }
                ft.commit();
            }
        });
    }

    //设置切换颜色
    public void changColor(int i){
        for(int o = 0;o<buttons.length;o++){
            if(o == i){
                buttons[o].setSelected(true);
                buttons[o].setTextColor(Color.RED);
            }else{
                buttons[o].setSelected(false);
                buttons[o].setTextColor(Color.BLACK);
            }
        }
    }
}
