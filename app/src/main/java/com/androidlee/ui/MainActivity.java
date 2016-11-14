package com.androidlee.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.androidlee.R;
import com.androidlee.api.TestService;
import com.androidlee.model.User;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    TextView mtest_retrofit, mtextView;
    TestService mTestService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mtest_retrofit = (TextView) findViewById(R.id.test_retrofit);
        mTestService = createRetrofit().create(TestService.class);
        mtest_retrofit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //异常测试
//                mtextView.setText("测试");
                getData();
            }
        });
    }

    //创建一个retrofit实例
    private Retrofit createRetrofit() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://www.sheku.org/")
                .addConverterFactory(GsonConverterFactory.create())//用什么转换器来解析返回值
                .build();
        return retrofit;
    }

    //请求数据
    private void getData() {
        String GroupData="1475063861162";
        Call<User> userCall = mTestService.getImageView(GroupData,"open","111","shekju","哈哈哈","open");
        userCall.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                Toast.makeText(MainActivity.this, "成功", Toast.LENGTH_LONG).show();
                Log.e("test", response.toString());
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                Toast.makeText(MainActivity.this, "错误信息" + t.toString(), Toast.LENGTH_LONG).show();
            }
        });
    }
}
