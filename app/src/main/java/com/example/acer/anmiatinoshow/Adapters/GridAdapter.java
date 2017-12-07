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
 * Created by acer on 2017/12/5.
 */

public class GridAdapter extends BaseAdapter{
    private List<FirstJson.CBean>list;
    public GridAdapter(List<FirstJson.CBean>list){
        this.list = list;
    }
    @Override
    public int getCount() {
        return 5;
    }

    @Override
    public FirstJson.CBean getItem(int position) {
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
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.grid_item,null);
            vh = new ViewHolder(convertView);
            convertView.setTag(vh);
        }else{
            vh = (ViewHolder) convertView.getTag();
        }
        FirstJson.CBean cBean = list.get(position);
        Picasso.with(parent.getContext()).load(cBean.getTeacher_img()).into(vh.image);
        vh.text.setText(cBean.getTeacher_name());
        return convertView;
    }

    class ViewHolder{
        TextView text;
        ImageView image;
        public ViewHolder(View view){
            text = view.findViewById(R.id.text_item);
            image = view.findViewById(R.id.image_item);
        }
    }
}