package com.example.learn.util;

import cn.hutool.core.text.CharSequenceUtil;
import cn.hutool.core.util.ArrayUtil;
import cn.hutool.crypto.SecureUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import io.netty.handler.codec.mqtt.MqttMessageIdAndPropertiesVariableHeader;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.CollectionUtils;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.servlet.HandlerMapping;
import org.springframework.web.util.ContentCachingRequestWrapper;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Map;
import java.util.UUID;

/**
 * @Description:
 * @Author: wcy
 * @CreateDate: 2022/6/28 17:40
 */
@Slf4j
public class SignUtil {

    //    public static void main(String[] args) {
//        String replace = UUID.randomUUID().toString().replace("-", "").replace("_", "");
//        System.out.println("replace = " + replace);
//    }
    private static final String DEFAULT_SECRET = "1513678f0c8945de9eb369319b7b18e8";

    public static String sign(String body, Map<String, String[]> params, String[] paths) {
        StringBuilder sb = new StringBuilder();
        if (CharSequenceUtil.isNotBlank(body)) {
            sb.append(body).append('#');
        }

        if (!CollectionUtils.isEmpty(params)) {
            params.entrySet()
                    .stream()
                    .sorted(Map.Entry.comparingByKey())
                    .forEach(paramEntry -> {
                        String paramValue = String.join(",", Arrays.stream(paramEntry.getValue()).sorted().toArray(String[]::new));
                        sb.append(paramEntry.getKey()).append("=").append(paramValue).append('#');
                    });
        }

        if (ArrayUtil.isNotEmpty(paths)) {
            String pathValues = String.join(",", Arrays.stream(paths).sorted().toArray(String[]::new));
            sb.append(pathValues);
        }
        String join = String.join("#", DEFAULT_SECRET, sb.toString());
        System.out.println("join = " + join);
        return SecureUtil.sha256(String.join("#", DEFAULT_SECRET, sb.toString()));
    }

    public static String generatedSignature(HttpServletRequest request) {
        // @RequestBody
        String bodyParam = null;
        if (request instanceof ContentCachingRequestWrapper) {
            bodyParam = new String(((ContentCachingRequestWrapper) request).getContentAsByteArray(), StandardCharsets.UTF_8);
        }

        // @RequestParam
        Map<String, String[]> requestParameterMap = request.getParameterMap();

        // @PathVariable
        String[] paths = null;
        ServletWebRequest webRequest = new ServletWebRequest(request, null);
//        Map<String, String> uriTemplateVars = (Map<String, String>) webRequest.getAttribute(
//                HandlerMapping.URI_TEMPLATE_VARIABLES_ATTRIBUTE, RequestAttributes.SCOPE_REQUEST);

        String jsonString = JSON.toJSONString(webRequest.getAttribute(
                HandlerMapping.URI_TEMPLATE_VARIABLES_ATTRIBUTE, RequestAttributes.SCOPE_REQUEST));
        Map<String, String> uriTemplateVars = fastjson2map(jsonString);
        System.out.println("uriTemplateVars = " + uriTemplateVars);
        if (!CollectionUtils.isEmpty(uriTemplateVars)) {
            paths = uriTemplateVars.values().toArray(new String[0]);
        }
        log.info("body: {},requestParameterMap:{},paths:{}", bodyParam, JSON.toJSONString(requestParameterMap), paths);
        String sign = SignUtil.sign(bodyParam, requestParameterMap, paths);
        System.out.println("sign = " + sign);
        return sign;
    }

    public static Map<String, String> json2map(String jsonStr) {
        Map<String, String> res = null;
        Gson gson = new Gson();
        res = gson.fromJson(jsonStr, new TypeToken<Map<String, String>>() {
              }.getType());
        return res;
    }

    public static Map<String, String> fastjson2map(String jsonStr) {
        return JSONObject.parseObject(jsonStr, new TypeReference<Map<String, String>>() {
        });
    }
}
