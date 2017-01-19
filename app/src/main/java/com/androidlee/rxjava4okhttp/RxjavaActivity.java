package com.androidlee.rxjava4okhttp;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.androidlee.R;
import com.androidlee.utils.DownLoadUtils;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * 作者： 李青山
 * 创建时间： 2016/11/15.
 */

public class RxjavaActivity extends AppCompatActivity {
    private final static String TAG = RxjavaActivity.class.getSimpleName();

    private Button button;

    private ImageView imageView;

    private String PATH = "http://pic32.nipic.com/20130829/12906030_124355855000_2.png";

    private DownLoadUtils utils;

    /**
     * 采用handler 结合了activity使用
     *
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rxjava);
        button = (Button) this.findViewById(R.id.button);
        imageView = (ImageView) this.findViewById(R.id.imageView);
        utils = new DownLoadUtils();
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //使用HTTP协议获取数据
                utils.downLoadImage(PATH).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Subscriber<byte[]>() {
                    @Override
                    public void onCompleted() {
                        Log.i(TAG, "onCompleted");//对话框消失
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.i(TAG, e.getMessage());
                    }

                    @Override
                    public void onNext(byte[] bytes) {
                        Bitmap bitmap = BitmapFactory.decodeByteArray(bytes, 0, bytes.length);
                        imageView.setImageBitmap(bitmap);
                    }
                });
            }
        });

    }


}
