package com.example.bernieshi.thirdpartdemoapplication;

import android.content.Context;
import android.util.Log;

import java.net.CookieManager;
import java.net.CookiePolicy;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by bernie.shi on 2016/7/13.
 */
public class RRetrofit {
    public static OkHttpClient.Builder builder = new OkHttpClient.Builder();
    public static <T> T create(final Class<T> cls,String webSite,Context context) {
        CookieManager cookieManager = new CookieManager();
        cookieManager.setCookiePolicy(CookiePolicy.ACCEPT_ALL);
        builder.networkInterceptors()
                .add(new CookiesInterceptor(context));
        builder.connectTimeout(15, TimeUnit.SECONDS);
        builder.readTimeout(20, TimeUnit.SECONDS);
        builder.writeTimeout(20, TimeUnit.SECONDS);
        OkHttpClient okHttpClient = builder.build();
        Retrofit.Builder builder = new Retrofit.Builder();
        Retrofit retrofit = builder
                .baseUrl(webSite)//注意此处,设置服务器的地址
                .addConverterFactory(GsonConverterFactory.create())//用于Json数据的转换,非必须
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())//用于返回Rxjava调用,非必须
                .client(okHttpClient)
                .build();
        return retrofit.create(cls);
    }

}
