package com.example.administrator.sharearouter;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.alibaba.android.arouter.facade.annotation.Route;

/**
 * Created by tzw on 2018/5/12.
 * 简单的Activity
 */

@Route(path = Constance.ACTIVITY_URL_SIMPLE)
public class SimpleActivity extends BaseActivity{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple);
    }
}
