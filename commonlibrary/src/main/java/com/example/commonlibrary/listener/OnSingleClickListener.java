package com.example.commonlibrary.listener;

import android.view.View;

public abstract class OnSingleClickListener implements View.OnClickListener {
    //两次点击按钮之间的间隔，目前为1000ms
    private static final int MIN_CLICK_DELAY_TIME = 1000;
    private long lastClickTime;

    public abstract void onSingleClick(View view);

    @Override
    public void onClick(View view) {
        long curClickTime = System.currentTimeMillis();
        if ((curClickTime - lastClickTime) >= MIN_CLICK_DELAY_TIME) {
            lastClickTime = curClickTime;
            onSingleClick(view);
        }
    }
}
