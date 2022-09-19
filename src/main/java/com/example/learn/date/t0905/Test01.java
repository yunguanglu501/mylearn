package com.example.learn.date.t0905;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Test01
 *
 * @author wcy
 * @date 2022/9/5
 */
public class Test01 {
    public static void main(String[] args) throws Exception {
        List<String> strings = new ArrayList<>();
        strings.add("a");
        Iterator<String> iterator = strings.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}
