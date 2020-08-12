package com.example.home.router;

import android.content.Context;
import androidx.fragment.app.Fragment;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.example.commonlibrary.router.HomeProvider;
import com.example.commonlibrary.router.RouterPath;
import com.example.home.fragment.HomeFragment;

/**
 * Created by ${xinGen} on 2018/5/4 0004.
 * 博客：https://blog.csdn.net/hexingen
 */
@Route(path = RouterPath.PATH_FRAGMENT_HOME)
public class HomeProviderImpl implements HomeProvider {

    @Override
    public Fragment createFragment() {
        return HomeFragment.newInstance();
    }

    @Override
    public void init(Context context) {

    }
}
