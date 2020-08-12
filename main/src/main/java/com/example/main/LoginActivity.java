package com.example.main;


import android.content.Intent;
import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.example.commonlibrary.base.BaseActivity;
import com.example.commonlibrary.listener.OnSingleClickListener;
import com.example.main.adapter.SplashAdapter;
import com.example.main.view.ScollLinearLayoutManager;
import butterknife.BindView;


@Route(path = "/main/login")
public class LoginActivity extends BaseActivity {
    @BindView(R2.id.mRecyclerView)
    RecyclerView mRecyclerView;
    @BindView(R2.id.tv_regist)
    TextView tvRegist;
    @BindView(R2.id.tv_login)
    TextView tvLogin;

    @Override
    protected int initLayout() {
        return R.layout.main_activity_login;
    }

    @Override
    protected void initView() {
        mRecyclerView.setAdapter(new SplashAdapter(this));
        mRecyclerView.setLayoutManager(new ScollLinearLayoutManager(this));

        //smoothScrollToPosition滚动到某个位置（有滚动效果）
        mRecyclerView.smoothScrollToPosition(Integer.MAX_VALUE / 2);
        tvLogin.setOnClickListener(new OnSingleClickListener() {
            @Override
            public void onSingleClick(View view) {
                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void initData() {

    }
}
