package com.example.learn.jichu;

import com.example.learn.util.MD5Util;

/**
 * YunSuanHu
 *
 * @author wcy
 * @date 2022/8/17
 */
public class YunSuanHu {
    public static void main(String[] args) {
        // boolean b = judgeEven(11);
        // System.out.println("b = " + b);
        // surplus(14);
        String a = MD5Util.getUpperMD5("a");
        System.out.println("a = " + a);
        System.out.println(a.equals("0cc175b9c0f1b6a831c399e269772661"));
    }

    static boolean judgeEven(int num) {
        return (num & 1) == 0;
    }

    static void surplus(int num) {
        // 对2的幂取余，num & (2的幂 -1)，假设对 4 取余
        int remainder = num & (4 - 1);
        System.out.println(remainder);
    }
}
