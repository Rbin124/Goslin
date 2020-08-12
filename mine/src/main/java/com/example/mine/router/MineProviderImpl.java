package com.example.mine.router;

import android.content.Context;

import androidx.fragment.app.Fragment;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.example.commonlibrary.router.MineProvider;
import com.example.commonlibrary.router.RouterPath;
import com.example.mine.fragment.MineFragment;


/**
 * Created by ${xinGen} on 2018/5/4 0004.
 * 博客：https://blog.csdn.net/hexingen
 */
@Route(path = RouterPath.PATH_FRAGMENT_MINE)
public class MineProviderImpl implements MineProvider {

    @Override
    public Fragment createFragment() {
        return MineFragment.newInstance();
    }

    @Override
    public void init(Context context) {

    }
}
