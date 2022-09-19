package com.example.learn.monifeign;

import feign.Param;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class service1Impl {

    @RequestMapping("/book")
    String getBook(@Param("id") Integer id) {
        return "" + id;
    }
}
