package com.example.acer.anmiatinoshow.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;

import com.example.acer.anmiatinoshow.Adapters.GoodClassAdapter;
import com.example.acer.anmiatinoshow.Adapters.GridAdapter;
import com.example.acer.anmiatinoshow.Adapters.My_pager;
import com.example.acer.anmiatinoshow.Json.FirstJson;
import com.example.acer.anmiatinoshow.R;
import com.example.acer.anmiatinoshow.Utils.HttpUtils;
import com.example.acer.anmiatinoshow.YourselfActivity;
import com.google.gson.Gson;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by acer on 2017/12/4.
 */

//首页-推荐
public class shouye_recommnd extends Fragment implements HttpUtils.findMessage {
    private String path = "http://api.dameiketang.com/manager.php?m=Admin&c=Newshow&a=user_lesson_type_id";
    private String path1 = "http://api.dameiketang.com/manager.php?m=Admin&c=Threevesion&a=IndexPageData";
    private String id = "6894681b-ad8b-47e4-9f17-1cf07324464c";
    private View view;
    private ArrayList<String> list;
    private HashMap<String,String> map = new HashMap<>();
    private HttpUtils utils;
    private ViewPager pager;
    private ArrayList<ImageView>lists = new ArrayList<>();
    private ArrayList<ImageView>lists1 = new ArrayList<>();
    private HashMap<String,Object>item = new HashMap<>();
    //图片轮播handler
    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            if (msg.what==11){
                int index= pager.getCurrentItem();
                index++;
                handler.sendEmptyMessageDelayed(11,2000);
                pager.setCurrentItem(index);
            }
            if(msg.what ==12){
                int index= double_pager.getCurrentItem();
                index++;
                handler.sendEmptyMessageDelayed(12,5000);
                double_pager.setCurrentItem(index);
            }
        }
    };
    private ViewPager double_pager;
    private My_pager adapter1;
    private My_pager adapter;
    private GridView gridview;
    private GridView goodclass;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.shouye_tuijian,null);
        utils = new HttpUtils(this);
        getSendMessage();
        getAllMessage();
        find();
        return view;
    }

    //找到控件
    private void find() {
        ScrollView scroll = view.findViewById(R.id.scroll_View);
        scroll.smoothScrollTo(0,0);
        pager = view.findViewById(R.id.view_pager);
        double_pager = view.findViewById(R.id.double_pager);
        adapter1 = new My_pager(lists1);
        double_pager.setAdapter(adapter1);
        handler.sendEmptyMessageDelayed(12,1000);
        //添加适配器
        adapter = new My_pager(lists);
        pager.setAdapter(adapter);
        handler.sendEmptyMessageDelayed(11,1000);


        //跳转开启订制,个性化推荐
        Button kaiqi = view.findViewById(R.id.start_yourself);
        kaiqi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(),YourselfActivity.class));
            }
        });

        //教师-更多
        TextView more = view.findViewById(R.id.more);
        more.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        gridview = view.findViewById(R.id.grid_view);
        goodclass = view.findViewById(R.id.goodclass_gridview);

    }

    //获取所有的数据
    private void getAllMessage() {
        map.clear();
        map.put("id",id);
        utils.postReposenTwo(path1,map);
    }

    //点击的数据
    private void getSendMessage() {
        list = getActivity().getIntent().getStringArrayListExtra("list");
        if(list != null){
            StringBuffer sb = new StringBuffer();
            for(int i = 0;i<list.size();i++){
                if(i == list.size()-1){
                    sb.append(list.get(i));
                    continue;
                }else{
                    sb.append(list.get(i)+",");
                }
            }
            String str = new String(sb);
            map.put("id","6894681b-ad8b-47e4-9f17-1cf07324464c");
            map.put("type_id",str);
            utils.postReposen(path,map);
        }
    }

    //获取接口返回的数据
    @Override
    public void getString(String str, int tag) {
        Log.i("tag",str);
        if(tag == 0625){
            //顶部轮播
            FirstJson json = new Gson().fromJson(str,FirstJson.class);
            List<FirstJson.EBean> elist = json.getE();
            for(int i = 0 ; i < elist.size() ; i++){
                ImageView img = new ImageView(getContext());
                img.setLayoutParams(new ViewGroup.LayoutParams(ViewPager.LayoutParams.MATCH_PARENT, ViewPager.LayoutParams.MATCH_PARENT));
                Picasso.with(getActivity()).load(elist.get(i).getImgurl()).into(img);
                lists.add(img);
            }
            if(lists != null){
                adapter.notifyDataSetChanged();
            }

            //双线课轮播
            FirstJson firstJson = new Gson().fromJson(str, FirstJson.class);
            List<FirstJson.LBean> llist = firstJson.getL();
            for(int i = 0 ; i < llist.size() ; i++){
                ImageView img = new ImageView(getContext());
                img.setScaleType(ImageView.ScaleType.FIT_XY);
                img.setLayoutParams(new ViewGroup.LayoutParams(ViewPager.LayoutParams.MATCH_PARENT, ViewPager.LayoutParams.MATCH_PARENT));
                Picasso.with(getActivity()).load(llist.get(i).getImg()).into(img);
                lists1.add(img);
            }
            if(lists1 != null){
                adapter1.notifyDataSetChanged();
            }

            //名师中心
            FirstJson teacher = new Gson().fromJson(str, FirstJson.class);
            List<FirstJson.CBean> clist = teacher.getC();
            GridAdapter grid_adapter = new GridAdapter(clist);
            gridview.setAdapter(grid_adapter);

            //好评课程
            FirstJson good_class = new Gson().fromJson(str, FirstJson.class);
            List<FirstJson.HBean> hlist = good_class.getH();
            GoodClassAdapter good_adapter = new GoodClassAdapter(hlist);
            goodclass.setAdapter(good_adapter);
        }
    }

}
