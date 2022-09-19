package com.example.learn.jichu;


import java.nio.charset.StandardCharsets;
import java.util.Base64;

/**
 * Base64Test
 *
 * @author wcy
 * @date 2022/8/17
 */
public class Base64Test {
    public static void main(String[] args) {

        String encode = Base64.getEncoder().encodeToString("中国人".getBytes(StandardCharsets.UTF_8));
        System.out.println("encode = " + encode);
        byte[] decode = Base64.getDecoder().decode(encode);
        System.out.println("new String(decode) = " + new String(decode));
        // 使用基本编码
        String base64encodedString = Base64.getEncoder().encodeToString("runoob?java8".getBytes(StandardCharsets.UTF_8));
        System.out.println("Base64 编码字符串 (基本) :" + base64encodedString);
    }
}
