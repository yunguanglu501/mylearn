package com.example.learn.controller;

import com.alibaba.fastjson.JSON;
import com.example.learn.entity.Student;
import com.example.learn.exception.BusinessException;
import com.example.learn.exception.ResultCode;
import com.example.learn.shipeiqi.ListAdapter;
import com.example.learn.shipeiqi.ServiceV1;
import com.google.common.collect.Lists;
import groovy.transform.AutoClone;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description:
 * @Author: wcy
 * @CreateDate: 2022/6/30 17:42
 */
@RestController
@RequestMapping("spq")
public class ShiPeiQiController {

    @Autowired
    ServiceV1 serviceV1;



    @RequestMapping("v1")
    public void selectOneResult() {
        //Map<Integer, String> map = new HashMap<>();
        //map.put(0, "v1");
        //map.put(1, "v2");

        // 1.获取集合类型用户
        List member = Lists.newArrayList(0,1);

        ListAdapter listAdapter = new ListAdapter(member);
        serviceV1.froOrderMap(listAdapter);
    }
}
