package com.example.mine.fragment;



import android.util.Log;

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
    public int getLayout() {
        return R.layout.mine_fragment;
    }

    @Override
    protected void loadData() {
        Log.d("--loadData--","--MineFragment--");
    }
}
