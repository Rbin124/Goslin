package com.example.live.router;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.example.commonlibrary.router.LiveProvider;
import com.example.commonlibrary.router.RouterPath;
import com.example.live.fragment.LiveFragment;


/**
 * Created by ${xinGen} on 2018/5/4 0004.
 * 博客：https://blog.csdn.net/hexingen
 */
@Route(path = RouterPath.PATH_FRAGMENT_LIVE)
public class LiveProviderImpl implements LiveProvider {

    @Override
    public Fragment createFragment(String s,int position) {
        return LiveFragment.newInstance(s,position);
    }

    @Override
    public void init(Context context) {

    }
}
