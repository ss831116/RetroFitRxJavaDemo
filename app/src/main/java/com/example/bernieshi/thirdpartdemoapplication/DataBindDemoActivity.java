package com.example.bernieshi.thirdpartdemoapplication;

import android.app.Activity;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.bernieshi.thirdpartdemoapplication.databinding.DataBingingActivityBinding;

/**
 * Created by bernie.shi on 2016/7/15.
 */
public class DataBindDemoActivity extends AppCompatActivity {

    protected void onCreate(Bundle onSave){
        super.onCreate(onSave);
        setContentView(R.layout.data_binging_activity);
        DataBingingActivityBinding binding = DataBindingUtil.setContentView(this, R.layout.data_binging_activity);
        User user = new User("Test", "User");
        binding.setUser(user);
    }
}
