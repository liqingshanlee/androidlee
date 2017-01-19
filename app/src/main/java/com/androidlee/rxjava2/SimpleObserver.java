package com.androidlee.rxjava2;

import java.util.Observable;
import java.util.Observer;

/**
 * Created by luoliwen on 16/5/31.
 */
public class SimpleObserver implements Observer {

    public SimpleObserver(Observable observable) {
        observable.addObserver(this);
    }

    //当被观察者状态发生改变的时候会调用
    public void update(Observable observable, Object object) {
        System.out.println("data is changed:" + ((SimpleObservable) observable).getData());
        System.out.println("data is changed:" + ((SimpleObservable) observable).getString());
    }
}
