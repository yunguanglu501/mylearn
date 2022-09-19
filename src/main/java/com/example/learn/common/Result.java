package com.example.learn.common;

import java.io.Serializable;
import java.util.List;
import java.util.StringJoiner;

/**
 * @Description:
 * @Author: wcy
 * @CreateDate: 2022/6/14 15:38
 */
public class Result<T> implements Serializable {
    private static final long serialVersionUID = -579455000023395631L;

    private String callId;
    private boolean success;
    private T result;
    private String errorCode;
    private String errorMsg;

    public Result() {
    }

    public Result(T result) {
        this.success = true;
        this.result = result;
    }

    public Result(String errorCode, String errorMsg) {
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }

    public static <T extends Serializable> Result<T> of(T data) {
        return new Result(data);
    }

    public static <T extends Serializable> Result<List<T>> of(List<T> data) {
        return new Result(data);
    }

    public static <T extends Serializable> Result<T> ofFail(String errorCode, String errorMsg) {
        return new Result(errorCode, errorMsg);
    }

    public static <T extends Serializable> Result<List<T>> ofFailList(String errorCode, String errorMsg) {
        return new Result(errorCode, errorMsg);
    }

    public boolean isSuccess() {
        return this.success;
    }

    public T getResult() {
        return this.result;
    }

    public void setResult(T result) {
        this.result = result;
    }

    public String getErrorCode() {
        return this.errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMsg() {
        return this.errorMsg;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public String getCallId() {
        return this.callId;
    }

    public void setCallId(String callId) {
        this.callId = callId;
    }

    @Override
    public String toString() {
        return (new StringJoiner(", ", Result.class.getSimpleName() + "[", "]")).add("callId=" + this.callId).add("success=" + this.success).add("result=" + this.result).add("errorCode='" + this.errorCode + "'").add("errorMsg='" + this.errorMsg + "'").toString();
    }
}
