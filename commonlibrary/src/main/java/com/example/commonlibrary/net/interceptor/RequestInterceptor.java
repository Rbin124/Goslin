package com.example.commonlibrary.net.interceptor;

import android.os.Build;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

public class RequestInterceptor implements Interceptor {
    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request()
                .newBuilder()
                .addHeader("Content-Type", "application/json;text/html;charset=UTF-8;")
                .addHeader("User-Agent", "android")
                .addHeader("model", Build.MODEL)
                .addHeader("brand", Build.BRAND)
                .addHeader("clientType", "APP")
                .addHeader("Connection", "keep-alive")
                .addHeader("Accept", "*/*")
                .addHeader("Cookie", "add cookies here")
                .build();
//        Log.v("zcb", "request:" + request.toString());
//        Log.v("zcb", "request headers:" + request.headers().toString());
        return chain.proceed(request);
    }
}
