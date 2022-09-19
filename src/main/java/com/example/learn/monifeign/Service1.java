package com.example.learn.monifeign;

import feign.Body;
import feign.Headers;
import feign.Param;
import feign.RequestLine;

import java.math.BigDecimal;

public interface Service1 {
    /**
     * 通过ID获取书本信息
     *
     * @param id
     * @return
     */
    @RequestLine("GET /book?id={id}")
    String getBook(@Param("id") Integer id);

    /**
     * 添加书本信息
     *
     * @param id       书本ID
     * @param bookName 书本名称
     * @param price    书本价格
     * @return
     */
    @RequestLine("POST /book/json")
    // Body中的"{"和"}"需要转义
    @Body("%7B\"id\": \"{id}\", \"bookName\": \"{bookName}\", \"price\": \"{price}\" %7D")
    @Headers({"Content-Type:application/json"})
    String addBook(@Param("id") Integer id, @Param("bookName") String bookName, @Param("price") BigDecimal price);
}
