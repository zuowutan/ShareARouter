package com.example.administrator.sharearouter;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Route;

/**
 * Created by tzw on 2018/5/7.
 * 简单的Activity
 * Uri_Parse 跳转
 */

@Route(path = Constance.ACTIVITY_URL_PARSE)
public class SimpleUriActivity extends BaseActivity{
    private TextView mTextView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple);
        mTextView = $(R.id.text);
        mTextView.setText("Uri Parse 跳转的Avtivity");
    }
}
