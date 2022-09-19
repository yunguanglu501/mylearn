package com.example.learn.exception;

/**
 * 异常状态及信息
 *
 * @author : Xinsl
 * @date : 2022/4/19 14:55
 */
public interface ErrorCode {
    /***
     * 获取状态码
     * @return : {@link int}
     * @author : Xinsl
     * @date : 2022/4/19 14:56
     */
    int getStatus();

    /**
     * 获取消息
     *
     * @return : {@link String}
     * @author : Xinsl
     * @date : 2022/4/19 14:57
     */
    String getMessage();
}
