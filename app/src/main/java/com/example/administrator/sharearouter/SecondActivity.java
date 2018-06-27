package com.example.administrator.sharearouter;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.Postcard;
import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.facade.callback.NavigationCallback;
import com.alibaba.android.arouter.facade.model.RouteMeta;
import com.alibaba.android.arouter.launcher.ARouter;

/**
 * Created by tzw on 2018/3/20.
 */


@Route(path = Constance.ACTIVITY_URL_SECOND)
public class SecondActivity extends BaseActivity {
    private TextView mTextView;

    @Autowired()
    String name;

    @Autowired()
    int age;

    @Autowired(name = "test")
    ManualBean manualBean;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
         final String TAG = Constance.TAG;

        mTextView = $(R.id.gettext);
        Log.i(TAG, "value == "+"姓名 :" + name + ", 年龄 : " + age + ",testBean 对象 :" + manualBean);

        mTextView.setText("姓名 :" + name + ", 年龄 : " + age + ",testBean 对象 :" + manualBean);

//       返回上一个界面
        setResult(123);

        findViewById(R.id.backmain).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /**
                 * 试验步骤:
                 *
                 * (不使用拦截器)
                 * 1:成功返回界面的执行顺序 : onFound -->> onArrival     postcard.getPath() == /app/MainActivity
                 * 2:错误的路径、失败返回界面的执行顺序 : onLost  (会Toast 提示:There is no route matched!)    postcard.getPath() == 自己设置的路径
                 *
                 *
                 * (使用拦截器)
                 * 首先就会初始化拦截器
                 * 1)自定义IInterceptorinit:
                 * 2)自定义IInterceptorprocess:
                 * 3)自定义IInterceptorcallback.onContinue
                 *
                 *
                 * 如果不拦截、允许放行
                 * 4)onFound : /app/MainActivity
                 * 5)自定义IInterceptorprocess:
                 * 6)自定义IInterceptorcallback.onContinue
                 * 7)onArrival : /app/MainActivity
                 *
                 *
                 * 试验结论:
                 * 1:postcard.getPath() == 我们在build里面设置的路径
                 * 2:
                 */
                ARouter.getInstance().build("/app/MainActivity").navigation(SecondActivity.this, new NavigationCallback() {
                    @Override
                    public void onFound(Postcard postcard) {
                        //路由目标被发现时调用
                        Log.i(TAG, "onFound : " + postcard.getPath());
                    }

                    @Override
                    public void onLost(Postcard postcard) {
                        //路由被丢失时调用
                        Log.i(TAG, "onLost : " + postcard.getPath());
                    }

                    @Override
                    public void onArrival(Postcard postcard) {
                        //路由到达之后调用
                        Log.i(TAG , "onArrival : " + postcard.getPath());

                    }

                    @Override
                    public void onInterrupt(Postcard postcard) {
                        //路由被拦截时调用
                        Log.i(TAG, "onInterrupt : " + postcard.getPath());
                    }
                });
            }
        });
    }

}
