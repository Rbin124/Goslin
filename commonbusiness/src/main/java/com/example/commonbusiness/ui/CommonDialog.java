package com.example.commonbusiness.ui;

import android.content.Context;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.TextView;
import com.example.commonbusiness.R;
import com.example.commonlibrary.base.BaseDialog;


/**
 * author : Chengxiaolin
 * e-mail : robin125@sina.cn
 * date   : 2019/12/8  17:05
 * version: 1.0
 */
public class CommonDialog extends BaseDialog {

    private DialogListener dialogListener;

    public CommonDialog(Context context, int layoutId, DialogListener listener) {
        super(context, layoutId);
        setWindow(Gravity.BOTTOM, ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT, true);
        if (null != getCustomView()) {
            TextView viewById = getCustomView().findViewById(R.id.tv_title);
            viewById.setText("我是公用的dialog");
        }
    }

    private void setCommonDialogListener(DialogListener listener) {
        this.dialogListener = listener;
    }

    public interface DialogListener {
        void dialogSureCallBack(int type);
    }

    public static void show(Context context, DialogListener listener) {
        CommonDialog layer = new CommonDialog(context, R.layout.business_dialog_common, listener);
        layer.setCommonDialogListener(listener);
        if (!layer.isShowing())
            layer.show();
    }
}
