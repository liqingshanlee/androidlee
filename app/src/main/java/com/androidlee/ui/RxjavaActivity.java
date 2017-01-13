package com.androidlee.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.androidlee.R;

import rx.Observable;
import rx.functions.Action1;

/**
 * 作者： 李青山
 * 创建时间： 2016/11/15.
 */

public class RxjavaActivity extends AppCompatActivity {
    TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rxjava);
        mTextView = (TextView) findViewById(R.id.test_rxjava);
        mTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //被观察者被订阅
                observable.subscribe(mySubscriber);
            }
        });
    }

    //被观察者1
//    Observable observable = Observable.create(new Observable.OnSubscribe<String>() {
//        @Override
//        public void call(Subscriber<? super String> s) {
//            s.onNext("Hello");
//            s.onCompleted();
//        }
//    });
    //被观察者2
    Observable<String> observable = Observable.just("Hello, world!");
    //观察者1
//    Subscriber<String> mySubscriber = new Subscriber<String>() {
//        @Override
//        public void onNext(String s) {
//            Log.e("test", s);
//        }
//
//        @Override
//        public void onCompleted() {
//            Log.e("test", "onCompleted");
//        }
//
//        @Override
//        public void onError(Throwable e) {
//        }
//    };
    //观察者2
    Action1<String> mySubscriber = new Action1<String>() {
        @Override
        public void call(String s) {
            Log.e("test", s);
        }
    };
}
