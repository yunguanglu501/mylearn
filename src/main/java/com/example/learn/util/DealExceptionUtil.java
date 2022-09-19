package com.example.learn.util;

import com.example.learn.common.Result;
import com.example.learn.exception.BaseErrorCode;
import com.example.learn.exception.BaseException;
import lombok.extern.slf4j.Slf4j;

import java.io.Serializable;

@Slf4j
public class DealExceptionUtil {

    /**
     * 私有构建函数
     */
    protected DealExceptionUtil() {
    }

    /**
     * 1.统一异常处理
     *
     * @param err 异常
     * @return 外部响应对象
     */
    public static <T extends Serializable> Result<T> doExceptionService(Throwable err) {
        Result<T> result = new Result<>();
        if (err instanceof BaseException) {
            BaseException e = (BaseException) err;
            result.setErrorCode("" + e.getStatus());
            result = new Result<>("" + e.getStatus(), e.getMessage());
        } else {
            log.error("【统一异常处理】 出现其他异常：{}", err);
            result = new Result<>("" + BaseErrorCode.SYSTEM_INNER_ERROR.getStatus(), BaseErrorCode.SYSTEM_INNER_ERROR.getMessage());
        }
        log.info("exception result is {}", result);
        return result;
    }

}
