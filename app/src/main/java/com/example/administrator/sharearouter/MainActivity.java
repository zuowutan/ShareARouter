package com.example.administrator.sharearouter;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.alibaba.android.arouter.core.InterceptorServiceImpl;
import com.alibaba.android.arouter.facade.Postcard;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.facade.callback.NavigationCallback;
import com.alibaba.android.arouter.launcher.ARouter;

// 在支持路由的页面上添加注解(必选)
// 这里的路径需要注意的是至少需要有两级，/xx/xx
// 路径标签个人建议写在一个类里面 这样方便统一管理和维护

@Route(path = Constance.ACTIVITY_URL_MAIN)
public class MainActivity extends BaseActivity {
    public static final String TAG = "app";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /**
         * Activity 跳转 (普通跳转)
         * 跳转到SimpleActivity
         */
        findViewById(R.id.skip).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            ARouter.getInstance().build(Constance.ACTIVITY_URL_SIMPLE).
                        navigation();
            }
        });

        /**
         * Activity 跳转 (使用URI进行跳转)
         * 跳转到SimpleUriActivity
         */
        findViewById(R.id.skip_uri).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri uri = Uri.parse(Constance.ACTIVITY_URL_PARSE);
                ARouter.getInstance().build(uri).navigation();
            }
        });

        /**
         * Activity 跳转 (携带参数跳转)
         */
        findViewById(R.id.skipAddParams).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ARouter.getInstance().
                        build(Constance.ACTIVITY_URL_SECOND).
                        withString("name", "android").
                        withInt("age", 3).
                        withParcelable("test", new ManualBean("tzw", 26)).
                        navigation(MainActivity.this,123);
            }
        });


        findViewById(R.id.skipInterceptor).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ARouter.getInstance().build(Constance.ACTIVITY_URL_INTERCEPTOR  ).
                        navigation(MainActivity.this,
                                new NavigationCallback()
                                {
                    @Override
                    public void onFound(Postcard postcard) {
                        //路由目标被发现时调用
                        String group = postcard.getGroup(); String path = postcard.getPath();
                        Log.i(TAG, "onFound : group == "+group + "; path == "+path);
                    }
                     @Override
                    public void onArrival(Postcard postcard) {
                        //路由到达之后调用
                         String group = postcard.getGroup();String path = postcard.getPath();
                         Log.i(TAG, "onArrival : group == "+group + "; path == "+path);
                    }
                    @Override
                    public void onLost(Postcard postcard) {
                        //路由被丢失时调用
                        Log.i(TAG, "onLost : " );
                    }
                    @Override
                    public void onInterrupt(Postcard postcard) {
                        //路由被拦截时调用
                        Log.i(TAG, "onInterrupt : " );
                    }
                });
            }
        });

    }

    void shipFragment(){
        Fragment fragment = (Fragment) ARouter.getInstance().build(Constance.ACTIVITY_URL_FRAGMENT).navigation();

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case 123:
                Log.i(TAG, "onActivityResult: "+"接受到了第二个界面返回来的数据");
            default:
                break;
        }
    }
}
