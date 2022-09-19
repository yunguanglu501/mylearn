package com.example.learn.test;

import java.net.URLDecoder;
import java.net.URLEncoder;

/**
 * @Author: wcy
 * @Date: 2022/7/11 9:49
 * @Version 1.0
 */
public class Demo002 {

    public static void main(String[] args) throws Exception{
        String teshuzifu = "za4T8MHB/6mhmYgXB7IntyyOUL7Cl++0jv5rFxAIFVji8GDrcf+k8g==";
        String encode = URLEncoder.encode(teshuzifu, "UTF-8");
        System.out.println("encode = " + encode);

        String decode = URLDecoder.decode(encode, "utf-8");

        System.out.println("decode = " + decode);

        String x = "name?param="+URLEncoder.encode(teshuzifu, "UTF-8");
        System.out.println("x = " + x);
        //下面的是错误的,URLEncoder必须仅仅编码参数或参数的值,不能对整个url,也不能一起对param= value进行编码
        //因为url中的&和=他们是作为参数之间以及参数和值之间的分隔符的,如果一起编码就无法区分他们了
        String y = "name?param=za4T8MHB/6mhmYgXB7IntyyOUL7Cl++0jv5rFxAIFVji8GDrcf+k8g==";
        String encode1 = URLEncoder.encode(y, "UTF-8");
        //name%3Fparam%3Dza4T8MHB%2F6mhmYgXB7IntyyOUL7Cl%2B%2B0jv5rFxAIFVji8GDrcf%2Bk8g%3D%3D
        System.out.println("encode1 = " + encode1);
    }
}
