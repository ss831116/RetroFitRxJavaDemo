package com.example.bernieshi.thirdpartdemoapplication;

import org.json.JSONObject;

import java.util.Map;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;
import rx.Observable;

/**
 * Created by bernie.shi on 2016/7/13.
 */
public interface RApiService {
    String cookies = "111111111111111111111";
    /**
     * @GET 表明方法是 get请求
     * "/api" 请求的接口,请注意前面的/符号
     * @Query 表示这是一个参数
     * Call<ResponseBody> :Call是必须的,ResponseBody是Retrofit默认的返回数据类型,也就是String体
     */

    @GET("/api")
    Call<ResponseBean> getApi(@Query("pa1") String va1, @Query("ba1") String va2);
    //getApi方法,等效于: http://192.168.1.12:8082/api?pa1=va1&ba1=va2


    /**
     * @POST 请求方式post
     * @Body 表示将requestBean对象转成成json string作为参数传递给后台
     */
    @POST("/api")
    Call<ResponseBean> postApi(@Body RequestBean requestBean);


    /**
     * @QueryMap 表示将map类型的params对象, 转成键值对的形式作为参数传递给后台
     */
    @GET("/api")
    Call<ResponseBody> getApiString(@QueryMap Map<String, String> params);
    @Headers("Cookie:"+ cookies)
    @POST("parleyserver/user/getpin")
    Call<MyObject> getInfo(@Body Map<Object, Object> params);
    @POST("parleyserver/user/login")
    Call<MyObject> sendPhoneNumber(@Body Map<Object, Object> params);
    @POST("/api")
    Call<ResponseBody> postApiString(@Body RequestBean requestBean);

    /**
     * Observable 是RxJava的关键点,其他不变
     */
    @GET("/api")
    Observable<ResponseBody> getRxApiString(@QueryMap Map<Object, Object> params);

    @POST("parleyserver/user/login")
    Observable<MyObject> postRxApiString(@Body Map<Object, Object> params);

    public class ResponseBean {

    }
    public class RequestBean {

    }
}
