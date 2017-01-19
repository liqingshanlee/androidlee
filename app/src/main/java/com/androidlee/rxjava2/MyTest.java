package com.androidlee.rxjava2;

/**
 * Created by luoliwen on 16/5/31.
 */
public class MyTest {

    public static void main(String[] args) throws Exception {

        SimpleObservable simple = new SimpleObservable();

        SimpleObserver observer = new SimpleObserver(simple);

        simple.setData(1);
        simple.setData(2);
        simple.setData(2);
        simple.setData(3);

    }
}
