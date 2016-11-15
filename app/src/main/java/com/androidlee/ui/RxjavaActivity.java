package com.androidlee.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.androidlee.R;

import rx.Observable;
import rx.Subscriber;

/**
 * 作者： 李青山
 * 创建时间： 2016/11/15.
 */

public class RxjavaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rxjava);
    }
    Observable observable = Observable.create(new Observable.OnSubscribe<String>() {
        @Override
        public void call(Subscriber<? super String> subscriber) {
            subscriber.onNext("Hello");
            subscriber.onNext("Hi");
            subscriber.onNext("Aloha");
            subscriber.onCompleted();
        }
    });
}
