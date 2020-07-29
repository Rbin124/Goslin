package com.example.commonlibrary.base;

import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;
import com.trello.rxlifecycle2.android.ActivityEvent;
import com.trello.rxlifecycle2.components.support.RxAppCompatActivity;
import io.reactivex.subjects.BehaviorSubject;

public abstract class BaseActivity<T extends BasePresenter> extends RxAppCompatActivity implements BaseView {
    //RxLifecycle对象，每个Activity 调用onDestroy时用来取消观察者的订阅。
    private final BehaviorSubject<ActivityEvent> lifecycleSubject = BehaviorSubject.create();
    //Presanter，继承自BasePresenter。
    protected T mPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //构建该Activity的Presenter对象。
        mPresenter = createPresenter();
    }

    public abstract T createPresenter();

    @SuppressWarnings("unchecked")
    @Override
    public final BehaviorSubject getLifeCycleSubject() {
        return lifecycleSubject;
    }


}
