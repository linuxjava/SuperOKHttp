package com.okhttp.demo;

import android.app.Application;

import xiao.free.okgo.OkGo;

public class App extends Application{
    @Override
    public void onCreate() {
        super.onCreate();

        OkGo.getInstance().init(this);
    }
}
