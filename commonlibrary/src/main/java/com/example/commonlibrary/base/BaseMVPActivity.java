package com.example.commonlibrary.base;

import android.os.Bundle;

import androidx.annotation.Nullable;

import com.trello.rxlifecycle3.LifecycleTransformer;
import com.trello.rxlifecycle3.android.ActivityEvent;


/**
 * Created by Android Studio.
 * User: Village
 * Date: 2020/6/18
 * Time: 2:05 PM
 */
public abstract class BaseMVPActivity<T extends BaseContract.BasePresenter> extends BaseActivity implements BaseContract.BaseView {

    @Nullable
    protected T mPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initInjector();
        attachView();
        initView();
    }

    /**
     * 贴上view
     */
    private void attachView() {
        if (mPresenter != null) {
            mPresenter.attachView(this);
        }
    }

    /**
     * 分离view
     */
    protected void detachView() {
        if (mPresenter != null) {
            mPresenter.detachView();
        }
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void showSuccess(String message) {

    }

    @Override
    public void showFail(String message) {

    }

    @Override
    public <T> LifecycleTransformer<T> bindToLife() {
        // 在Activity销毁的时候 取消订阅。
        return bindUntilEvent(ActivityEvent.DESTROY);
    }

    /**
     * 初始化注入
     * 如：mPresenter初始化
     */
    protected abstract void initInjector();

}

