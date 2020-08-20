package com.example.live.contract;

import com.example.commonlibrary.base.BaseContract;
import com.example.live.bean.CpsIndexTBListBean;
import com.example.live.bean.SearchScreenBean;


import java.util.List;

public class LiveFragmentContract {
    public interface View extends BaseContract.BaseView {
        void onResponse(List<CpsIndexTBListBean> data);
        void onResponseScreenList(SearchScreenBean screenBean);
        void onError(String error);
    }

    public interface Presenter extends BaseContract.BasePresenter<View> {
        void request(String mid, String id, int page, int pageSize);
        void getScreenList(String uid,String channelId,String keyword,int sort,int sorttype);

    }
}
