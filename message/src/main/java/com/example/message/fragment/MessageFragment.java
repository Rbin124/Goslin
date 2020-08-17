package com.example.message.fragment;

import android.util.Log;

import com.example.commonlibrary.base.BaseFragment;
import com.example.message.R;

/**
 * Created by ${xinGen} on 2018/5/3 0003.
 * 博客：https://blog.csdn.net/hexingen
 */

public class MessageFragment extends BaseFragment {

    public static MessageFragment newInstance(){
        return new MessageFragment();
    }

    @Override
    public int getLayout() {
        return R.layout.message_fragment;
    }

    @Override
    protected void loadData() {
        Log.d("--loadData--","--MessageFragment--");
    }

    @Override
    protected void onFragmentVisibleChange(boolean isVisible) {
        Log.d("-onChange-",isVisible + "");
    }
}
