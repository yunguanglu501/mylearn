package com.example.learn.aop;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(1)
@Aspect
@Slf4j
public class ControllerAop {

    @Pointcut("execution(public * com.example.learn.controller..*(..))")
    public void log() {

    }

    @Around("log()")
    public Object doAround(ProceedingJoinPoint joinPoint) throws Throwable {
        // 请求参数
        Signature signature = joinPoint.getSignature();
        log.info("controller:{},method:{},params:{}", signature.getDeclaringType(), signature.getName(), JSON.toJSONString(joinPoint.getArgs()));
        // 执行切面方法
        long start = System.currentTimeMillis();
        Object object = joinPoint.proceed();
        long end = System.currentTimeMillis();
        log.info("调用方法总耗时 time = " + (end - start) + " ms");

        // 执行结果
        log.info("[AOP-log]：Around-执行结果:{}", JSONObject.toJSONString(object));
        return object;
    }

}