package com.androidlee.app;

import android.app.Application;

/**
 * 作者： 李青山
 * 创建时间： 2016/11/14.
 */

public class LibraryApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        CrashHandler ch = CrashHandler.getInstance();
        ch.init(this);
    }
}
