package com.example.bernieshi.thirdpartdemoapplication;

import android.app.Activity;
import android.os.Bundle;

import butterknife.ButterKnife;

/**
 * Created by bernie.shi on 2016/7/12.
 */
public class BaseActivity extends Activity {
    protected void onCreate(Bundle onSaveStateInstance){
        super.onCreate(onSaveStateInstance);
        ButterKnife.bind(this);
    }
}
