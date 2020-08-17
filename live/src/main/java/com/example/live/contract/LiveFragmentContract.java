package com.example.live.contract;

import com.example.commonlibrary.base.BaseContract;
import com.example.live.bean.CpsIndexTBListBean;


import java.util.List;

public class LiveFragmentContract {
    public interface View extends BaseContract.BaseView {
        void onResponse(List<CpsIndexTBListBean> data);
        void onError(String error);
    }

    public interface Presenter extends BaseContract.BasePresenter<View> {
        void request(String mid, String id, int page, int pageSize);
    }
}
