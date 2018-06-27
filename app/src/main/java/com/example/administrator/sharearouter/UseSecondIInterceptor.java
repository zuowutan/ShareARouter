package com.example.administrator.sharearouter;

import android.content.Context;
import android.util.Log;

import com.alibaba.android.arouter.facade.Postcard;
import com.alibaba.android.arouter.facade.annotation.Interceptor;
import com.alibaba.android.arouter.facade.callback.InterceptorCallback;
import com.alibaba.android.arouter.facade.template.IInterceptor;

/**
 * Created by tzw on 2018/3/20.
 * 自定义IInterceptor
 *
 * 说明:
 * 1: ARoute拦截器 是一个接口  如果有需要 我们可以自定义它
 * 2: 一定别忘记了使用Interceptor类注解
 * 3:如果有多个 ARoute拦截器,我们如何定义优先级？
 * 使用Interceptor类注解的priority，数值越小，越先执行。
 *
 */

//@Interceptor(priority = 7)
public class UseSecondIInterceptor{
/* implements IInterceptor {
    @Override
    public void init(Context context) {
        Log.i(Constance.TAG,   " UseSecondIInterceptor 拦截器 init : ");

    }

    @Override
    public void process(Postcard postcard, InterceptorCallback callback) {

        String name = Thread.currentThread().getName();
        Log.i(Constance.TAG, " UseSecondIInterceptor 拦截器 doing : "+"线程名称 :"+name);


        if (postcard.getPath().equals(Constance.ACTIVITY_URL_INTERCEPTOR)) {
            Log.i(Constance.TAG, UseSecondIInterceptor.class.getName() + " 进行了拦截处理！");
        }
        callback.onContinue(postcard);

        }*/
    }

