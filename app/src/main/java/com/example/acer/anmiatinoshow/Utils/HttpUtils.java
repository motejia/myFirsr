package com.example.acer.anmiatinoshow.Utils;

import android.os.Handler;

import java.io.IOException;
import java.util.HashMap;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by acer on 2017/12/4.
 */

public class HttpUtils {
    private Handler handler = new Handler();
    private findMessage message;
    public HttpUtils(findMessage message){
        this.message = message;
    }

    public void postReposen(String path, HashMap<String,String>map){
        OkHttpClient client = new OkHttpClient();
        FormBody.Builder builder = new FormBody.Builder();
        for(String key : map.keySet()){
            builder.add(key,map.get(key));
        }
        final Request request = new Request.Builder().url(path).post(builder.build()).build();
        Call call = client.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                final String str = response.body().string();
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        message.getString(str,1218);
                    }
                });
            }
        });
    }

    public void postReposenTwo(String path, HashMap<String,String>map){
        OkHttpClient client = new OkHttpClient();
        FormBody.Builder builder = new FormBody.Builder();
        for(String key : map.keySet()){
            builder.add(key,map.get(key));
        }
        final Request request = new Request.Builder().url(path).post(builder.build()).build();
        Call call = client.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                final String str = response.body().string();
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        message.getString(str,0625);
                    }
                });
            }
        });
    }
    public interface findMessage{
        void getString(String str,int tag);
    }
}
