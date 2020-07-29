package com.example.commonlibrary.evolve;

import com.example.commonlibrary.base.BaseObserver;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;

/**
 * yangyoupeng  on 2018/4/12.
 * <p>
 * 扩展类，用来调用请求网络时的进度条
 */

public abstract class ProgressObserver<T> extends BaseObserver<T> {


    @Override
    public void onSubscribe(@NonNull Disposable d) {
        if (!d.isDisposed()) {
            showProgress();
        }
    }

    @Override
    public void onComplete() {
        hideProgress();
    }


    @Override
    public void onError(@NonNull Throwable e) {
        super.onError(e);
        hideProgress();
    }

    public abstract void showProgress( );

    public abstract void hideProgress();


}
