package com.example.acer.anmiatinoshow.Json;

import java.util.List;

/**
 * Created by acer on 2017/12/4.
 */

public class FirstJson {

    /**
     * i : 6894681
     * r : 0
     * m : 71137,1239
     * d : []
     * e : [{"imgurl":"http://capp.dameiketang.com/Uploads/images/indexgg/59f9729a2db67.jpg","target":"lesson://1285","outline":"0"},{"imgurl":"http://capp.dameiketang.com/Uploads/images/indexgg/59e60a29212d1.jpg","target":"lesson://1275","outline":"0"},{"imgurl":"http://capp.dameiketang.com/Uploads/images/indexgg/59db0cccd24c6.jpg","target":"lesson://1287","outline":"0"},{"imgurl":"http://capp.dameiketang.com/Uploads/images/indexgg/59b0f9e2d8dc3.jpg","target":"lesson://584","outline":"0"}]
     * h : [{"id":"141","all_time":null,"outline":"0","lesson_name":"半永久定妆系统课程训练阶段","teacher":"半永久资深高级讲师 王娟","is_look":"0","price":"40","one_type_id":"4","small_img_url":"http://capp.dameiketang.com/Uploads/smalladvertisement/1465007668.jpg","big_img_url":"http://capp.dameiketang.com/Uploads/smalladvertisement/1465007668.jpg","two_type_id":"19"},{"id":"207","all_time":null,"outline":"0","lesson_name":"李沁  美容课程专辑","teacher":"高级美容讲师李沁","is_look":"0","price":"25","one_type_id":"0","small_img_url":"http://capp.dameiketang.com/Uploads/smalladvertisement/1471253976.jpg","big_img_url":"http://capp.dameiketang.com/Uploads/bigadvertisement/1471253976.jpg","two_type_id":"0"},{"id":"390","all_time":null,"outline":"0","lesson_name":"广告创意化妆-滴水唇系列","teacher":"莎拉 Sarah","is_look":"0","price":"0","one_type_id":"4","small_img_url":"http://capp.dameiketang.com/Uploads/smalladvertisement/1474448833.jpg","big_img_url":"http://capp.dameiketang.com/Uploads/bigadvertisement/1474448833.jpg","two_type_id":"19"},{"id":"560","all_time":null,"outline":"0","lesson_name":"创意美甲款式之彩绘花卉美甲一","teacher":"国家高级美甲师　聂峰","is_look":"1","price":"3","one_type_id":"4","small_img_url":"http://capp.dameiketang.com/Uploads/smalladvertisement/1479436998.jpg","big_img_url":"http://capp.dameiketang.com/Uploads/bigadvertisement/1479436998.jpg","two_type_id":"5"}]
     * c : [{"teacher_id":"121","teacher_name":"李汶縚","teacher_img":"http://capp.dameiketang.com/Uploads/bigadvertisement/1479109002.jpg"},{"teacher_id":"151","teacher_name":"岳晓琳","teacher_img":"http://capp.dameiketang.com/Uploads/bigadvertisement/1496216094.jpg"},{"teacher_id":"159","teacher_name":"胡社光","teacher_img":"http://capp.dameiketang.com/Uploads/bigadvertisement/1501635973.jpg"},{"teacher_id":"153","teacher_name":"K.Kay","teacher_img":"http://capp.dameiketang.com/Uploads/bigadvertisement/1498529522.jpg"},{"teacher_id":"155","teacher_name":"楚威","teacher_img":"http://capp.dameiketang.com/Uploads/bigadvertisement/1500622769.jpg"},{"teacher_id":"141","teacher_name":"晴晴","teacher_img":"http://capp.dameiketang.com/Uploads/bigadvertisement/1492675472.jpg"},{"teacher_id":"140","teacher_name":"辛丹华","teacher_img":"http://capp.dameiketang.com/Uploads/bigadvertisement/1491898121.jpg"},{"teacher_id":"106","teacher_name":"张勇","teacher_img":"http://capp.dameiketang.com/Uploads/bigadvertisement/1476701381.jpg"}]
     * l : [{"name":"OBC美甲","img":"http://api.dameiketang.com/Public/obcmeijia.jpg","lesson_id":209},{"name":"OBC美发","img":"http://api.dameiketang.com/Public/obcmeifa.jpg","lesson_id":210},{"name":"半永久双线班","img":"http://api.dameiketang.com/Public/byj.jpg","lesson_id":175},{"name":"美睫双线班","img":"http://api.dameiketang.com/Public/mmj.jpg","lesson_id":173}]
     * t : 1512370048
     */

    private int i;
    private int r;
    private String m;
    private int t;
    private List<?> d;
    private List<EBean> e;
    private List<HBean> h;
    private List<CBean> c;
    private List<LBean> l;

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }

    public int getR() {
        return r;
    }

    public void setR(int r) {
        this.r = r;
    }

    public String getM() {
        return m;
    }

    public void setM(String m) {
        this.m = m;
    }

    public int getT() {
        return t;
    }

    public void setT(int t) {
        this.t = t;
    }

    public List<?> getD() {
        return d;
    }

    public void setD(List<?> d) {
        this.d = d;
    }

    public List<EBean> getE() {
        return e;
    }

    public void setE(List<EBean> e) {
        this.e = e;
    }

    public List<HBean> getH() {
        return h;
    }

    public void setH(List<HBean> h) {
        this.h = h;
    }

    public List<CBean> getC() {
        return c;
    }

    public void setC(List<CBean> c) {
        this.c = c;
    }

    public List<LBean> getL() {
        return l;
    }

    public void setL(List<LBean> l) {
        this.l = l;
    }

    public static class EBean {
        /**
         * imgurl : http://capp.dameiketang.com/Uploads/images/indexgg/59f9729a2db67.jpg
         * target : lesson://1285
         * outline : 0
         */

        private String imgurl;
        private String target;
        private String outline;

        public String getImgurl() {
            return imgurl;
        }

        public void setImgurl(String imgurl) {
            this.imgurl = imgurl;
        }

        public String getTarget() {
            return target;
        }

        public void setTarget(String target) {
            this.target = target;
        }

        public String getOutline() {
            return outline;
        }

        public void setOutline(String outline) {
            this.outline = outline;
        }
    }

    public static class HBean {
        /**
         * id : 141
         * all_time : null
         * outline : 0
         * lesson_name : 半永久定妆系统课程训练阶段
         * teacher : 半永久资深高级讲师 王娟
         * is_look : 0
         * price : 40
         * one_type_id : 4
         * small_img_url : http://capp.dameiketang.com/Uploads/smalladvertisement/1465007668.jpg
         * big_img_url : http://capp.dameiketang.com/Uploads/smalladvertisement/1465007668.jpg
         * two_type_id : 19
         */

        private String id;
        private Object all_time;
        private String outline;
        private String lesson_name;
        private String teacher;
        private String is_look;
        private String price;
        private String one_type_id;
        private String small_img_url;
        private String big_img_url;
        private String two_type_id;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public Object getAll_time() {
            return all_time;
        }

        public void setAll_time(Object all_time) {
            this.all_time = all_time;
        }

        public String getOutline() {
            return outline;
        }

        public void setOutline(String outline) {
            this.outline = outline;
        }

        public String getLesson_name() {
            return lesson_name;
        }

        public void setLesson_name(String lesson_name) {
            this.lesson_name = lesson_name;
        }

        public String getTeacher() {
            return teacher;
        }

        public void setTeacher(String teacher) {
            this.teacher = teacher;
        }

        public String getIs_look() {
            return is_look;
        }

        public void setIs_look(String is_look) {
            this.is_look = is_look;
        }

        public String getPrice() {
            return price;
        }

        public void setPrice(String price) {
            this.price = price;
        }

        public String getOne_type_id() {
            return one_type_id;
        }

        public void setOne_type_id(String one_type_id) {
            this.one_type_id = one_type_id;
        }

        public String getSmall_img_url() {
            return small_img_url;
        }

        public void setSmall_img_url(String small_img_url) {
            this.small_img_url = small_img_url;
        }

        public String getBig_img_url() {
            return big_img_url;
        }

        public void setBig_img_url(String big_img_url) {
            this.big_img_url = big_img_url;
        }

        public String getTwo_type_id() {
            return two_type_id;
        }

        public void setTwo_type_id(String two_type_id) {
            this.two_type_id = two_type_id;
        }
    }

    public static class CBean {
        /**
         * teacher_id : 121
         * teacher_name : 李汶縚
         * teacher_img : http://capp.dameiketang.com/Uploads/bigadvertisement/1479109002.jpg
         */

        private String teacher_id;
        private String teacher_name;
        private String teacher_img;

        public String getTeacher_id() {
            return teacher_id;
        }

        public void setTeacher_id(String teacher_id) {
            this.teacher_id = teacher_id;
        }

        public String getTeacher_name() {
            return teacher_name;
        }

        public void setTeacher_name(String teacher_name) {
            this.teacher_name = teacher_name;
        }

        public String getTeacher_img() {
            return teacher_img;
        }

        public void setTeacher_img(String teacher_img) {
            this.teacher_img = teacher_img;
        }
    }

    public static class LBean {
        /**
         * name : OBC美甲
         * img : http://api.dameiketang.com/Public/obcmeijia.jpg
         * lesson_id : 209
         */

        private String name;
        private String img;
        private int lesson_id;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getImg() {
            return img;
        }

        public void setImg(String img) {
            this.img = img;
        }

        public int getLesson_id() {
            return lesson_id;
        }

        public void setLesson_id(int lesson_id) {
            this.lesson_id = lesson_id;
        }
    }
}
