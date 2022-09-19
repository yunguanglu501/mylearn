package com.example.learn.fx;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;

import java.io.Serializable;


public class CommonResult<T> implements Serializable {

    private int ret;
    private String msg;
    private T data;

    public int getRet() {
        return ret;
    }

    public void setRet(int ret) {
        this.ret = ret;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }


    public static <T> CommonResult<T> parseResultV2(String json, Class<T> clazz) {
        CommonResult<T> tCommonResult = JSON.parseObject(json, new TypeReference<CommonResult<T>>(clazz) {
        });
        T data1 = tCommonResult.getData();
        return tCommonResult;
    }

    public static <T> T parseResultV3(String json, Class<T> clazz) {
        CommonResult<T> tCommonResult = JSON.parseObject(json, new TypeReference<CommonResult<T>>(clazz) {
        });
        return tCommonResult.getData();
    }
}
