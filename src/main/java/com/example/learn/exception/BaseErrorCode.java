package com.example.learn.exception;

/**
 * 错误枚举
 *
 * @author : Xinsl
 * @date : 2022/4/19 14:53
 */
public enum BaseErrorCode implements ErrorCode {
    SYSTEM_INNER_ERROR(5000, "系统内部异常"),
    DATA_INSERT_ERROR(5001, "数据插入失败"),
    DATA_UPDATE_ERROR(5002, "数据更新失败"),
    PARAMETER_PARAM_IS_NULL(5004, "请求参数为空"),
    PARAMETER_VALID_NOT_PASS(5005, "参数校验不通过"),
    REMOTE_SERVICE_INVOKE_FAIL(5006, "远程服务调用返回失败"),
    REMOTE_SERVICE_UNKNOWN_RESULT(5007, "远程服务调用返回未决结果"),
    ARGUMENT_PARM_ERROR(5008, "输入参数异常"),
    BIZ_ID_PARAM_ERROR(5009, "业务编号生成器参数错误"),
    BIZ_ID_TYPE_ERROR(5010, "业务系统自定义业务序号类型长度错误"),
    SUBSTRING_PARAM_ERROR(5011, "截取字符串参数错误"),
    REPEAT_REQUEST(5012, "重复请求，幂等失败"),
    NUMBER_MAX(5013, "超出申请次数，申请失败"),
    MedicalCard_REGISTER_REPEAT(5013, "绑定失败，就诊人身份信息已存在"),
    MedicalCard_REGISTER_ERROR(5014, "建卡失败，请重试"),
    MedicalCard_EDIT_ERROR(5015, "修改失败"),
    PATIENT_DOES_NOT_EXIST(5016, "患者不存在"),
    AUTHORIZATION_REVOKED(5017, "该授权请求已撤回，授权失败"),
    MEDICAL_CARD_BOUND(5018, "该卡号已被绑定"),
    MedicalCard_REGISTER_CHILDREN(5019, "建卡失败，儿童卡年龄不允许大于14岁"),
    USER_NOT_ATTHORIZED(5019, "该用户无权操作此卡"),
    ATTHORIZED_IN_PROGRESS(5020, "正在授权中，不可再次发起授权"),
    LABEL_COUNT_MAX(5021, "标签数量以达到上限"),
    LABEL_REPETITIVE_ERROR(5022, "标签已存在,请重新输入"),
    LABEL_BINDING_DEPARTMENT(5023, "该标签已被科室绑定,请勿删除"),
    INTRODUCE_IS_EXIST(5024, "该科室介绍已存在"),
    INTRODUCE_IS_NULL(5025, "未查询到该科室简介信息"),
    COLUMN_IS_EXIST(5026, "该科室栏目名称已经存在"),
    STAR_DOCTOR_IS_EXIST(5027, "该明星医生已存在"),
    VERIFYCODE_ERROR(5028, "验证码错误"),
    VERIFYCODE_DOES_NOT_EXIST(5029, "验证码已过期"),
    MEDICALCARD_REGISTER_ERROR_WEINI(5030, "卫宁卡号获取失败"),
    MEDICALCARD_VOLIDATION_NAME_ERROR(5031, "姓名最少两个字"),
    MedicalCard_REGISTER_ADULT(5032, "建卡失败，就诊卡年龄不允许小于14岁"),
    HIS_DOCTOR_YANSU_FAIL(5033, "医生信息查询失败(严肃)"),
    HIS_DOCTOR_YANSU_ERROR(5033, "医生信息查询错误(严肃)"),
    HIS_DOCTOR_PARAM_ERROR(5034, "医生ID与医生姓名只能同时输入一个"),
    WEINI_SHIFT_SCHEDULING_DATE_QUERY_ERROR(5035, "医生排班日期查询错误"),
    WEINI_SHIFT_SCHEDULING_INFO_QUERY_ERROR(5036, "医生排班信息查询错误"),
    FAILED_TO_CREATE_RESERVATION_FORM(5037, "平台预约失败"),
    FAILED_TO_QUERY_USER_ID(5038, "查询用户id失败"),
    PROPERTY_VALUE_QUERY_FAILED(5039, "属性值查询失败"),
    WEINI_APPOINTMENT_FAILED(5040, "预约失败"),
    DOCTOR_NOT_AUTH(5100, "请在应用市场搜索\"复星健康医生端\"完成认证"),
    CONSULT_NOT_FOUND(5101, "未查询到对应问诊单记录"),
    EMPLOYEE_ID_DIFFERENT(5102, "第三方工号与问诊记录工号不同"),
    OWN_CARD_INFO_EXISTS(5034, "建卡失败，本人卡信息已存在"),
    CARDHOLDER_AUTHENTICATION_FAILED(6001, "持卡人身份校验失败"),
    REAL_NAME_AUTHENTICATION_FAILED(6002, "实名校验失败，请重试"),
    ID_NAME_MATCH_FAILED(6003, "身份证与姓名匹配失败，请重试"),
    ABNORMAL_IDENTITY_INFORMATION(6004, "身份信息异常"),
    ACCOUNT_MISMATCH(5029, "该授权请求与登录账号不匹配，请稍后重试"),
    TO_AUTHORIZE(5030, "已拒绝授权"),
    CANCEL_AUTHORIZE(5031, "用户已取消授权申请"),
    AGREE_AUTHORIZE(5032, "已同意授权"),
    AUTH_VERIFICATION_FAILED(5033, "持卡人身份校验失败"),
    RESEND_AUTH_FAILURE(5034, "重发授权失败,请稍后重试"),
    RESEND_FAILURE_TIME_LESS_FIVE(5035, "重发授权小于5分钟,请稍后重试"),
    AUTH_INDO_NEGATION(5036, "授权信息不存在，请下拉刷新页面"),
    PATIENT_CARD_RELAT_NEGATION(5037, "页面数据已过期，请下拉刷新"),
    MEDICAL_CARD_INFO_NEGATION(5037, "页面数据已过期，请下拉刷新"),
    UNIONID_ISNULL(5038, "调用用户中心获取unionid为NULL"),
    HIS_DOCTOR_QCCODE_FAIL(5039, "导出医生二维码失败"),
    CONCERNED_ABOUT_DOCTORS(5040, "您已关注该医生"),
    ELECTRONIC_CARD_UNBOUND_FAILED(5041, "电子卡不允许解绑"),
    HIS_DOCTOR_QCCODE_NULL(5042, "未查询到该医生二维码"),
    TEMPORARY_AUTH_FAILURE(5043, "临时授权失败,请稍后重试");

    private final int status;
    private final String message;

    @Override
    public int getStatus() {
        return this.status;
    }

    @Override
    public String getMessage() {
        return this.message;
    }

    private BaseErrorCode(int status, String message) {
        this.status = status;
        this.message = message;
    }
}
