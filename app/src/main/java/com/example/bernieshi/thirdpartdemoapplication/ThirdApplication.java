package com.example.bernieshi.thirdpartdemoapplication;

import android.app.Application;

import com.facebook.drawee.backends.pipeline.Fresco;

import butterknife.ButterKnife;


/**
 * Created by bernie.shi on 2016/7/12.
 */
public class ThirdApplication extends Application {
    public void onCreate() {
        super.onCreate();
        Fresco.initialize(getApplicationContext());
    }
}
