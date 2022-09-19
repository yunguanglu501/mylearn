package com.example.learn.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 错误码枚举类
 *
 * @author wangh
 * date 2022/3/9
 */
@Getter
@AllArgsConstructor
public enum BizErrorCode implements ErrorCode2 {

    /**
     * 重复请求
     */
    REPEAT_REQUEST("REPEAT_REQUEST", "重复请求,请稍后再试！"),
    /**
     * 查询信息不存在
     */
    QUERY_INFO_NOT_EXIST("QUERY_INFO_NOT_EXIST", "查询信息不存在"),
    /**
     * 远程调用失败
     */
    REMOTE_INVOKE_FAILED("REMOTE_INVOKE_FAILED", "远程调用失败"),
    
    /**
     * 参数校验异常
     */
    PARAMETER_VALID_ERROR("PARAMETER_VALID_ERROR", "参数校验异常"),
    
    TASK_SHARD_PARM_ERROR("TASK_SHARD_PARM_ERROR", "分片错误"),

    /**
     * 获取工作台token异常
     */
    GET_PC_TOKEN_ERROR("PARAMETER_VALID_ERROR", "参数校验异常"),

    ;

    /**
     * 错误编码
     */
    private String code;
    /**
     * 错误描述
     */
    private String desc;

    @Override
    public String getCode() {
        return null;
    }

    @Override
    public String getDesc() {
        return null;
    }
}
