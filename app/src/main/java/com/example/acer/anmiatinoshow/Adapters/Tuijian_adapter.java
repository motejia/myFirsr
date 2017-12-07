package com.example.acer.anmiatinoshow.Adapters;

import android.content.Context;
import android.os.Handler;
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

public class Tuijian_adapter extends BaseAdapter{
    private Context context;
    private MyJson json;
    private getBiaoMessage message;

    public Tuijian_adapter(Context context, MyJson json, getBiaoMessage message) {
        this.context = context;
        this.json = json;
        this.message = message;
    }

    @Override
    public int getCount() {
        return json.getD().size();
    }

    @Override
    public MyJson.DBean getItem(int position) {
        return json.getD().get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder vh;
        if(convertView == null){
            convertView = LayoutInflater.from(context).inflate(R.layout.my_flowlayout,null);
            vh = new ViewHolder(convertView);
            convertView.setTag(vh);
        }else{
            vh = (ViewHolder) convertView.getTag();
        }
        vh.text.setText(json.getD().get(position).getName());
        List<MyJson.MBean> mBeen = json.getM().get(position);
        initView(mBeen,vh.layout);
        return convertView;
    }

    private void initView(final List<MyJson.MBean> mBeen, FlowLayout layout) {
        layout.removeAllViews();
        final ArrayList<MyJson.MBean>list = new ArrayList<>();
        for(int i = 0 ; i < mBeen.size() ; i++){
            final MyJson.MBean mBean = mBeen.get(i);
            TextView tv = new TextView(context);
            tv.setText(mBean.getName());
            tv.setTextSize(18);
            tv.setGravity(Gravity.CENTER);
            tv.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    list.add(mBean);
                    message.getString(list);
                    mBeen.remove(mBean);
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
            text = view.findViewById(R.id.textview);
            layout = view.findViewById(R.id.flowLayout);
        }
    }

    public interface getBiaoMessage{
        void getString(List<MyJson.MBean>list);
    }
}
