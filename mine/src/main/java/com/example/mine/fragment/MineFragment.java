package com.example.mine.fragment;

import android.os.Bundle;

import com.example.commonlibrary.base.BaseFragment;
import com.example.mine.R;


/**
 * Created by ${xinGen} on 2018/5/3 0003.
 * 博客：https://blog.csdn.net/hexingen
 */

public class MineFragment extends BaseFragment {

    public static MineFragment newInstance(){
        return new MineFragment();
    }
    @Override
    public void init(Bundle savedInstanceState) {

    }

    @Override
    public int getLayout() {
        return R.layout.mine_fragment;
    }


}
