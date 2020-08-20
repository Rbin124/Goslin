package com.example.live.bean;

import java.util.List;

public class SearchScreenBean {

    /**
     * priceList : {"title":"in sunt nostrud labore","item":[{"min":-8.855265108526416E7,"max":843612.1914249063},{"min":1.7983981785077408E7,"max":-3140064.618686989},{"min":-1.99525682314142E7,"max":-6.836567051610264E7},{"min":8786708.882751524,"max":7.846843043484572E7}]}
     * brandList : {"title":"velit adipisicing","item":[{"brandId":"cupidatat quis","brandName":"ut consequat"},{"brandId":"velit","brandName":"sit enim"},{"brandId":"Lorem ea mollit aliquip","brandName":"dolor adipisicing elit"},{"brandId":"nulla velit quis voluptate","brandName":"dolore"}]}
     * categoryList : {"title":"eu aute","item":[{"categoryThreeId":"voluptate Ut ut","categoryThreeName":"adipisicing"},{"categoryThreeId":"aute ut ipsum enim","categoryThreeName":"in"}]}
     * channelList : {"title":"sint in ipsum","item":[{"channelId":"commodo ut ipsum cupidatat","channelName":"reprehenderit enim"},{"channelId":"incididunt officia commodo","channelName":"ipsum ad"},{"channelId":"dolore","channelName":"ipsum labore deserunt mollit Ut"},{"channelId":"ut ut","channelName":"Duis enim ea minim"},{"channelId":"minim mollit","channelName":"Duis sunt"}]}
     */

    public PriceListBean priceList;
    public BrandListBean brandList;
    public CategoryListBean categoryList;
    public ChannelListBean channelList;


    public static class PriceListBean {
        /**
         * title : in sunt nostrud labore
         * item : [{"min":-8.855265108526416E7,"max":843612.1914249063},{"min":1.7983981785077408E7,"max":-3140064.618686989},{"min":-1.99525682314142E7,"max":-6.836567051610264E7},{"min":8786708.882751524,"max":7.846843043484572E7}]
         */

        public String title;
        public List<ItemBean> item;


        public static class ItemBean {
            /**
             * min : -8.855265108526416E7
             * max : 843612.1914249063
             */

            public String min;
            public String max;
            public boolean isSelect;


        }
    }

    public static class BrandListBean {
        /**
         * title : velit adipisicing
         * item : [{"brandId":"cupidatat quis","brandName":"ut consequat"},{"brandId":"velit","brandName":"sit enim"},{"brandId":"Lorem ea mollit aliquip","brandName":"dolor adipisicing elit"},{"brandId":"nulla velit quis voluptate","brandName":"dolore"}]
         */

        public String title;
        public List<ItemBeanX> item;


        public static class ItemBeanX {
            /**
             * brandId : cupidatat quis
             * brandName : ut consequat
             */

            public String brandId;
            public String brandName;
            public boolean isSelect;


        }
    }

    public static class CategoryListBean {
        /**
         * title : eu aute
         * item : [{"categoryThreeId":"voluptate Ut ut","categoryThreeName":"adipisicing"},{"categoryThreeId":"aute ut ipsum enim","categoryThreeName":"in"}]
         */

        public String title;
        public List<ItemBeanXX> item;


        public static class ItemBeanXX {
            /**
             * categoryThreeId : voluptate Ut ut
             * categoryThreeName : adipisicing
             */

            public String categoryThreeId;
            public String categoryThreeName;
            public boolean isSelect;
        }
    }

    public static class ChannelListBean {
        /**
         * title : sint in ipsum
         * item : [{"channelId":"commodo ut ipsum cupidatat","channelName":"reprehenderit enim"},{"channelId":"incididunt officia commodo","channelName":"ipsum ad"},{"channelId":"dolore","channelName":"ipsum labore deserunt mollit Ut"},{"channelId":"ut ut","channelName":"Duis enim ea minim"},{"channelId":"minim mollit","channelName":"Duis sunt"}]
         */

        public String title;
        public List<ItemBeanXXX> item;


        public static class ItemBeanXXX {
            /**
             * channelId : commodo ut ipsum cupidatat
             * channelName : reprehenderit enim
             */

            public String channelId;
            public String channelName;
            public boolean isSelect;

        }

    }
}
