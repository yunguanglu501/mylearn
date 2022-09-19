package com.example.learn.controller;

import com.example.learn.service.BizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description:
 * @Author: wcy
 * @CreateDate: 2022/6/9 16:33
 */
@RestController
public class BizController {

    @Autowired
    private BizService bizService;

    /**
     * 对num进行加减乘除操作
     *
     * @param order
     * @param num
     * @return
     */
    @PostMapping("testSuper")
    public String test2(String order, int num) {
        return bizService.getCheckResultSuper(order, num);
    }
}
