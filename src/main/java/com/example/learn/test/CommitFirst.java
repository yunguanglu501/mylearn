package com.example.learn.test;

import org.springframework.util.StringUtils;

import java.nio.charset.StandardCharsets;

/**
 * @Description:
 * @Author: wcy
 * @CreateDate: 2022/6/10 17:35
 */
public class CommitFirst {

    public static void main(String[] args) {
//        String x = " a c d";
//        String tableName = StringUtils.trimWhitespace(x);
//        System.out.println("tableName =" + tableName);
//        String tableName1 = StringUtils.trimAllWhitespace(x);
//        System.out.println("tableName1 = " + tableName1);
//        String url = "https://www.baidu.com/s?wd=spring%20cloud%20commons%20%E5%8A%A0%E5%AF%86%E8%A7%A3%E5%AF%86&rsv_spt=1&rsv_iqid=0xc25bf1720001a9bd&issp=1&f=8&rsv_bp=1&rsv_idx=2&ie=utf-8&tn=baiduhome_pg&rsv_dl=tb&rsv_enter=1&rsv_sug3=34&rsv_sug1=8&rsv_sug7=100&rsv_sug2=0&rsv_btype=i&inputT=8714&rsv_sug4=9165";
//        String tableName2 = StringUtils.uriDecode(url, StandardCharsets.UTF_8);
//        System.out.println("tableName2 = " + tableName2);
        String u = "a.jpg";
        String filenameExtension = StringUtils.getFilenameExtension(u);
        System.out.println("filenameExtension = " + filenameExtension);
        String x = "a/b/c.jpg";
    }
}
