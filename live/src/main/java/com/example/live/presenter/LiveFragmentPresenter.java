package com.example.live.presenter;

import android.util.ArrayMap;

import com.example.commonlibrary.base.BasePresenter;
import com.example.commonlibrary.net.manager.RetrofitManager;
import com.example.commonlibrary.rx.RxSchedulers;
import com.example.live.contract.LiveFragmentContract;
import com.example.live.net.RetrofitManagerOriginal;

import java.util.HashMap;
import java.util.Map;




public class LiveFragmentPresenter extends BasePresenter<LiveFragmentContract.View> implements LiveFragmentContract.Presenter {

    @Override
    public void request(String mid,String id,int page,int pageSize) {





    }

    @Override
    public void getScreenList(String uid, String channelId, String keyword, int sort, int sorttype) {
        Map<String, Object> map = new HashMap<>();
        map.put("mid", uid);
        map.put("channelId", channelId);
        map.put("keyword", keyword);
        map.put("channelId", channelId);
        map.put("keyword", keyword);
        map.put("sort", sort);
        map.put("sorttype", sorttype);
        RetrofitManagerOriginal.createApi().getSearchScreenList(map)
                .compose(RxSchedulers.applySchedulers())
                .compose(mView.bindToLife())
                .subscribe(bean -> {
                    if (null != bean) {
                        if (bean.getCode() == 200) {
                            mView.onResponseScreenList(bean.getData());
                        } else {
                            mView.showFail(bean.getMsg());
                        }
                    }

                }, throwable -> {
                    throwable.printStackTrace();
                });
    }

}
