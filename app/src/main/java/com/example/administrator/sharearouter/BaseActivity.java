package com.example.administrator.sharearouter;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.SparseArray;
import android.view.View;
import android.view.Window;

import com.alibaba.android.arouter.launcher.ARouter;

/**
 * Created by tzw on 2018/5/7.
 * 简单的封装ARouter相关功能
 */

public class BaseActivity extends AppCompatActivity {

    private SparseArray<View> mViews;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // ARouter inject 注入
        ARouter.getInstance().inject(this);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        mViews = new SparseArray<>();
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
//        这样写会报错
//        ARouter.getInstance().destroy();
    }


    //      findViewById
    public <E extends View> E $(int viewId) {
        E view = (E) mViews.get(viewId);
        if (view == null) {
            view = (E) findViewById(viewId);
            mViews.put(viewId, view);
        }
        return view;
    }

}
