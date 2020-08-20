package com.example.live.fragment;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.example.commonlibrary.base.BaseMVPFragment;
import com.example.live.R;
import com.example.live.R2;
import com.example.live.bean.CpsIndexTBListBean;
import com.example.live.bean.SearchScreenBean;
import com.example.live.contract.LiveFragmentContract;
import com.example.live.presenter.LiveFragmentPresenter;

import java.util.List;

import butterknife.BindView;
import butterknife.Unbinder;


/**
 * Created by ${xinGen} on 2018/5/3 0003.
 * 博客：https://blog.csdn.net/hexingen
 */

public class LiveFragment extends BaseMVPFragment<LiveFragmentPresenter> implements LiveFragmentContract.View {

    @BindView(R2.id.tv2)
    TextView tv2;
    Unbinder unbinder;

    public static LiveFragment newInstance(String s, int position) {
        LiveFragment liveFragment = new LiveFragment();
        Bundle bundle = new Bundle();
        bundle.putString("s", s);
        bundle.putInt("position", position);
        liveFragment.setArguments(bundle);
        return liveFragment;
    }


    @Override
    public int getLayout() {
        return R.layout.live_fragment;
    }

    @Override
    protected void loadData() {
        mPresenter.getScreenList("1172861", "all", "牛肉干", 0, 0);
    }


    @Override
    protected void initInjector() {
        mPresenter = new LiveFragmentPresenter();
    }

    @Override
    public void onResponse(List<CpsIndexTBListBean> data) {
        tv2.setText(data.get(0).title);
    }

    @Override
    public void onResponseScreenList(SearchScreenBean screenBean) {
        Log.d("--loadData--",screenBean.brandList.title);
    }

    @Override
    public void onError(String error) {

    }

}
