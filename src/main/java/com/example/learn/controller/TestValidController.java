package com.example.learn.controller;

import com.example.learn.entity.User;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description:
 * @Author: wcy
 * @CreateDate: 2022/6/14 14:39
 */
@RestController
public class TestValidController {


    @RequestMapping("testValid1")
    public User testValid(@RequestBody User user) throws Exception {

        return user;
    }
}
