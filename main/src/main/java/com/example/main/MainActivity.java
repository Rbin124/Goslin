package com.example.main;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.launcher.ARouter;
import com.example.commonlibrary.base.BaseActivity;
import com.example.commonlibrary.router.HomeProvider;
import com.example.commonlibrary.router.LiveProvider;
import com.example.commonlibrary.router.MessageProvider;
import com.example.commonlibrary.router.MineProvider;
import com.example.main.bean.TabEntity;
import com.flyco.tablayout.CommonTabLayout;
import com.flyco.tablayout.listener.CustomTabEntity;
import com.flyco.tablayout.listener.OnTabSelectListener;

import java.util.ArrayList;

import butterknife.BindView;

public class MainActivity extends BaseActivity {

    @BindView(R2.id.stl)
    CommonTabLayout stl;
    private ArrayList<Fragment> mFragments = new ArrayList<>();
    private ArrayList<Fragment> mFragments2 = new ArrayList<>();

    private String[] mTitles = {"首页", "消息", "联系人", "更多"};
    private int[] mIconUnselectIds = {
            R.mipmap.tab_home_unselect, R.mipmap.tab_speech_unselect,
            R.mipmap.tab_contact_unselect, R.mipmap.tab_more_unselect};
    private int[] mIconSelectIds = {
            R.mipmap.tab_home_select, R.mipmap.tab_speech_select,
            R.mipmap.tab_contact_select, R.mipmap.tab_more_select};
    private ArrayList<CustomTabEntity> mTabEntities = new ArrayList<>();
    @Autowired
    HomeProvider homeProvider;
    @Autowired
    MineProvider mineProvider;
    @Autowired
    MessageProvider messageProvider;
    @Autowired
    LiveProvider liveProvider;



    @Override
    protected int initLayout() {
        return R.layout.main_activity_main;
    }

    @Override
    protected void initView() {
        ARouter.getInstance().inject(this);
        mFragments2.add(homeProvider.createFragment());
        Bundle bundle = new Bundle();
        bundle.putString("position","我是直播夜");
        mFragments2.add(liveProvider.createFragment("我是直播夜",1));
        mFragments2.add(messageProvider.createFragment());
        mFragments2.add(mineProvider.createFragment());

        for (int i = 0; i < mTitles.length; i++) {
            mTabEntities.add(new TabEntity(mTitles[i], mIconSelectIds[i], mIconUnselectIds[i]));
        }
        stl.setTabData(mTabEntities,this,R.id.fl_content,mFragments2);

        stl.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelect(int position) {

            }

            @Override
            public void onTabReselect(int position) {

            }
        });
    }

    @Override
    protected void initData() {

    }


}
