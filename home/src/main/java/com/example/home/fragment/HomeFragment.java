package com.example.home.fragment;

import android.os.Bundle;

import com.example.commonlibrary.base.BaseFragment;
import com.example.home.R;


/**
 * Created by ${xinGen} on 2018/5/3 0003.
 * 博客：https://blog.csdn.net/hexingen
 */

public class HomeFragment extends BaseFragment {

    public static HomeFragment newInstance(){
        HomeFragment homeFragment = new HomeFragment();
        return homeFragment;
    }
    @Override
    public void init(Bundle savedInstanceState) {

    }

    @Override
    public int getLayout() {
        return R.layout.home_fragment;
    }


}
