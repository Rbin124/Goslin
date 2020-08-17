package com.example.home.contract;

import com.example.commonlibrary.base.BaseContract;
import com.example.home.bean.CpsIndexTBBean;
import com.example.home.bean.CpsIndexTBListBean;
import java.util.List;

public class HomeFragmentContract {
    public interface View extends BaseContract.BaseView {
        void onResponse(List<CpsIndexTBListBean> data);
        void onResponse2(CpsIndexTBBean data);
        void onError(String error);
    }

    public interface Presenter extends BaseContract.BasePresenter<View> {
        void request(String mid, String id, int page, int pageSize);
        void request2(String uid);
    }
}
