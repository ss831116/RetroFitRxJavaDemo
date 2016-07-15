package com.example.bernieshi.thirdpartdemoapplication;

import android.content.Context;


import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by bernie.shi on 2016/7/13.
 */
public class CookiesInterceptor  implements Interceptor {
    private Context context;

    public CookiesInterceptor(Context context) {
        this.context = context;
    }
    //重写拦截方法，处理自定义的Cookies信息
    @Override
    public Response intercept(Interceptor.Chain chain) throws IOException {
        Request request = chain.request();
        Request compressedRequest = request.newBuilder()
                .header("cookie", "1111111111")
                .build();
        Response response = chain.proceed(compressedRequest);
        return response;
    }
}
