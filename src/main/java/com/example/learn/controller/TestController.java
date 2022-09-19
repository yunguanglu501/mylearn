package com.example.learn.controller;

import com.example.learn.fx.FxPerson;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @RequestMapping("test1")
    public FxPerson test1(@RequestBody FxPerson fxPerson) throws Exception {
        Thread.sleep(1000L);
        return fxPerson;
    }
}
