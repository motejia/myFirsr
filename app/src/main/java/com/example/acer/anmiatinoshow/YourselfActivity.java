package com.example.acer.anmiatinoshow;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import com.example.acer.anmiatinoshow.Adapters.Dingzhi_adapter;
import com.example.acer.anmiatinoshow.Adapters.Tuijian_adapter;
import com.example.acer.anmiatinoshow.Json.MyJson;
import com.google.gson.Gson;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class YourselfActivity extends AppCompatActivity implements Tuijian_adapter.getBiaoMessage {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yourself);

        String str = GetString();
        Log.i("tag",str);
        if(str != null){
            MyJson json = new Gson().fromJson(str, MyJson.class);
            Tuijian_adapter adapter = new Tuijian_adapter(this,json,this);
            ListView bottom = (ListView) findViewById(R.id.bottom_biaoqian);
            bottom.setAdapter(adapter);
        }
    }
    private String GetString() {
        try {
            InputStream in = getAssets().open("corstom2.json");
            StringBuffer sb = new StringBuffer();
            int i = 0;
            byte[]by = new byte[1024];
            while((i=in.read(by))!= -1){
                sb.append(new String(by,0,i));
            }
            String ss = String.valueOf(sb);
            in.close();
            return ss;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void getString(List<MyJson.MBean> list) {
        Dingzhi_adapter adapter = new Dingzhi_adapter(list,this);
        ListView lv = (ListView) findViewById(R.id.top_flowLayout);
        lv.setAdapter(adapter);
    }
}
