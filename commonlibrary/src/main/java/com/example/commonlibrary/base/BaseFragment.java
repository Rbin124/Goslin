package com.example.commonlibrary.base;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by ${xinGen} on 2018/5/3 0003.
 * 博客：https://blog.csdn.net/hexingen
 */

public abstract class BaseFragment extends LazyLoadFragment {

    private Unbinder unbinder;
    private View rootView;
    protected Activity mActivity;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (rootView == null) {
            rootView = inflater.inflate(getLayout(), container, false);
            unbinder = ButterKnife.bind(this, rootView);
            initView(rootView);
            initData();
            initListener();
        } else {
            ViewGroup parent = (ViewGroup) rootView.getParent();
            if (parent != null) {
                parent.removeView(rootView);
            }
        }
        return rootView;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mActivity = (Activity) context;
    }

    /**
     * 初始化数据
     */
    public void initView(View rootView) {

    }

    /**
     * 初始化数据
     */
    public void initData() {

    }

    /**
     * 设置listener的操作
     */
    public void initListener() {

    }

    @Override
    protected void onFragmentFirstVisible() {
        //当第一次可见的时候，加载数据
        loadData();
    }

    //得到当前界面的布局文件id(由子类实现)
    protected abstract int getLayout();

    //加载数据
    protected abstract void loadData();

    @Override
    public void onDestroy() {
        super.onDestroy();
        try {
            unbinder.unbind();
        }catch (Exception e){
            e.printStackTrace();
        }
        rootView = null;
    }
}
