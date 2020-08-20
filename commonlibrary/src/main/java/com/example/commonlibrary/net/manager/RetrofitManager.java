package com.example.commonlibrary.net.manager;

import com.example.commonlibrary.BuildConfig;
import com.example.commonlibrary.net.interceptor.HttpLogger;
import com.example.commonlibrary.net.interceptor.RequestInterceptor;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import java.util.concurrent.TimeUnit;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitManager {

    /*
    * 创建OkHttpClient对象。Retrofit底层基于OkHttpClient进行网络请求。
    * */
    private static OkHttpClient createOkHttpClient() {
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor(new HttpLogger());
        httpLoggingInterceptor.setLevel(BuildConfig.DEBUG ? HttpLoggingInterceptor.Level.BODY : HttpLoggingInterceptor.Level.NONE);
        return new OkHttpClient.Builder()
                //设置连接超时时间
                .connectTimeout(30, TimeUnit.SECONDS)
                //设置读取超时时间
                .readTimeout(30, TimeUnit.SECONDS)
                .writeTimeout(30, TimeUnit.SECONDS)
                //添加日志过滤器
                .addInterceptor(new RequestInterceptor())
                .addNetworkInterceptor(httpLoggingInterceptor)
                //添加BaseInterceptor过滤器
                .build();
    }

    /**
     * 获取Service
     * 请求接口通用
     *
     * @param clazz
     * @param <T>
     * @return
     */
    public static <T> T create(Class<T> clazz) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://shop.yuelvhui.com")
                .client(createOkHttpClient())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create()) // 支持RxJava
                .addConverterFactory(GsonConverterFactory.create()) // 支持Gson解析
                .build();
        return retrofit.create(clazz);
    }
}
