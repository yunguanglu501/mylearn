package com.example.learn.exception;

/**
 * @Description:
 * @Author: wcy
 * @CreateDate: 2022/6/14 16:38
 */
public class BaseException2 extends RuntimeException{
    private String errorCode;
    private String errorMsg;

    public BaseException2(String errorCode, String errorMsg) {
        super(errorMsg);
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }

    public BaseException2(ErrorCode2 errorCode) {
        this(errorCode.getCode(), errorCode.getDesc());
    }

    public BaseException2(String message) {
        super(message);
    }

    public BaseException2() {
    }

    public String getErrorCode() {
        return this.errorCode;
    }

    public String getErrorMsg() {
        return this.errorMsg;
    }
}
