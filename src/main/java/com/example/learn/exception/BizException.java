package com.example.learn.exception;

/**
 * 业务异常定义
 *
 * @author : Xinsl
 * @date : 2022/4/19 14:54
 */
public class BizException extends BaseException2 {

    private static final long serialVersionUID = 3524834973760171477L;

    /**
     * 构造方法
     *
     * @param errorCode 错误枚举
     */
    public BizException(ErrorCode2 errorCode) {
        super(errorCode.getCode(), errorCode.getDesc());
    }

    /**
     * 构造方法
     *
     * @param errorCode 错误码
     * @param extraMsg  错误描述
     */
    public BizException(ErrorCode2 errorCode, String extraMsg) {
        super(errorCode.getCode(), extraMsg == null ? errorCode.getDesc() : extraMsg);
    }

    public BizException(String errorCode, String errorMsg) {
        super(errorCode, errorMsg);
    }

    /**
     * 构造方法
     *
     * @param errorCode 错误枚举
     * @param extraMsg  错误描述
     * @param param     参数
     */
    public BizException(ErrorCode2 errorCode, String extraMsg, String param) {
        super(errorCode.getCode(), String.format("%s[%s]", extraMsg, param));
    }

    /**
     * 构造方法
     *
     * @param errorCode 错误枚举
     * @param extraMsg  错误描述
     * @param param     参数
     */
    public BizException(ErrorCode2 errorCode, String extraMsg, Number param) {
        super(errorCode.getCode(), String.format("%s[%s]", extraMsg, param));
    }

}
