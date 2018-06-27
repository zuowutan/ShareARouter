package com.example.administrator.sharearouter;

/**
 * ARouter上面的注解需要我们写路径标识
 * 我们可以写一个常量文件，在这里统一管理路径标签
 */
public final class Constance {
    public static final String TAG = "app";
    public static final boolean UseIInterceptor = true;
    public static final String ACTIVITY_URL_MAIN = "/app/MainActivity";
    public static final String ACTIVITY_URL_SIMPLE = "/app/SimpleActivity";
    public static final String ACTIVITY_URL_PARSE = "/app/SimpleUriActivity";
    public static final String ACTIVITY_URL_SECOND = "/app/SecondActivity";
    public static final String ACTIVITY_URL_INTERCEPTOR = "/app/Interceptor";
    public static final String ACTIVITY_URL_FRAGMENT = "/app/fragment";
    public static final String GROUP_FIRST = "group_first";
}
