package com.androidlee.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;


import com.androidlee.R;
import com.androidlee.adapter.TestAdapter;
import com.androidlee.utils.HomeItemDecoration;

public class RecyclerviewDeleteActivity extends AppCompatActivity {
    private RecyclerView mRecyclerview;
    private TestAdapter mTestAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recyclerview_layout);
        initView();
    }

    public void initView() {
        mRecyclerview = (RecyclerView) findViewById(R.id.recyclerview);
        mTestAdapter = new TestAdapter(this);
        mRecyclerview.setAdapter(mTestAdapter);
        GridLayoutManager manager = new GridLayoutManager(this, 1);
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerview.setLayoutManager(manager);
        HomeItemDecoration homeItemDecoration = new HomeItemDecoration(4);
        mRecyclerview.addItemDecoration(homeItemDecoration);
    }
}
