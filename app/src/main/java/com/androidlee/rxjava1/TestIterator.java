package com.androidlee.rxjava1;

import com.androidlee.rxjava1.ConcreteWatched;
import com.androidlee.rxjava1.ConcreteWatcher;
import com.androidlee.rxjava1.Watched;
import com.androidlee.rxjava1.Watcher;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by luoliwen on 16/5/31.
 */
public class TestIterator {

    public static void main(String[] args) {
        List<String> mDatas = new ArrayList<>();
        mDatas.add("lll");
        mDatas.add("ooo");
        mDatas.add("sss");
        Iterator iterator=mDatas.iterator();
        while (iterator.hasNext())
        {  String mlist=(String) iterator.next();
            System.out.println("key:"+mlist);
        }
    }
}
