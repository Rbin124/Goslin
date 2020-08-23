package com.example.goslin.wxapi;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.example.commonbusiness.pay.PayListenerUtils;
import com.tencent.mm.opensdk.constants.ConstantsAPI;
import com.tencent.mm.opensdk.modelbase.BaseReq;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.IWXAPIEventHandler;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;


public class WXPayEntryActivity extends Activity implements IWXAPIEventHandler {

    private IWXAPI api;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        api = WXAPIFactory.createWXAPI(this, "wxc662b914c8069214");//你的APPID
        api.handleIntent(getIntent(), this);
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
        api.handleIntent(intent, this);
    }


    @Override
    public void onResp(BaseResp baseResp) {
        if (baseResp.getType() == ConstantsAPI.COMMAND_PAY_BY_WX) {
            switch (baseResp.errCode) {
                case 0:
                    //成功
                    PayListenerUtils.getInstance().paySuccess();
                    break;
                case -1:
                    //失败
                    PayListenerUtils.getInstance().payError();
                    break;
                case -2:
                    //用户取消
                    PayListenerUtils.getInstance().payCancel();
                    break;
            }
            finish();
        }
    }

    @Override
    public void onReq(BaseReq baseReq) {

    }
}