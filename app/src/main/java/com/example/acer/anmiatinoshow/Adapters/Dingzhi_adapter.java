package com.example.acer.anmiatinoshow.Adapters;

import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.acer.anmiatinoshow.Json.MyJson;
import com.example.acer.anmiatinoshow.R;

import java.util.ArrayList;
import java.util.List;

import cn.lankton.flowlayout.FlowLayout;

import static android.R.id.message;

/**
 * Created by acer on 2017/12/5.
 */

public class Dingzhi_adapter extends BaseAdapter{
    private List<MyJson.MBean>list;
    private Context context;
    public Dingzhi_adapter(List<MyJson.MBean>list,Context context){
        this.list = list;
        this.context = context;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public MyJson.MBean getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder vh;
        if(convertView == null){
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.my_top_flowlayout,null);
            vh = new ViewHolder(convertView);
            convertView.setTag(vh);
        }else{
            vh = (ViewHolder)convertView.getTag();
        }
        vh.text.setText(list.get(position).getName());
        initView(list,vh.layout);
        return convertView;
    }

    private void initView(final List<MyJson.MBean> list, FlowLayout layout) {
        layout.removeAllViews();
        //final ArrayList<MyJson.MBean>list = new ArrayList<>();
        for(int i = 0 ; i < list.size() ; i++){
            final MyJson.MBean mBean = list.get(i);
            TextView tv = new TextView(context);
            tv.setText(mBean.getName());
            tv.setTextSize(18);
            tv.setGravity(Gravity.CENTER);
            tv.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    list.add(mBean);
                   // message.getString(list);
                    //mBeen.remove(mBean);
                }
            });
            ViewGroup.LayoutParams params = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            ViewGroup.MarginLayoutParams margin = new ViewGroup.MarginLayoutParams(params);
            margin.leftMargin = 10;
            margin.rightMargin = 10;
            margin.bottomMargin = 5;
            tv.setLayoutParams(margin);
            layout.addView(tv);
        }
    }

    class ViewHolder{
        TextView text;
        FlowLayout layout;
        public ViewHolder(View view){
            text = view.findViewById(R.id.top_textview);
            layout = view.findViewById(R.id.top_flowLayout);
        }
    }
}
