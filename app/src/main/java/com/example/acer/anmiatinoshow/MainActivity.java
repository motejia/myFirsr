package com.example.acer.anmiatinoshow;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.acer.anmiatinoshow.Json.MyJson;
import com.google.gson.Gson;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

//动画页面
public class MainActivity extends AppCompatActivity {

    private ImageView img2,img1,smalla,smallb,smallc,smalld,start_beautiful,msamlla,msamllb,msamllc;
    private TextView description;
    private TextView title;
    private boolean bool = true;
    private boolean bool2 = true;
    private boolean bool3 = true;
    private boolean bool4 = true;
    private boolean flag1 = true;
    private boolean flag2 = true;
    private boolean flag3 = true;
    private boolean flag4 = true;
    private boolean flag5 = true;
    private boolean z1 = true;
    private boolean z2 = true;
    private boolean z3 = true;
    private boolean z4 = true;
    private boolean z5 = true;
    private boolean j1 = true;
    private boolean j2 = true;
    private boolean j3 = true;
    private boolean j4 = true;
    private boolean j5 = true;
    private boolean j6 = true;
    private ImageView obchuazhuang;
    private ImageView obcmeixue;
    private ImageView obcmeirong;
    private ImageView obcmeifa;
    private ImageView obcmeijia;
    private ImageView start_beautiful_blue;
    private TextView last;
    private TextView again;
    private ImageView huazhuang;
    private ImageView meijia;
    private ImageView meifa;
    private ImageView meirong;
    private ImageView meixue;
    private ImageView yjbz;
    private ImageView jygl;
    private ImageView cwgl;
    private ImageView zbyz;
    private ImageView qywh;
    private ImageView tdjs;
    private MyJson myJson;
    private ArrayList<String>list = new ArrayList<>();

    //开始动画,第一个界面
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        json();
        find();
        title = (TextView) findViewById(R.id.tex);
        description = (TextView) findViewById(R.id.desc);
        again = (TextView) findViewById(R.id.again);
        //重新选择
        again.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onStart();
                title.setText("技能等级");
                description.setText("请根据您的实际情况选择技能等级");
                img1.setEnabled(false);
                img2.setEnabled(false);
                ObjectAnimator animatorY1 = ObjectAnimator.ofFloat(img1,"translationY",0,0);
                ObjectAnimator animatorY2 = ObjectAnimator.ofFloat(img2,"translationY",0,0);
                AnimatorSet set = new AnimatorSet();
                set.play(animatorY1).with(animatorY2);
                set.setDuration(2000);
                set.start();
                set.addListener(new Animator.AnimatorListener() {
                    @Override
                    public void onAnimationStart(Animator animation) {
                    }

                    @Override
                    public void onAnimationEnd(Animator animation) {
                        img1.setEnabled(true);
                        img2.setEnabled(true);
                    }

                    @Override
                    public void onAnimationCancel(Animator animation) {

                    }

                    @Override
                    public void onAnimationRepeat(Animator animation) {

                    }
                });
            }
        });

        //开始动画,选择向中间靠拢
        img1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                img1.setEnabled(false);
                img2.setEnabled(false);
                again.setEnabled(false);
                ObjectAnimator animatorX = ObjectAnimator.ofFloat(img1,"translationX",-200,0);
                animatorX.setDuration(2000);
                ObjectAnimator animatorX1 = ObjectAnimator.ofFloat(img2,"translationX",200,0);
                animatorX1.setDuration(2000);

                AnimatorSet set = new AnimatorSet();
                set.play(animatorX).with(animatorX1);
                set.start();
                //美业人
                animatorX.addListener(new Animator.AnimatorListener() {
                    @Override
                    public void onAnimationStart(Animator animation) {

                    }

                    @Override
                    public void onAnimationEnd(Animator animation) {
                        img1OnEnd();
                    }
                    @Override
                    public void onAnimationCancel(Animator animation) {

                    }

                    @Override
                    public void onAnimationRepeat(Animator animation) {

                    }
                });
            }
        });

        img2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                img2.setEnabled(false);
                img1.setEnabled(false);
                again.setEnabled(false);
                ObjectAnimator animatorX = ObjectAnimator.ofFloat(img1,"translationX",-200,0);
                animatorX.setDuration(2000);
                ObjectAnimator animatorX1 = ObjectAnimator.ofFloat(img2,"translationX",200,0);
                animatorX1.setDuration(2000);

                AnimatorSet set = new AnimatorSet();
                set.play(animatorX).with(animatorX1);
                set.start();

                animatorX.addListener(new Animator.AnimatorListener() {
                    @Override
                    public void onAnimationStart(Animator animation) {

                    }

                    @Override
                    public void onAnimationEnd(Animator animation) {
                        img2OnEnd();
                    }

                    @Override
                    public void onAnimationCancel(Animator animation) {

                    }

                    @Override
                    public void onAnimationRepeat(Animator animation) {

                    }
                });
            }
        });
    }

    //数据解析
    private void json() {
        try {
            InputStream in = this.getAssets().open("corstom.json");
            StringBuffer sb = new StringBuffer();
            int i;
            byte[]by = new byte[1024];
            while((i=in.read(by)) != -1){
                sb.append(new String(by,0,i));
            }
            String str = String.valueOf(sb);
            myJson = new Gson().fromJson(str, MyJson.class);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    //美业人运动一
    private void img1OnEnd() {
        again.setVisibility(View.VISIBLE);
        img2.setVisibility(View.GONE);
        img1.setEnabled(false);
        again.setEnabled(true);
        msamlla.setVisibility(View.VISIBLE);
        msamllb.setVisibility(View.VISIBLE);
        msamllc.setVisibility(View.VISIBLE);
        ObjectAnimator center = ObjectAnimator.ofFloat(msamlla,"translationY",0,200f);

        ObjectAnimator leftX = ObjectAnimator.ofFloat(msamllb,"translationX",0,-200f);
        ObjectAnimator leftY = ObjectAnimator.ofFloat(msamllb,"translationY",0,200f);

        ObjectAnimator rightX = ObjectAnimator.ofFloat(msamllc,"translationX",0,200f);
        ObjectAnimator rightY = ObjectAnimator.ofFloat(msamllc,"translationY",0,200f);

        ObjectAnimator main = ObjectAnimator.ofFloat(img1,"translationY",0,-50f);
        AnimatorSet set = new AnimatorSet();
        set.setDuration(2000);
        set.play(center).with(leftX).with(leftY).with(rightX).with(rightY).with(main);
        set.start();

        title.setText("技能等级");
        description.setText("请根据您的实际情况选择技能等级");
    }
    //爱好者运动一
    private void img2OnEnd() {
        again.setVisibility(View.VISIBLE);
        img1.setVisibility(View.GONE);
        img2.setEnabled(false);
        again.setEnabled(true);
        smalla.setVisibility(View.VISIBLE);
        smallb.setVisibility(View.VISIBLE);
        smallc.setVisibility(View.VISIBLE);
        smalld.setVisibility(View.VISIBLE);
        ObjectAnimator left = ObjectAnimator.ofFloat(smalla,"translationX",0,-180f);
        ObjectAnimator leftY = ObjectAnimator.ofFloat(smalla,"translationY",0,-70f);

        ObjectAnimator right = ObjectAnimator.ofFloat(smalld,"translationX",0,180f);
        ObjectAnimator rightY = ObjectAnimator.ofFloat(smalld,"translationY",0,-70f);

        ObjectAnimator left_topX = ObjectAnimator.ofFloat(smallb,"translationX",0,-80f);
        ObjectAnimator left_topY = ObjectAnimator.ofFloat(smallb,"translationY",0,-200f);

        ObjectAnimator right_topY = ObjectAnimator.ofFloat(smallc,"translationY",0,-200f);
        ObjectAnimator right_topX = ObjectAnimator.ofFloat(smallc,"translationX",0,80f);

        ObjectAnimator main = ObjectAnimator.ofFloat(img2,"translationY",0,50f);
        AnimatorSet set = new AnimatorSet();
        set.setDuration(2000);
        set.play(left).with(right)
                .with(left_topX).with(left_topY)
                .with(right_topX).with(right_topY)
                .with(leftY).with(rightY).with(main);
        set.start();

        title.setText("兴趣选择");
        description.setText("请选择感兴趣的修炼魔法");
        start_beautiful.setVisibility(View.VISIBLE);
    }

    //查找控件
    private void find() {
        img1 = (ImageView) findViewById(R.id.image1);
        img2 = (ImageView) findViewById(R.id.image2);
        smalla = (ImageView) findViewById(R.id.small1);
        smallb = (ImageView) findViewById(R.id.small2);
        smallc = (ImageView) findViewById(R.id.small3);
        smalld = (ImageView) findViewById(R.id.small4);
        msamlla = (ImageView) findViewById(R.id.meiyeren_small1);
        msamllb = (ImageView) findViewById(R.id.meiyeren_small2);
        msamllc = (ImageView) findViewById(R.id.meiyeren_small3);
        start_beautiful = (ImageView) findViewById(R.id.start_beautiful);
        obchuazhuang = (ImageView) findViewById(R.id.meiyeren_chu1);
        obcmeijia = (ImageView) findViewById(R.id.meiyeren_chu2);
        obcmeifa = (ImageView) findViewById(R.id.meiyeren_chu3);
        obcmeirong = (ImageView) findViewById(R.id.meiyeren_chu5);
        obcmeixue = (ImageView) findViewById(R.id.meiyeren_chu6);
        start_beautiful_blue = (ImageView) findViewById(R.id.start_beautiful_blue);
        last = (TextView) findViewById(R.id.last);
        huazhuang = (ImageView) findViewById(R.id.meiyeren_zaizhezhe_huazhuang);
        meijia = (ImageView) findViewById(R.id.meiyeren_zaizhezhe_meijia);
        meifa = (ImageView) findViewById(R.id.meiyeren_zaizhezhe_meifa);
        meirong = (ImageView) findViewById(R.id.meiyeren_zaizhizhe_meirong);
        meixue = (ImageView) findViewById(R.id.meiyeren_zaizhizhe_meixue);
        yjbz = (ImageView) findViewById(R.id.meiyeren_jingyingzhe_yejibeizeng);
        jygl = (ImageView) findViewById(R.id.meiyeren_jingyingzhe_jingyingguanli);
        cwgl = (ImageView) findViewById(R.id.meiyeren_jingyingzhe_caiwuguanli);
        zbyz = (ImageView) findViewById(R.id.meiyeren_jingyingzhe_zibenyunzuo);
        qywh = (ImageView) findViewById(R.id.meiyeren_jingyingzhe_qiyewenhua);
        tdjs = (ImageView) findViewById(R.id.meiyeren_jingyingzhe_tuanduijianshe);
    }

    //开始,初始化控件
    @Override
    protected void onStart() {
        super.onStart();
        img1.setEnabled(false);
        img2.setEnabled(false);
        ObjectAnimator animator1 = ObjectAnimator.ofFloat(img1,"translationX",0,-200f);
        ObjectAnimator animator2 = ObjectAnimator.ofFloat(img2,"translationX",0,200f);
        AnimatorSet set = new AnimatorSet();
        set.play(animator1).with(animator2);
        set.setDuration(2000);
        set.start();
        set.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {
            }

            @Override
            public void onAnimationEnd(Animator animation) {
                img1.setEnabled(true);
                img2.setEnabled(true);
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });
        img1.setVisibility(View.VISIBLE);
        img2.setVisibility(View.VISIBLE);
        smalla.setVisibility(View.GONE);
        smallb.setVisibility(View.GONE);
        smallc.setVisibility(View.GONE);
        smalld.setVisibility(View.GONE);
        start_beautiful.setVisibility(View.GONE);
        msamlla.setVisibility(View.GONE);
        msamllb.setVisibility(View.GONE);
        msamllc.setVisibility(View.GONE);
        obchuazhuang.setVisibility(View.GONE);
        obcmeifa.setVisibility(View.GONE);
        obcmeijia.setVisibility(View.GONE);
        obcmeirong.setVisibility(View.GONE);
        obcmeixue.setVisibility(View.GONE);
        start_beautiful_blue.setVisibility(View.GONE);
        last.setVisibility(View.GONE);
        huazhuang.setVisibility(View.GONE);
        meifa.setVisibility(View.GONE);
        meijia.setVisibility(View.GONE);
        meixue.setVisibility(View.GONE);
        meirong.setVisibility(View.GONE);
        yjbz.setVisibility(View.GONE);
        jygl.setVisibility(View.GONE);
        cwgl.setVisibility(View.GONE);
        zbyz.setVisibility(View.GONE);
        qywh.setVisibility(View.GONE);
        tdjs.setVisibility(View.GONE);
        again.setVisibility(View.GONE);
        list.clear();
    }

    //点击事件
    public void small(View view) {
        switch (view.getId()){
            case R.id.small1:
                if(bool){
                    smalla.setImageResource(R.mipmap.zhichangjingying_select);
                    list.add(myJson.getT().get职场经营().getId());
                    bool = false;
                }else{
                    smalla.setImageResource(R.mipmap.zhichangjingying);
                    list.remove(myJson.getT().get职场经营().getId());
                    bool = true;
                }
                break;
            case R.id.small2:
                if(bool2){
                    smallb.setImageResource(R.mipmap.shenghuoxiuxian_select);
                    list.add(myJson.getT().get生活休闲().getId());
                    bool2 = false;
                }else{
                    smallb.setImageResource(R.mipmap.shenghuoxiuxian);
                    list.remove(myJson.getT().get生活休闲().getId());
                    bool2 = true;
                }
                break;
            case R.id.small3:
                if(bool3){
                    smallc.setImageResource(R.mipmap.zhutihuodong_select);
                    list.add(myJson.getT().get主题活动().getId());
                    bool3 = false;
                }else{
                    smallc.setImageResource(R.mipmap.zhutihuodong);
                    list.remove(myJson.getT().get主题活动().getId());
                    bool3 = true;
                }
                break;
            case R.id.small4:
                if(bool4){
                    smalld.setImageResource(R.mipmap.suxingyuyangsheng_select);
                    list.add(myJson.getT().get塑形养生().getId());
                    bool4 = false;
                }else{
                    smalld.setImageResource(R.mipmap.suxingyuyangsheng);
                    list.remove(myJson.getT().get塑形养生().getId());
                    bool4 = true;
                }
                break;
            case R.id.meiyeren_small1:
                //02-01初学者未选择
                beautiful();
                break;
            case R.id.meiyeren_small2:
                //02-02在职者未选择
                InWork();
                break;
            case  R.id.meiyeren_small3:
                //02-03经营者未选择
                InStore();
                break;
        }
    }

    //初学者未选择
    public void beautiful(){
        ObjectAnimator animator = ObjectAnimator.ofFloat(msamlla,"translationY",250,0);
        animator.setDuration(2000);
        animator.start();
        msamlla.setEnabled(false);
        img1.setVisibility(View.GONE);
        msamllb.setVisibility(View.GONE);
        msamllc.setVisibility(View.GONE);
        again.setVisibility(View.GONE);
        animator.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                obchuazhuang.setVisibility(View.VISIBLE);
                obcmeijia.setVisibility(View.VISIBLE);
                obcmeifa.setVisibility(View.VISIBLE);
                obcmeixue.setVisibility(View.VISIBLE);
                obcmeirong.setVisibility(View.VISIBLE);
                ObjectAnimator hz = ObjectAnimator.ofFloat(obchuazhuang,"translationX",0,-200f);
                ObjectAnimator mr = ObjectAnimator.ofFloat(obcmeirong,"translationX",0,200f);

                ObjectAnimator mxX = ObjectAnimator.ofFloat(obcmeixue,"translationX",0,100f);
                ObjectAnimator mxY = ObjectAnimator.ofFloat(obcmeixue,"translationY",0,-150f);

                ObjectAnimator mjX = ObjectAnimator.ofFloat(obcmeijia,"translationX",0,-100f);
                ObjectAnimator mjY = ObjectAnimator.ofFloat(obcmeijia,"translationY",0,-150f);

                ObjectAnimator mfX = ObjectAnimator.ofFloat(obcmeifa,"translationX",0,150f);
                ObjectAnimator mfY = ObjectAnimator.ofFloat(obcmeifa,"translationY",0,150f);

                AnimatorSet set = new AnimatorSet();
                set.setDuration(2000);
                set.play(hz).with(mr).with(mxX).with(mxY).with(mjX).with(mjY).with(mfX).with(mfY);
                set.start();
                start_beautiful_blue.setVisibility(View.VISIBLE);
                last.setVisibility(View.VISIBLE);
                last.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        img1OnEnd();
                        obchuazhuang.setVisibility(View.GONE);
                        obcmeijia.setVisibility(View.GONE);
                        obcmeifa.setVisibility(View.GONE);
                        obcmeixue.setVisibility(View.GONE);
                        obcmeirong.setVisibility(View.GONE);
                        start_beautiful_blue.setVisibility(View.GONE);
                        last.setVisibility(View.GONE);
                        img1.setVisibility(View.VISIBLE);
                        again.setVisibility(View.VISIBLE);
                        msamlla.setEnabled(true);
                    }
                });
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });
    }

    //初学者点击事件
    public void chuxuezhe(View view) {
        switch(view.getId()){
            case R.id.meiyeren_chu1:
                if(flag1){
                    obchuazhuang.setImageResource(R.mipmap.obchuazhuang_select);
                    list.add(myJson.getT().getOBC化妆().getId());
                    flag1 = false;
                }else{
                    obchuazhuang.setImageResource(R.mipmap.obchuazhuang);
                    list.remove(myJson.getT().getOBC化妆().getId());
                    flag1 = true;
                }
                break;
            case R.id.meiyeren_chu2:
                if(flag2){
                    obcmeijia.setImageResource(R.mipmap.obcmeijia_select);
                    list.add(myJson.getT().getOBC美甲().getId());
                    flag2 = false;
                }else{
                    obcmeijia.setImageResource(R.mipmap.obcmeijian);
                    list.remove(myJson.getT().getOBC美甲().getId());
                    flag2 = true;
                }
                break;
            case R.id.meiyeren_chu3:
                if(flag3){
                    obcmeifa.setImageResource(R.mipmap.obcmeifa_select);
                    list.add(myJson.getT().getOBC美发().getId());
                    flag3 = false;
                }else{
                    obcmeifa.setImageResource(R.mipmap.obcmeifa);
                    list.remove(myJson.getT().getOBC美发().getId());
                    flag3 = true;
                }
                break;
            case R.id.meiyeren_chu5:
                if(flag4){
                    obcmeirong.setImageResource(R.mipmap.obcmeirong_select);
                    list.add(myJson.getT().getOBC美容().getId());
                    flag4 = false;
                }else{
                    obcmeirong.setImageResource(R.mipmap.obcmeirong);
                    list.remove(myJson.getT().getOBC美容().getId());
                    flag4 = true;
                }
                break;
            case R.id.meiyeren_chu6:
                if(flag5){
                    obcmeixue.setImageResource(R.mipmap.obcmeixue_select);
                    //list.add(myJson.getT().get美学应用().getId());
                    flag5 = false;
                }else{
                    obcmeixue.setImageResource(R.mipmap.obcmeixue);
                    //list.remove(myJson.getT().get美学应用().getId());
                    flag5 = true;
                }
                break;
        }
    }

    //在职者未选择
    private void InWork(){
        ObjectAnimator animatorYa = ObjectAnimator.ofFloat(msamllb,"translationY",250,0);
        ObjectAnimator animatorXa = ObjectAnimator.ofFloat(msamllb,"translationX",0,0);
        AnimatorSet sXy = new AnimatorSet();
        sXy.play(animatorXa).with(animatorYa);
        sXy.setDuration(2000);
        sXy.start();
        img1.setVisibility(View.GONE);
        msamllb.setEnabled(false);
        msamlla.setVisibility(View.GONE);
        msamllc.setVisibility(View.GONE);
        again.setVisibility(View.GONE);
        sXy.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                huazhuang.setVisibility(View.VISIBLE);
                meijia.setVisibility(View.VISIBLE);
                meifa.setVisibility(View.VISIBLE);
                meixue.setVisibility(View.VISIBLE);
                meirong.setVisibility(View.VISIBLE);
                ObjectAnimator hz = ObjectAnimator.ofFloat(huazhuang,"translationX",0,-200f);
                ObjectAnimator mr = ObjectAnimator.ofFloat(meirong,"translationX",0,200f);

                ObjectAnimator mxX = ObjectAnimator.ofFloat(meixue,"translationX",0,100f);
                ObjectAnimator mxY = ObjectAnimator.ofFloat(meixue,"translationY",0,-150f);

                ObjectAnimator mjX = ObjectAnimator.ofFloat(meijia,"translationX",0,-100f);
                ObjectAnimator mjY = ObjectAnimator.ofFloat(meijia,"translationY",0,-150f);

                ObjectAnimator mfX = ObjectAnimator.ofFloat(meifa,"translationX",0,150f);
                ObjectAnimator mfY = ObjectAnimator.ofFloat(meifa,"translationY",0,150f);

                AnimatorSet set = new AnimatorSet();
                set.setDuration(2000);
                set.play(hz).with(mr).with(mxX).with(mxY).with(mjX).with(mjY).with(mfX).with(mfY);
                set.start();
                start_beautiful_blue.setVisibility(View.VISIBLE);
                last.setVisibility(View.VISIBLE);
                last.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        img1OnEnd();
                        huazhuang.setVisibility(View.GONE);
                        meijia.setVisibility(View.GONE);
                        meifa.setVisibility(View.GONE);
                        meixue.setVisibility(View.GONE);
                        meirong.setVisibility(View.GONE);
                        start_beautiful_blue.setVisibility(View.GONE);
                        last.setVisibility(View.GONE);
                        img1.setVisibility(View.VISIBLE);
                        again.setVisibility(View.VISIBLE);
                        msamllb.setEnabled(true);
                    }
                });
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });
    }

    //在职者点击事件
    public void zaizhizhe(View view) {
        switch(view.getId()){
            case R.id.meiyeren_zaizhezhe_huazhuang:
                if(z1){
                    huazhuang.setImageResource(R.mipmap.huazhuang_select);
                    z1 = false;
                }else{
                    huazhuang.setImageResource(R.mipmap.huazhuang);
                    z1 = true;
                }
                break;
            case R.id.meiyeren_zaizhezhe_meijia:
                if(z2){
                    meijia.setImageResource(R.mipmap.meijia_select);
                    z2 = false;
                }else{
                    meijia.setImageResource(R.mipmap.meijia);
                    z2 = true;
                }
                break;
            case R.id.meiyeren_zaizhizhe_meixue:
                if(z3){
                    meixue.setImageResource(R.mipmap.meixue_select);
                    z3 = false;
                }else{
                    meixue.setImageResource(R.mipmap.meixue);
                    z3 = true;
                }
                break;
            case R.id.meiyeren_zaizhizhe_meirong:
                if(z4){
                    meirong.setImageResource(R.mipmap.meirong_select);
                    z4 = false;
                }else{
                    meirong.setImageResource(R.mipmap.meirong);
                    z4 = true;
                }
                break;
            case R.id.meiyeren_zaizhezhe_meifa:
                if(z5){
                    meifa.setImageResource(R.mipmap.meifa_select);
                    z5 = false;
                }else{
                    meifa.setImageResource(R.mipmap.meifa);
                    z5 = true;
                }
                break;
        }
    }

    //经营者未选择
    private void InStore() {
        ObjectAnimator animatorYa = ObjectAnimator.ofFloat(msamllc,"translationY",250,0);
        ObjectAnimator animatorXa = ObjectAnimator.ofFloat(msamllc,"translationX",0,0);
        AnimatorSet sXy = new AnimatorSet();
        sXy.play(animatorXa).with(animatorYa);
        sXy.setDuration(2000);
        sXy.start();
        img1.setVisibility(View.GONE);
        msamllc.setEnabled(false);
        msamlla.setVisibility(View.GONE);
        msamllb.setVisibility(View.GONE);
        again.setVisibility(View.GONE);
        sXy.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                yjbz.setVisibility(View.VISIBLE);
                jygl.setVisibility(View.VISIBLE);
                cwgl.setVisibility(View.VISIBLE);
                zbyz.setVisibility(View.VISIBLE);
                qywh.setVisibility(View.VISIBLE);
                tdjs.setVisibility(View.VISIBLE);
                ObjectAnimator hz = ObjectAnimator.ofFloat(yjbz,"translationX",0,-200f);
                ObjectAnimator mr = ObjectAnimator.ofFloat(zbyz,"translationX",0,200f);

                ObjectAnimator mxX = ObjectAnimator.ofFloat(cwgl,"translationX",0,100f);
                ObjectAnimator mxY = ObjectAnimator.ofFloat(cwgl,"translationY",0,-150f);

                ObjectAnimator mjX = ObjectAnimator.ofFloat(jygl,"translationX",0,-100f);
                ObjectAnimator mjY = ObjectAnimator.ofFloat(jygl,"translationY",0,-150f);

                ObjectAnimator mfX = ObjectAnimator.ofFloat(qywh,"translationX",0,100f);
                ObjectAnimator mfY = ObjectAnimator.ofFloat(qywh,"translationY",0,150f);

                ObjectAnimator mqX = ObjectAnimator.ofFloat(tdjs,"translationX",0,-100f);
                ObjectAnimator mqY = ObjectAnimator.ofFloat(tdjs,"translationY",0,150f);


                AnimatorSet set = new AnimatorSet();
                set.setDuration(2000);
                set.play(hz).with(mr).with(mxX)
                        .with(mxY).with(mjX).with(mjY).
                        with(mfX).with(mfY).with(mqX).with(mqY);
                set.start();
                start_beautiful_blue.setVisibility(View.VISIBLE);
                last.setVisibility(View.VISIBLE);
                last.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        img1OnEnd();
                        yjbz.setVisibility(View.GONE);
                        zbyz.setVisibility(View.GONE);
                        tdjs.setVisibility(View.GONE);
                        cwgl.setVisibility(View.GONE);
                        qywh.setVisibility(View.GONE);
                        jygl.setVisibility(View.GONE);
                        start_beautiful_blue.setVisibility(View.GONE);
                        last.setVisibility(View.GONE);
                        img1.setVisibility(View.VISIBLE);
                        again.setVisibility(View.VISIBLE);
                        msamllc.setEnabled(true);
                    }
                });
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });
    }

    //经营者点击事件
    public void jingyingzhe(View view) {
        switch (view.getId()){
            case R.id.meiyeren_jingyingzhe_yejibeizeng:
                if(j1){
                    yjbz.setImageResource(R.mipmap.yejibeizeng_select);
                    list.add(myJson.getT().get业绩倍增().getId());
                    j1 = false;
                }else{
                    yjbz.setImageResource(R.mipmap.yejibeizeng);
                    list.remove(myJson.getT().get业绩倍增().getId());
                    j1 = true;
                }
                break;
            case R.id.meiyeren_jingyingzhe_jingyingguanli:
                if(j2){
                    jygl.setImageResource(R.mipmap.jingyingguanli_select);
                    list.add(myJson.getT().get经营管理().getId());
                    j2 = false;
                }else{
                    jygl.setImageResource(R.mipmap.jingyingguanli);
                    list.remove(myJson.getT().get经营管理().getId());
                    j2 = true;
                }
                break;
            case R.id.meiyeren_jingyingzhe_caiwuguanli:
                if(j3){
                    cwgl.setImageResource(R.mipmap.caiwuguanli_select);
                    //list.add(myJson.getT().get);
                    j3 = false;
                }else{
                    cwgl.setImageResource(R.mipmap.caiwuguanli);
                    j3 = true;
                }
                break;
            case R.id.meiyeren_jingyingzhe_zibenyunzuo:
                if(j4){
                    zbyz.setImageResource(R.mipmap.zibenyunzuo_select);
                    list.add(myJson.getT().get资本运作().getId());
                    j4 = false;
                }else{
                    zbyz.setImageResource(R.mipmap.zibenyunzuo);
                    list.remove(myJson.getT().get资本运作().getId());
                    j4 = true;
                }
                break;
            case R.id.meiyeren_jingyingzhe_qiyewenhua:
                if(j5){
                    qywh.setImageResource(R.mipmap.qiyewenhua_select);
                    //list.add(myJson.getT().get);
                    j5 = false;
                }else{
                    qywh.setImageResource(R.mipmap.qiyewenhua);
                    j5 = true;
                }
                break;
            case R.id.meiyeren_jingyingzhe_tuanduijianshe:
                if(j6){
                    tdjs.setImageResource(R.mipmap.tuanduijianshe_select);
                    list.add(myJson.getT().get团队建设().getId());
                    j6 = false;
                }else{
                    tdjs.setImageResource(R.mipmap.tuanduijianshe);
                    list.remove(myJson.getT().get团队建设().getId());
                    j6 = true;
                }
                break;
        }
    }

    //开启美丽点击事件
    public void kaishibeautiful(View view) {
        Intent intent = new Intent(MainActivity.this,TwoActivity.class);
        intent.putStringArrayListExtra("list",list);
        startActivity(intent);
        this.finish();
    }
}