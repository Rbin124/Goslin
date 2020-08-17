package com.example.live.presenter;

import android.util.Log;

import com.example.commonlibrary.base.BaseObserver;
import com.example.commonlibrary.base.BasePresenter;
import com.example.commonlibrary.net.NetException;
import com.example.commonlibrary.net.manager.RetrofitManager;
import com.example.commonlibrary.rx.RxSchedulers;


import com.example.live.api.API;
import com.example.live.bean.CpsIndexTBListBean;
import com.example.live.contract.LiveFragmentContract;
import com.trello.rxlifecycle3.RxLifecycle;
import com.trello.rxlifecycle3.android.ActivityEvent;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;


public class LiveFragmentPresenter extends BasePresenter<LiveFragmentContract.View> implements LiveFragmentContract.Presenter {

    @Override
    public void request(String mid,String id,int page,int pageSize) {
//        RetrofitManager.getInstance().createApi(API.class).getPDDCategoryList(mid, id, page, pageSize)
//                .compose(RxSchedulers.applySchedulers())
//                .compose(mView.bindToLife())
//                .subscribe(bean -> {
//                    if (null != bean) {
//                        Log.d("---bean--", bean.toString());
//                    }
//
//                }, throwable -> {
//                    throwable.printStackTrace();
//                });


//        RetrofitManager.getInstance().createApi(API.class).getCpsPDDIndex(mid)
//                .compose(RxSchedulers.applySchedulers())
//                .compose(mView.bindToLife())
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .doOnSubscribe(disposable -> mView.showLoading())
//                .doFinally(() -> mView.hideLoading())
//                .subscribe(new BaseObserver<CpsIndexTBListBean>() {
//
//                    @Override
//                    public void success(CpsIndexTBListBean cpsIndexTBListBean) {
//
//                    }
//
//                    @Override
//                    public void error(NetException.ResponseException e) {
//
//                    }
//                });




    }

}
