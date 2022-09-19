package com.example.learn.date.t0919;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * DoubleBracesTest
 *
 * @author wcy
 */
public class DoubleBracesTest {
    private String key = "key";
    private String value = "value";

    //test方法返回一个map,如果被其他对象的属性所引用，
    // GC时便不会回收此对象，从而导致内存泄漏！这个也是非静态内部类的主要缺点。
    public Map<String, String> test() {
        Map<String, String> map = new HashMap() {{
            put("k", "v");
            put(key, value);
        }};
        return map;
    }


    public static void main(String[] args) throws Exception {
        List<String> list = new ArrayList<String>(Arrays.asList("aaa","bbb"));
        System.out.println("list = " + list);
        System.out.println("list.getClass() = " + list.getClass());
        List<String> list2 = Stream.of("aaa", "bbb").collect(Collectors.toList());
        System.out.println("list2 = " + list2);
        System.out.println("list2.getClass() = " + list2.getClass());
        System.out.println("Arrays.asList(\"aaa\",\"bbb\").getClass() = " + Arrays.asList("aaa", "bbb").getClass());
    }
    // Map<String, String> map= Map.of("k1", "v1", "k2", "v2");

}
