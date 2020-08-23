package com.example.commonbusiness.pay;

import java.util.ArrayList;

public class PayListenerUtils {

    private static PayListenerUtils instance;

    private final static ArrayList<PayResultListener> resultList = new ArrayList<>();

    private PayListenerUtils() { }

    public synchronized static PayListenerUtils getInstance() {
        if (instance == null) {
            instance = new PayListenerUtils();
        }
        return instance;
    }

    public void addListener(PayResultListener listener) {
        if (!resultList.contains(listener)) {
            resultList.add(listener);
        }
    }

    public void removeListener(PayResultListener listener) {
        if (resultList.contains(listener)) {
            resultList.remove(listener);
        }
    }

    public void paySuccess() {
        for (PayResultListener listener : resultList) {
            listener.onPaySuccess();
        }
    }

    public void payCancel() {
        for (PayResultListener listener : resultList) {
            listener.onPayCancel();
        }
    }

    public void payError() {
        for (PayResultListener listener : resultList) {
            listener.onPayError();
        }
    }
}
