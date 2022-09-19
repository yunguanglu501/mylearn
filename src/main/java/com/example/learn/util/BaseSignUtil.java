package com.example.learn.util;

import cn.hutool.core.text.CharSequenceUtil;
import cn.hutool.core.util.ArrayUtil;
import cn.hutool.crypto.SecureUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.servlet.HandlerMapping;
import org.springframework.web.util.ContentCachingRequestWrapper;

import javax.servlet.http.HttpServletRequest;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Map;
import java.util.Set;

/**
 * @Description:
 * @Author: wcy
 * @CreateDate: 2022/6/28 17:40
 */
@Slf4j
public class BaseSignUtil {

//    private static final String DEFAULT_SECRET = "1513678f0c8945de9eb369319b7b18e8";
//
//    /**
//     * 获取字符的ascII码
//     *
//     * @param str 请求字符串
//     * @return 响应结果
//     */
//    public static int getStrAscii(String str) {
//        int asciiValue = 0;
//        if (StringUtils.hasText(str)) {
//            char[] chars = str.toCharArray();
//            for (char ch : chars) {
//                asciiValue = ((int) ch) + asciiValue;
//            }
//        }
//        return asciiValue;
//    }
//
//    /**
//     * 参数签名
//     *
//     * @param map map
//     * @return 响应签名结果
//     */
//    public String getSign(Map<String, Object> map, String key) {
//        StringBuilder sb = new StringBuilder();
//        Set<String> keyList = map.keySet();
//        keyList.stream().sorted((s1, s2) -> getStrAscii(s1) - getStrAscii(s2)).forEach((t) -> {
//            if (!SysConstants.SIGN.equals(t)) {
//                sb.append(t).append("=").append(map.get(t)).append("&");
//            }
//        });
//        String s = sb.toString();
//        //加签内容
//        String encryptedContent = s.substring(0, s.length() - 1) + key;
//        String sign = MD5Util.getMD5(encryptedContent);
//        log.info("签名原文：{}，签名串：{}", encryptedContent, sign);
//        //密文
//        return sign;
//    }

}