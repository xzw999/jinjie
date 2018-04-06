package com.xinzhengwei.dianshangjinjieyuekaoti.Appliation;

import android.app.Application;
import android.os.Handler;

import com.facebook.drawee.backends.pipeline.Fresco;

/**
 * Created by 辛政维 on 2018/3/16.
 */

public class MyApplication extends Application {
    private static Handler handler;

    public static Handler getHandler() {
        return handler;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Fresco.initialize(this);
        handler = new Handler();
    }
}
