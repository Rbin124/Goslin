package com.example.commonbusiness.pay;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Toast;

import com.alipay.sdk.app.PayTask;
import com.tencent.mm.opensdk.modelpay.PayReq;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;

import java.util.Map;

public class PayUtils {
    private static String TAG = PayUtils.class.getSimpleName();

    /**
     * 支付类型
     */
    private static final int PAY_TYPE_WX = 1;
    private static final int PAY_TYPE_ALI = 2;
    /**
     * 支付宝返回参数
     */
    private final static int SDK_PAY_FLAG = 1001;

    private static PayUtils instance;
    private static Context mContext;
    private static Activity mActivity;

    private PayUtils() {
    }

    public static PayUtils getInstance(Context context) {
        if (instance == null) {
            instance = new PayUtils();
        }
        mContext = context;
        mActivity = (Activity) mContext;
        return instance;
    }

    public static void pay(int payType, String result) {
        switch (payType) {
            case PAY_TYPE_WX:
                //微信
                toWXPay(result);
                break;
            //
            case PAY_TYPE_ALI:
                toAliPay(result);
                break;
        }
    }


    /**
     * 微信支付
     *
     * @param result
     */
    private static void toWXPay(String result) {
        //微信支付api
        IWXAPI iwxapi = WXAPIFactory.createWXAPI(mContext, null); //初始化微信api
        iwxapi.registerApp("appid"); //注册appid  appid可以在开发平台获取
        //result中是重服务器请求到的签名后各个字符串，可自定义
        //result是服务器返回结果
        PayReq request = new PayReq();
        request.appId = "wxfe2fa2f264353d7d3";
        request.partnerId = "1494934532";
        request.prepayId = "wx201802011023453926020588351720";
        request.packageValue = "Sign=WXPay";
        request.nonceStr = "4cdCo3o4453xhGPpv";
        request.timeStamp = System.currentTimeMillis() / 1000 + "";
        request.sign = "F8A42CF827345377A34646ADD9E321FAB4";
        iwxapi.sendReq(request);
    }


    /**
     * 支付宝
     */
    private static void toAliPay(String result) {
        //result中是重服务器请求到的签名后字符串,赋值，此处随便写的
        final String orderInfo = "app_id=2015052600090779&biz_content=%7B%22timeout_express%22%3A%2230m%22%2C%22seller_id%22%3A%22%22%2C%22product_code%22%3A%22QUICK_MSECURITY_PAY%22%2C%22total_amount%22%3A%220.02%22%2C%22subject%22%3A%221%22%2C%22body%22%3A%22%E6%88%91%E6%98%AF%E6%B5%8B%E8%AF%95%E6%95%B0%E6%8D%AE%22%2C%22out_trade_no%22%3A%22314VYGIAGG7ZOYY%22%7D&charset=utf-8&method=alipay.trade.app.pay&sign_type=RSA2&timestamp=2016-08-15%2012%3A12%3A15&version=1.0&sign=MsbylYkCzlfYLy9PeRwUUIg9nZPeN9SfXPNavUCroGKR5Kqvx0nEnd3eRmKxJuthNUx4ERCXe552EV9PfwexqW%2B1wbKOdYtDIb4%2B7PL3Pc94RZL0zKaWcaY3tSL89%2FuAVUsQuFqEJdhIukuKygrXucvejOUgTCfoUdwTi7z%2BZzQ%3D";   // 订单信息
        Runnable payRunnable = new Runnable() {

            @Override
            public void run() {
                PayTask alipay = new PayTask(mActivity);
                Map<String, String> result = alipay.payV2(orderInfo, true);
                Message msg = new Message();
                msg.what = SDK_PAY_FLAG;
                msg.obj = result;
                mHandler.sendMessage(msg);
                Log.i(TAG, "aliresult--->" + result);
            }
        };
        // 必须异步调用
        Thread payThread = new Thread(payRunnable);
        payThread.start();
    }

    /**
     * 支付宝状态
     * 9000 订单支付成功
     * 8000 正在处理中，支付结果未知（有可能已经支付成功），请查询商户订单列表中订单的支付状态
     * 4000 订单支付失败
     * 5000 重复请求
     * 6001 用户中途取消
     * 6002 网络连接出错
     * 6004 支付结果未知（有可能已经支付成功），请查询商户订单列表中订单的支付状态
     * 其它   其它支付错误
     */
    private static Handler mHandler = new Handler() {
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case SDK_PAY_FLAG: {
                    PayResult payResult = new PayResult((Map<String, String>) msg.obj);
                    /**
                     对于支付结果，请商户依赖服务端的异步通知结果。同步通知结果，仅作为支付结束的通知。
                     */
                    String resultInfo = payResult.getResult();// 同步返回需要验证的信息
                    String resultStatus = payResult.getResultStatus();
                    // 判断resultStatus 为9000则代表支付成功
                    if (TextUtils.equals(resultStatus, "9000")) {
                        // 该笔订单是否真实支付成功，需要依赖服务端的异步通知。
                        showMessage("支付成功");
                        PayListenerUtils.getInstance(mContext).addSuccess();
                    } else if (TextUtils.equals(resultStatus, "6001")) {
                        // 该笔订单是否真实支付成功，需要依赖服务端的异步通知。
                        showMessage("取消");
                        PayListenerUtils.getInstance(mContext).addCancel();
                    } else {
                        // 该笔订单真实的支付结果，需要依赖服务端的异步通知。
                        showMessage("支付失败");
                        PayListenerUtils.getInstance(mContext).addError();
                    }
                    break;
                }
            }
        }
    };

    private static void showMessage(String str) {
        Toast.makeText(mContext, str, Toast.LENGTH_SHORT).show();
    }
}
