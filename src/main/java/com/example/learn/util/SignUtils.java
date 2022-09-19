//package com.example.learn.util;
//
//import com.alibaba.fastjson.JSON;
//import com.alibaba.fastjson.TypeReference;
//import com.example.learn.entity.User;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.util.StringUtils;
//
//import java.util.Map;
//import java.util.Set;
//import java.util.TreeMap;
//import java.util.UUID;
//
///**
// * MD5工具类
// */
//@Slf4j
//public class SignUtils {
//
//    private static final String SIGN = "sign";
//
//    private SignUtils() {
//    }
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
//     * 按照ascii码值顺序排序
//     * 参数签名
//     *
//     * @param map map
//     * @return 响应签名结果
//     */
//    public static String getSign(Map<String, Object> map, String key) {
//        StringBuilder sb = new StringBuilder();
//        Set<String> keyList = map.keySet();
//        keyList.stream().sorted((s1, s2) -> getStrAscii(s1) - getStrAscii(s2)).forEach((t) -> {
//            if (!SIGN.equals(t)) {
//                sb.append(t).append("=").append(map.get(t)).append("&");
//            }
//        });
//        String s = sb.toString();
//        //加签内容
//        String encryptedContent = s.substring(0, s.length() - 1) + key;
//        String sign = MD5Util.getMD5(encryptedContent);
//        log.debug("签名原文：{}，签名串：{}", encryptedContent, sign);
//        return sign;
//    }
//
//    /**
//     * 按照key字母顺序排序
//     * 参数签名
//     *
//     * @param map map
//     * @return 响应签名结果
//     */
//    public static String getSignForKeySort(Map<String, Object> map, String key) {
//        StringBuilder sb = new StringBuilder();
//        Map<String, Object> map1 = new TreeMap(map);
//        for (String mapKey : map1.keySet()) {
//            if (!SIGN.equals(mapKey)) {
//                sb.append(mapKey).append("=").append(map1.get(mapKey)).append("&");
//            }
//        }
//        String s = sb.toString();
//        //加签内容
//        String encryptedContent = s.substring(0, s.length() - 1) + key;
//        String sign = MD5Util.getMD5(encryptedContent);
//        log.debug("签名原文：{}，签名串：{}", encryptedContent, sign);
//        return sign;
//    }
//
//    public static void main(String[] args) {
//        UUID uuid = UUID.randomUUID();
//        /**
//         * 6c0222ede7f54cada717a9abfb372239
//         */
//        System.out.println(uuid.toString().replace("-", ""));
//
//        User user = new User();
//        user.setPassword("123456");
//        user.setUsername("张三");
//        Map<String, Object> stringObjectMap =
//                JSON.parseObject(JSON.toJSONString(user), new TypeReference<Map<String, Object>>() {
//                });
//        System.out.println("stringObjectMap = " + stringObjectMap);
//        String sign = SignUtils.getSign(stringObjectMap, "123");
//        System.out.println("sign = " + sign);
//    }
//}
