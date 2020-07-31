package com.example.live;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.classic.common.MultipleStatusView;
import com.example.commonlibrary.base.BaseMvpActivity;
import com.example.live.bean.CpsIndexTBBean;
import com.example.live.bean.PublicAccountBean;
import com.example.live.contract.MainContract;

import butterknife.BindView;
import butterknife.ButterKnife;

@Route(path = "/live/list")
public class LiveActivity extends BaseMvpActivity<MainContract.Prensenter> implements MainContract.IView {


    @BindView(R2.id.tv2)
    TextView tv2;
    MultipleStatusView simple;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_live);
        ButterKnife.bind(this);
    }

    @Override
    protected int initLayout() {
        return R.layout.activity_live;
    }

    @Override
    protected void initView() {
        simple = findViewById(R.id.simple);
    }

    @Override
    protected void initData() {
        mPresenter.getCpsPDDIndex("1172861");
    }

    @Override
    public MainContract.Prensenter createPresenter() {
        return new MainContract.Prensenter(this);
    }

    @Override
    public void doSomething(PublicAccountBean publicAccountBean) {
        Log.d("======Loading======", "======doSomething=====");
        tv2.setText(publicAccountBean.getData().get(0).getName());
    }

    @Override
    public void doSomething2(CpsIndexTBBean publicAccountBean) {
        tv2.setText(publicAccountBean.getData().getBannerData().get(0).getImage_url());
    }


    @Override
    public void showMsg(String msg) {

    }

    @Override
    public void showLoading() {
        simple.showLoading();
    }

    @Override
    public void hideLoading() {
        simple.showNoNetwork();
    }
}
