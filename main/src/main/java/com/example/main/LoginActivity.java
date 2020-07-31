package com.example.main;


import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.example.commonlibrary.base.BaseActivity;
import com.example.main.adapter.SplashAdapter;
import com.example.main.view.ScollLinearLayoutManager;
import butterknife.BindView;


@Route(path = "/main/login")
public class LoginActivity extends BaseActivity {


    @BindView(R2.id.mRecyclerView)
    RecyclerView mRecyclerView;

    @Override
    protected int initLayout() {
        return R.layout.main_activity_login;
    }

    @Override
    protected void initView() {
        mRecyclerView = findViewById(R.id.mRecyclerView);
        mRecyclerView.setAdapter(new SplashAdapter(this));
        mRecyclerView.setLayoutManager(new ScollLinearLayoutManager(this));

        //smoothScrollToPosition滚动到某个位置（有滚动效果）
        mRecyclerView.smoothScrollToPosition(Integer.MAX_VALUE / 2);
    }

    @Override
    protected void initData() {

    }
}
