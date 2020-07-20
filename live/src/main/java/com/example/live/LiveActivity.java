package com.example.live;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.example.commonlibrary.base.BaseActivity;
import com.example.live.bean.PublicAccountBean;
import com.example.live.contract.MainContract;

import butterknife.BindView;
import butterknife.ButterKnife;

@Route(path = "/live/list")
public class LiveActivity extends BaseActivity<MainContract.Prensenter> implements MainContract.IView {
    @BindView(R2.id.tv)
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_live);
        ButterKnife.bind(this);
        Log.d("---BUID---",BuildConfig.API_HOST);
        mPresenter.getPublicAccountList();
    }

    @Override
    public MainContract.Prensenter createPresenter() {
        return new MainContract.Prensenter(this);
    }

    @Override
    public void doSomething(PublicAccountBean publicAccountBean) {
        Log.d("======Loading======", "======doSomething=====");
        tv.setText(publicAccountBean.getData().get(0).getName());
    }


    @Override
    public void showMsg(String msg) {

    }
}
