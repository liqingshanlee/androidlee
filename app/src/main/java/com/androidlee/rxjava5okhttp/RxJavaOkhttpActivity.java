package com.androidlee.rxjava5okhttp;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.androidlee.R;

import java.util.HashMap;
import java.util.Map;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class RxJavaOkhttpActivity extends AppCompatActivity {
    private final String TAG = RxJavaOkhttpActivity.class.getSimpleName();

    private Button button;
    private EditText username;
    private EditText password;

    private ProgressDialog dialog;
    private LoginUtils utils;

    private final String LOGIN = "http://192.168.72.196:8080/webproject/LoginAction";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recyclerview);
        button = (Button) this.findViewById(R.id.button);
        username = (EditText) this.findViewById(R.id.editText);
        dialog = new ProgressDialog(this);
        dialog.setTitle("login......");
        utils = new LoginUtils();
        password = (EditText) this.findViewById(R.id.editText2);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Map<String, String> params = new HashMap<String, String>();
                params.put("username", username.getText().toString().trim());
                params.put("password", password.getText().toString().trim());

                utils.login(LOGIN, params).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Subscriber<String>() {
                    @Override
                    public void onCompleted() {
                        dialog.dismiss();
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.i(TAG, e.getMessage());
                    }

                    @Override
                    public void onNext(String s) {
                        dialog.show();
                        // Log.i(TAG,s);
                        if (JsonUtils.parserJson(s)) {
                            Log.i(TAG, "success");
                        }
                    }
                });
            }
        });
    }

}
