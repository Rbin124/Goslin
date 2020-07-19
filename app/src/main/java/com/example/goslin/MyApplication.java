package com.example.goslin;

import com.alibaba.android.arouter.launcher.ARouter;
import com.example.commonlibrary.base.BaseApplication;

public class MyApplication extends BaseApplication {

    @Override
    public void onCreate() {
        super.onCreate();
        //       if (BuildConfig.DEBUG) {
        //一定要在ARouter.init之前调用openDebug
        ARouter.openDebug();
        ARouter.openLog();
        ARouter.init(this);
    }


}
