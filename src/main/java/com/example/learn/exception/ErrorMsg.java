package com.example.learn.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author Sun.ml
 */
@Getter
@AllArgsConstructor
public enum ErrorMsg {

    /**
     * 手机号为空
     */
    PHONE_ISNULL(-1000, "手机号为空")

    /**
     * 手机号不匹配
     */
    ,PHONE_NUMBER_MISMATCH(-1001, "手机号不匹配")

    /**
     * 未查询到相关患者信息
     */
    ,PATIENT_INFO_ISNULL(-1002, "未查询到相关患者信息")

    /**
     * 未查询到相关账号信息
     */
    ,ACCOUNT_INFO_ISNULL(-1003, "未查询到相关账号信息")

    /**
     * 未查询到患者身份信息
     */
    ,PATIENT_IDENTIFICATION_ISNULL(-1004, "未查询到患者身份信息")

    /**
     * 身份信息不匹配
     */
    ,IDENTIFICATION_INFO_MISMATCH(-1005, "身份信息不匹配")

    /**
     * 就诊人信息已存在
     */
    ,INSERT_PATIENT_INFO_FAIL(-1006, "就诊人信息已存在")

    /**
     * 新增就诊卡关系记录失败
     */
    ,INSERT_PATIENT_RELATION_INFO_FAIL(-1007, "新增就诊卡关系记录失败")

    /**
     * 身份证号格式不匹配
     */
    ,IDENTITY_CARD_MISMATCH(-1008, "身份证号格式不匹配");


    /**
     * 错误码
     */
    private int code;

    /**
     * 错误信息
     */
    private String msg;
}