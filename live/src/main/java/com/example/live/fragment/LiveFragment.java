package com.example.live.fragment;

import android.os.Bundle;
import com.example.commonlibrary.base.BaseFragment;
import com.example.live.R;


/**
 * Created by ${xinGen} on 2018/5/3 0003.
 * 博客：https://blog.csdn.net/hexingen
 */

public class LiveFragment extends BaseFragment {

    public static LiveFragment newInstance(String s, int position){
        LiveFragment liveFragment = new LiveFragment();
        Bundle bundle = new Bundle();
        bundle.putString("s",s);
        bundle.putInt("position",position);
        liveFragment.setArguments(bundle);
        return liveFragment;
    }
    @Override
    public void init(Bundle savedInstanceState) {
        Bundle arguments = getArguments();
        String s = arguments.getString("s");
        int position = arguments.getInt("position");
    }

    @Override
    public int getLayout() {
        return R.layout.live_fragment;
    }


}
