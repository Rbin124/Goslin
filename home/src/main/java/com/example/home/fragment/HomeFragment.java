package com.example.home.fragment;


import android.util.Log;
import android.widget.TextView;

import com.example.commonbusiness.pay.PayListenerUtils;
import com.example.commonbusiness.pay.PayResultListener;
import com.example.commonbusiness.pay.PayUtils;
import com.example.commonlibrary.base.BaseMVPFragment;
import com.example.home.R;
import com.example.home.R2;
import com.example.home.bean.CpsIndexTBBean;
import com.example.home.bean.CpsIndexTBListBean;
import com.example.home.contract.HomeFragmentContract;
import com.example.home.presenter.HomeFragmentPresenter;

import java.util.List;

import butterknife.BindView;


/**
 * Created by ${xinGen} on 2018/5/3 0003.
 * 博客：https://blog.csdn.net/hexingen
 */

public class HomeFragment extends BaseMVPFragment<HomeFragmentPresenter> implements HomeFragmentContract.View, PayResultListener {


    @BindView(R2.id.tv2)
    TextView tv2;

    public static HomeFragment newInstance() {
        HomeFragment homeFragment = new HomeFragment();
        return homeFragment;
    }

    @Override
    public int getLayout() {
        return R.layout.home_fragment;
    }

    @Override
    protected void loadData() {
        PayListenerUtils.getInstance().addListener(this);
        tv2.setOnClickListener(v -> PayUtils.getInstance().toWXPay(""));

        mPresenter.request2("1172861");
//        CommonDialog.show(mActivity,null);
    }


    @Override
    protected void initInjector() {
        mPresenter = new HomeFragmentPresenter();
    }

    @Override
    public void onResponse(List<CpsIndexTBListBean> data) {
    }

    @Override
    public void onResponse2(CpsIndexTBBean data) {
        tv2.setText(data.bannerData.get(0).name);
    }

    @Override
    public void onError(String error) {

    }

    @Override
    public void showLoading() {
        super.showLoading();
    }

    @Override
    public void onPaySuccess() {
        Log.d("--pay--","onPaySuccess");
    }

    @Override
    public void onPayError() {
        Log.d("--pay--","onPayError");
    }

    @Override
    public void onPayCancel() {
        Log.d("--pay--","onPayCancel");

    }
}
