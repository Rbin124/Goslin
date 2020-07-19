package com.example.commonlibrary.base;


public abstract class BasePresenter<V extends BaseView> {
    protected V mView;

    public BasePresenter(V mView) {
        this.mView = mView;
    }
}
