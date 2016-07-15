package com.example.bernieshi.thirdpartdemoapplication;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.squareup.okhttp.ResponseBody;

import org.json.JSONObject;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Optional;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;
import rx.Observer;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.exceptions.Exceptions;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

public class MainActivity extends Activity {
    @BindView(R.id.myImageView)
    SimpleDraweeView myImageView;
    @BindView(R.id.imageView)
    ImageView imageView;
    @BindView(R.id.text)
    TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        service = RRetrofit.create(RApiService.class, "http://www888.rollit.me/", getApplicationContext());
        ButterKnife.bind(this);
        Observable<String> addOb = RxBus.get()
                .register("addFeedTag", String.class);

/*
        addOb.observeOn(AndroidSchedulers.mainThread())
                .subscribe(s -> {
                    // todo: Accept event and process here
                });
*/

    }
    RApiService service ;
    @Nullable
    @Optional
    @OnClick({R.id.myImageView, R.id.imageView, R.id.text})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.myImageView:
                Map<Object, Object> params = new HashMap<>();
                params.put("accountType", "phone");
                params.put("account", "11111111111");
                params.put("pin", "1234");
                params.put("token", "");
                params.put("jpushId", "12341234234");
                params.put("cilentType", 2);
                ok(params);
                break;
            case R.id.imageView:
                Map<Object, Object> mParams = new HashMap<>();
                mParams.put("phoneNumber", "11111111111");
                getMovie(mParams, true);
                break;
            case R.id.text:

                break;
        }
    }

    protected void onStart() {
        super.onStart();
        Uri uri = Uri.parse("http://img0.imgtn.bdimg.com/it/u=2145019983,4168111801&fm=21&gp=0.jpg");
        myImageView.setImageURI(uri);

    }

    public void ok(Map<Object, Object> params){
        service.postRxApiString(params)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<MyObject>() {
                    @Override
                    public void onNext(MyObject myObject) {
                        Log.e("MAINTAG", "onCompleted = " + myObject.getRetCode());
                    }

                    @Override
                    public void onCompleted() {
                     //   append("getRxApiString onCompleted-->\n");
                    }

                    @Override
                    public void onError(Throwable e) {
                       // append("getRxApiString onError-->\n" + e.getMessage());
                    }

                });
    }
    private void getMovie(Map<Object, Object> params, boolean isLogin) {

        Call<MyObject> api;
        if (isLogin) {
            api = service.getInfo(params);
        } else {
            api = service.sendPhoneNumber(params);
        }
        api.enqueue(new Callback<MyObject>() {
            @Override
            public void onResponse(Call<MyObject> call, Response<MyObject> response) {
                Log.e("MAINTAG", "onCompleted = " + response.headers().get("Set-Cookie"));
                Log.e("MAINTAG", "retcode = " + response.body().getRetCode());
                Log.e("MAINTAG", "token ===== " + response.body().getToken() == null ? "0" : response.body().getToken());
            }

            @Override
            public void onFailure(Call<MyObject> call, Throwable t) {
                Log.e("MAINTAG", "==========" + t.toString());

            }
        });

    }
}
