package com.example.live.bean;



import java.util.List;

public class CpsIndexTBBean {


    /**
     * code : 200
     * msg : 成功
     * data : {"bannerData":[{"image_url":"http://t16img.yangkeduo.com/pdd_oms/2020-03-11/6aca3f437933d29eccb1691f6dab85a5.jpg","name":"拼多多会员充值日","goods_num":12,"id":7603},{"image_url":"http://t16img.yangkeduo.com/pdd_oms/2020-03-06/b372139b11c2caf91d1280d3a228b683.jpg","name":"38福女节专场","goods_num":41,"id":7600},{"image_url":"http://t16img.yangkeduo.com/pdd_oms/2020-03-06/a26ed01950b56a0a601f9fe1105842e7.png","name":"9.9元包邮专场","goods_num":79,"id":7602}],"classData":[{"parent_opt_id":0,"level":1,"opt_name":"精选","opt_id":8569},{"parent_opt_id":0,"level":1,"opt_name":"百货","opt_id":15},{"parent_opt_id":0,"level":1,"opt_name":"母婴","opt_id":4},{"parent_opt_id":0,"level":1,"opt_name":"食品","opt_id":1},{"parent_opt_id":0,"level":1,"opt_name":"女装","opt_id":14},{"parent_opt_id":0,"level":1,"opt_name":"男装","opt_id":743},{"parent_opt_id":0,"level":1,"opt_name":"美妆","opt_id":16},{"parent_opt_id":0,"level":1,"opt_name":"鞋包","opt_id":1281},{"parent_opt_id":0,"level":1,"opt_name":"内衣","opt_id":1282},{"parent_opt_id":0,"level":1,"opt_name":"电器","opt_id":18},{"parent_opt_id":0,"level":1,"opt_name":"水果","opt_id":13},{"parent_opt_id":0,"level":1,"opt_name":"家纺","opt_id":818},{"parent_opt_id":0,"level":1,"opt_name":"运动","opt_id":1451},{"parent_opt_id":0,"level":1,"opt_name":"数码","opt_id":3162}]}
     */

    private String code;
    private String msg;
    private DataBean data;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        private List<BannerDataBean> bannerData;
        private List<ClassDataBean> classData;

        public List<BannerDataBean> getBannerData() {
            return bannerData;
        }

        public void setBannerData(List<BannerDataBean> bannerData) {
            this.bannerData = bannerData;
        }

        public List<ClassDataBean> getClassData() {
            return classData;
        }

        public void setClassData(List<ClassDataBean> classData) {
            this.classData = classData;
        }

        public static class BannerDataBean {
            /**
             * image_url : http://t16img.yangkeduo.com/pdd_oms/2020-03-11/6aca3f437933d29eccb1691f6dab85a5.jpg
             * name : 拼多多会员充值日
             * goods_num : 12
             * id : 7603
             */

            private String image_url;
            private String name;
            private int goods_num;
            private int id;

            public String getImage_url() {
                return image_url;
            }

            public void setImage_url(String image_url) {
                this.image_url = image_url;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public int getGoods_num() {
                return goods_num;
            }

            public void setGoods_num(int goods_num) {
                this.goods_num = goods_num;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }
        }

        public static class ClassDataBean {
            /**
             * parent_opt_id : 0
             * level : 1
             * opt_name : 精选
             * opt_id : 8569
             */

            private int parent_opt_id;
            private int level;
            private String opt_name;
            private int opt_id;

            public int getParent_opt_id() {
                return parent_opt_id;
            }

            public void setParent_opt_id(int parent_opt_id) {
                this.parent_opt_id = parent_opt_id;
            }

            public int getLevel() {
                return level;
            }

            public void setLevel(int level) {
                this.level = level;
            }

            public String getOpt_name() {
                return opt_name;
            }

            public void setOpt_name(String opt_name) {
                this.opt_name = opt_name;
            }

            public int getOpt_id() {
                return opt_id;
            }

            public void setOpt_id(int opt_id) {
                this.opt_id = opt_id;
            }
        }
    }
}
