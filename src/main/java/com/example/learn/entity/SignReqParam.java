package com.example.learn.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Description:
 * @Author: wcy
 * @CreateDate: 2022/6/28 17:01
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SignReqParam {


    private String accessKey;
    private long time;
    private String nonce;
    private int encrypt;
    private String version;
    private String secretKey;
    private String data;

}
