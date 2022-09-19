//package com.example.learn.controller;
//
///**
// * @Description:
// * @Author: wcy
// * @CreateDate: 2022/6/28 17:41
// */
//
//import com.alibaba.fastjson.JSON;
//import com.alibaba.fastjson.TypeReference;
//import com.example.learn.anno.Signature;
//import com.example.learn.common.Result;
//import com.example.learn.entity.User;
//import com.example.learn.exception.BizException;
//import com.example.learn.util.SignUtils;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.Map;
//
///**
// * @author pdai
// */
//@RestController
//@RequestMapping("user")
//public class SignTestController {
//
//    @Signature
//    @PostMapping("test/{id}/{keys}")
//    public Result<String> myController(@PathVariable String id, @PathVariable String keys
//            , @RequestParam String client
//            , @RequestBody User user) {
//        return Result.of(String.join(",", id, keys, client, user.toString()));
//    }
//
//
//    @PostMapping("testSign2")
//    public Result<String> testSign2(@RequestBody User user) {
//        validSign(user);
//        return Result.of(String.join(user.toString()));
//    }
//
//    private void validSign(User user) {
//        if (user == null || user.getSign() == null) {
//            return;
//        }
//        try {
//            //转换成Map
//            Map<String, Object> stringObjectMap =
//                    JSON.parseObject(JSON.toJSONString(user), new TypeReference<Map<String, Object>>() {
//                    });
//            System.out.println("stringObjectMap = " + stringObjectMap);
//            String sign = SignUtils.getSign(stringObjectMap, "123");
//            if (!user.getSign().equals(sign)) {
//                throw new BizException("111222333", "sign不正确");
//            }
//        } catch (Exception e) {
//            throw new BizException("111222333", "sign不正确");
//        }
//    }
//
//}