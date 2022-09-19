package com.example.learn.fenye;

import lombok.Data;

import java.io.Serializable;

/**
 * Doctor
 *
 * @author wcy
 */
@Data
public class Doctor implements Serializable {
    private static final long serialVersionUID = 1162127262702473015L;
    /**
     * 医生id
     */
    private Long doctorId;

    /**
     * 医生名称
     */
    private String doctorName;

    /**
     * 医生性别
     */
    private String doctorSex;
}
