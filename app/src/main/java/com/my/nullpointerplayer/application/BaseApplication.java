package com.my.nullpointerplayer.application;

import android.app.Application;
import android.content.Context;

import cn.jpush.android.api.JPushInterface;

/**
 * 基本的Application,所有Application都继承这个类
 * Created by dllo on 16/1/26.
 */
public class BaseApplication extends Application {
    public static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        BaseApplication.context=getBaseContext();

        JPushInterface.init(context);
        JPushInterface.setDebugMode(true);
    }
}
