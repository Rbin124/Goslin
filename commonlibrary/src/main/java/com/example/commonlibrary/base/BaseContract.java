package com.example.commonlibrary.base;

import com.trello.rxlifecycle3.LifecycleTransformer;

public interface BaseContract{

    interface BasePresenter<T extends BaseView> {

        /**
         * 贴上view
         */
        <T extends BaseView> void attachView(T view);

        /**
         * 分离view
         */
        void detachView();

    }

    interface BaseView {

        /**
         * 显示进度中
         */
        void showLoading();

        /**
         * 隐藏进度
         */
        void hideLoading();

        /**
         * 显示请求成功
         */
        void showSuccess(String message);

        /**
         * 失败重试
         */
        void showFail(String message);

        /**
         * 绑定生命周期
         * @return
         */
        <T> LifecycleTransformer<T> bindToLife();

        /**
         * 跳转登录
         */
        //void startLoginActivity();
    }
}
