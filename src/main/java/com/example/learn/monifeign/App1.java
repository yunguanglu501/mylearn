package com.example.learn.monifeign;

import feign.Feign;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

public class App1 {
    private static Service1 service1;

    @BeforeAll
    public static void init(){
        service1 = Feign.builder()
                .target(Service1.class, "http://127.0.0.1:8080");
    }
    /**
     * 发送get请求
     */
    @Test
    public void test1(){
        String book = service1.getBook(1);
        System.out.println(book);
    }
    /**
     * 发送Post请求
     */
    @Test
    public void test2(){
        String book = service1.addBook(4, "时间就是生命", BigDecimal.TEN);
        System.out.println(book);
    }
}
