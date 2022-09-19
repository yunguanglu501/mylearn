package com.example.learn.anno;

import com.example.learn.common.BaseResult;
import com.example.learn.common.PlatformResult;

import java.lang.annotation.*;

/**
 * @Description:
 * @Author: wcy
 * @CreateDate: 2022/6/15 11:16
 */
@Target({ ElementType.TYPE, ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ResponseResult {



    Class<? extends BaseResult>  value() default PlatformResult.class;
}
