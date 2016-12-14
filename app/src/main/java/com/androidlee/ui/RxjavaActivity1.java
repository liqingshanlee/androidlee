package com.androidlee.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import com.androidlee.R;


/**
 * 作者： 李青山
 * 创建时间： 2016/12/14.
 */

public class RxjavaActivity1 extends AppCompatActivity implements View.OnClickListener {
    TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rxjava1);
        mTextView = (TextView) findViewById(R.id.test_rxjava2);
        mTextView.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.test_rxjava2:
                Toast.makeText(RxjavaActivity1.this, "测试", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
