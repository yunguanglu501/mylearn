package com.example.learn.shipeiqi;

import java.util.HashMap;
import java.util.List;

/**
 * @Description:
 * @Author: wcy
 * @CreateDate: 2022/6/30 17:49
 */
public class ListAdapter extends HashMap {

    private List list;
    public ListAdapter(List list) {
        this.list = list;
    }
    @Override
    public int size() {
        return list.size();
    }
    @Override
    public Object get(Object key) {
        Object o = list.get(Integer.valueOf(key.toString()).intValue());
        System.out.println("o = " + o);
        return o;
    }
}
