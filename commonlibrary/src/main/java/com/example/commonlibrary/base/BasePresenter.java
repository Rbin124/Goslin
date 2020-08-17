package com.example.commonlibrary.base;



/**
 * Created by Android Studio.
 * User: apple
 * Date: 2020/6/19
 * Time: 3:06 PM
 */
public class BasePresenter<T extends BaseContract.BaseView> implements BaseContract.BasePresenter<T> {

    protected T mView;

    @Override
    public <T1 extends BaseContract.BaseView> void attachView(T1 view) {
        this.mView = (T) view;
    }

    @Override
    public void detachView() {
        if (mView != null) {
            mView = null;
        }
    }
}