package com.androidlee.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.androidlee.R;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    TextView mtest_retrofit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mtest_retrofit = (TextView) findViewById(R.id.test_retrofit);
        mtest_retrofit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "发送成功", Toast.LENGTH_SHORT);
            }
        });
    }

    //创建一个retrofit实例
    private Retrofit createRetrofit() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://118.123.21.143/sheku/")
                .addConverterFactory(GsonConverterFactory.create())//用什么转换器来解析返回值
                .build();
        return retrofit;
    }
}
