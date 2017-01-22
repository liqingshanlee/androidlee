package com.androidlee.rxjava2;

import java.util.Observable;

/**
 * Created by luoliwen on 16/5/31.
 * 创建一个被观察者
 */
public class SimpleObservable extends Observable {
    private int data = 0;
    private String url;

    public int getData() {
        return data;
    }

    public String getString() {
        return url;
    }

    public void setData(int i) {
        if (this.data != i) {
            this.data = i;
            this.url = "string" + i;
            setChanged();//调用咯setchanged就会触发observer接口的update(Observable observable, Object object)方法；
            notifyObservers();//通知观察者，表示状态发生改变
        }
    }
}
