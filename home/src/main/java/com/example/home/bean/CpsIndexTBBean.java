package com.example.home.bean;



import java.util.List;

public class CpsIndexTBBean {


    
        public List<BannerDataBean> bannerData;
        public List<ClassDataBean> classData;

        

        public static class BannerDataBean {
            /**
             * image_url : http://t16img.yangkeduo.com/pdd_oms/2020-03-11/6aca3f437933d29eccb1691f6dab85a5.jpg
             * name : 拼多多会员充值日
             * goods_num : 12
             * id : 7603
             */

            public String image_url;
            public String name;
            public int goods_num;
            public int id;

            
        }

        public static class ClassDataBean {
            /**
             * parent_opt_id : 0
             * level : 1
             * opt_name : 精选
             * opt_id : 8569
             */

            public int parent_opt_id;
            public int level;
            public String opt_name;
            public int opt_id;

            
        }
    
}
