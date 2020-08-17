package com.example.home.presenter;

import android.annotation.SuppressLint;

import com.example.commonlibrary.base.BasePresenter;
import com.example.commonlibrary.rx.RxSchedulers;
import com.example.home.contract.HomeFragmentContract;
import com.example.home.net.RetrofitManagerOriginal;

public class HomeFragmentPresenter extends BasePresenter<HomeFragmentContract.View> implements HomeFragmentContract.Presenter {

    @Override
    public void request(String mid,String id,int page,int pageSize) {


    }

    @SuppressLint("CheckResult")
    @Override
    public void request2(String uid) {
        RetrofitManagerOriginal.createApi().getCpsPDDIndex(uid)
                .compose(RxSchedulers.applySchedulers())
                .compose(mView.bindToLife())
                .subscribe(bean -> {
                    if (null != bean) {
                        if (bean.getCode() == 200) {
                            mView.onResponse2(bean.getData());
                        } else {
                            mView.onError(bean.getMsg());
                        }
                    }
                });
    }
}
