package com.androidlee.utils;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;


/**
 * Created by Administrator on 2016/10/8.
 */
public class HomeItemDecoration extends RecyclerView.ItemDecoration {
    private int space;
    private int left;
    private int top;
    private int right;

    public void setMagin(int top, int left, int right) {
        this.top = top;
        this.left = left;
        this.right = right;
    }


    public HomeItemDecoration(int space) {
        this.space = space;
    }

    @Override
    public void getItemOffsets(Rect outRect, final View view, final RecyclerView parent, RecyclerView.State state) {
        outRect.left = left;
        outRect.bottom = space;
        outRect.top = top;
        outRect.right = right;
    }
}