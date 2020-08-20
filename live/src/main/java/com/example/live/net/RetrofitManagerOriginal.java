package com.example.live.net;


import com.example.commonlibrary.net.manager.RetrofitManager;
import com.example.live.api.API;


/**
 * Created by Android Studio.
 * User: apple
 * Date: 2020/8/12
 * Time: 3:48 PM
 */
public class RetrofitManagerOriginal extends RetrofitManager {

    static API retrofitService;

    public static API createApi() {
        if (retrofitService == null) {
            synchronized (Object.class) {
                if (retrofitService == null) {
                    retrofitService = create(API.class);
                }
            }
        }
        return retrofitService;
    }
}

