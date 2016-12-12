package com.androidlee.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.androidlee.R;

import rx.Observable;
import rx.Subscriber;

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

    //被观察者
    Observable observable = Observable.create(new Observable.OnSubscribe<String>() {
        @Override
        public void call(Subscriber<? super String> s) {
            s.onNext("Hello");
            s.onCompleted();
        }
    });
    //观察者
    Subscriber<String> mySubscriber = new Subscriber<String>() {
        @Override
        public void onNext(String s) {
            Log.e("test", s);
        }

        @Override
        public void onCompleted() {
        }

        @Override
        public void onError(Throwable e) {
        }
    };
}
