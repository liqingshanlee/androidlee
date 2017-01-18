package com.androidlee.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.androidlee.R;
import com.androidlee.rxjava2.RxUtils;


/**
 * 作者： 李青山
 * 创建时间： 2016/12/14.
 */

public class RxjavaActivity1 extends AppCompatActivity {
    TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rxjava1);
    }


    /**
     * 调用create 方法
     *
     * @param view
     */
    public void createMethod(View view) {
        RxUtils.createObserable();
    }

    public void createMethod2(View view) {
        RxUtils.createPrint();
    }

    public void from(View view) {
        RxUtils.from();
    }

    public void just(View view) {
        RxUtils.just();
    }

    public void filter(View view) {
        RxUtils.filter();
    }
}
