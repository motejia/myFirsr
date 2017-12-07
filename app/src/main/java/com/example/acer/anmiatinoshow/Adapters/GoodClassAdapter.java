package com.example.acer.anmiatinoshow.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.acer.anmiatinoshow.Json.FirstJson;
import com.example.acer.anmiatinoshow.R;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by acer on 2017/12/6.
 */

public class GoodClassAdapter extends BaseAdapter{
    private List<FirstJson.HBean> list;
    public GoodClassAdapter(List<FirstJson.HBean>list){
        this.list = list;
    }
    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public FirstJson.HBean getItem(int position) {
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
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.good_class,null);
            vh = new ViewHolder(convertView);
            convertView.setTag(vh);
        }else{
            vh = (ViewHolder) convertView.getTag();
        }
        FirstJson.HBean hBean = list.get(position);
        Picasso.with(parent.getContext()).load(hBean.getBig_img_url()).into(vh.img);
        vh.text.setText(hBean.getLesson_name());
        return convertView;
    }

    class ViewHolder{
        TextView text;
        ImageView img;
        public ViewHolder(View view){
            text = view.findViewById(R.id.text_item_class);
            img = view.findViewById(R.id.image_item_class);
        }
    }
}
