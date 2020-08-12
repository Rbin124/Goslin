package com.example.commonlibrary.router;



import androidx.fragment.app.Fragment;

import com.alibaba.android.arouter.facade.template.IProvider;

/**
 * Created by ${xinGen} on 2018/5/3 0003.
 * 博客：https://blog.csdn.net/hexingen
 */

public interface HomeProvider extends IProvider{
    Fragment createFragment();
}
