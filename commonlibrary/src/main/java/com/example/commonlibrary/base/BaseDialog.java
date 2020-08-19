package com.example.commonlibrary.base;

import android.content.Context;
import android.content.res.Resources;
import android.view.KeyEvent;
import android.view.View;

import com.afollestad.materialdialogs.MaterialDialog;

/**
 * author : Chengxiaolin
 * e-mail : robin125@sina.cn
 * date   : 2019/12/8  17:01
 * desc   :
 * version: 1.0
 */
public class BaseDialog extends MaterialDialog {

    private Resources resources;
    private View view;

    public BaseDialog(Context context, int layoutId) {
        super(new Builder(context).customView(layoutId, false));
        view = getCustomView();
        resources = context.getResources();
    }

    protected View view() {
        return view;
    }

    protected void setWindow(int gravity, int width, int height, boolean cancel) {
        setWindow(gravity, width, height, cancel, android.R.color.transparent);
    }

    protected void setWindow(int gravity, int width, int height, boolean cancel, int color) {
        setCancelable(cancel);
        setCanceledOnTouchOutside(cancel);
        if (null != getWindow()) {
            getWindow().setLayout(width, height);
            getWindow().setGravity(gravity);
            getWindow().setBackgroundDrawableResource(color);
        }
    }

    protected void backNoDismiss() {
        setOnKeyListener((dialog, keyCode, event) -> keyCode == KeyEvent.KEYCODE_BACK);
    }

    protected int getDimension(int dimen) {
        return (int) resources.getDimension(dimen);
    }
}
