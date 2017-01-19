package com.androidlee.rxjava1;

/**
 * Created by luoliwen on 16/5/31.
 */
public class ConcreteWatcher implements  Watcher {
    @Override
    public void update(String str) {
        System.out.println(str);
    }
}
