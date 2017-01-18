package com.androidlee.rxjava;

/**
 * Created by luoliwen on 16/5/31.
 */
public interface Watched {

    public void addWatcher(Watcher watcher);

    public void removeWatcher(Watcher watcher);

    public  void  notifyWatchers(String str);

}
