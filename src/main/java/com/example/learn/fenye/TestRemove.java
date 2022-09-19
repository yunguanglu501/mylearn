package com.example.learn.fenye;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * TestRemove
 *
 * @author wcy
 * @date 2022/8/24
 */
public class TestRemove {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>(10);
        list.add("a");
        list.add("ab");
        list.add("abc");
        list.add("abcd");
        list.add("d");

        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            if (iterator.next().contains("a")) {
                // 删除元素
                iterator.remove();
            }
        }
        System.out.println(list);
    }

}
