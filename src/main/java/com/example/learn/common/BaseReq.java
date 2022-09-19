package com.example.learn.common;

import java.io.Serializable;

/**
 * @Description:
 * @Author: wcy
 * @CreateDate: 2022/6/14 16:27
 */
public class BaseReq implements Serializable {

    private static final long serialVersionUID = -3331667639032924430L;
    private String reqSystem;
    private String traceId;
    private String userNo;

    public BaseReq() {
    }

    public String getReqSystem() {
        return this.reqSystem;
    }

    public String getTraceId() {
        return this.traceId;
    }

    public String getUserNo() {
        return this.userNo;
    }

    public void setReqSystem(String reqSystem) {
        this.reqSystem = reqSystem;
    }

    public void setTraceId(String traceId) {
        this.traceId = traceId;
    }

    public void setUserNo(String userNo) {
        this.userNo = userNo;
    }

    public String toString() {
        return "BaseReq(reqSystem=" + this.getReqSystem() + ", traceId=" + this.getTraceId() + ", userNo=" + this.getUserNo() + ")";
    }
}
