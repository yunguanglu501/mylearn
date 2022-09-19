package com.example.learn.config;

/**
 * @Description:
 * @Author: wcy
 * @CreateDate: 2022/6/15 13:56
 */

import com.example.learn.anno.ResponseResult;
import com.example.learn.common.BaseResult;
import com.example.learn.common.DefaultErrorResult;
import com.example.learn.common.HeaderConstants;
import com.example.learn.common.PlatformResult;
import com.example.learn.enums.ApiStyleEnum;
import com.example.learn.exception.RequestContextUtil;
import com.example.learn.inteceptor.ResponseResultInterceptor;
import com.example.learn.util.JsonUtil;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import javax.servlet.http.HttpServletRequest;

/**
 * @desc 接口响应体处理器

 */
@ControllerAdvice
public class ResponseResultHandler implements ResponseBodyAdvice<Object> {

    @Override
    public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
        HttpServletRequest request = RequestContextUtil.getRequest();
        ResponseResult responseResultAnn = (ResponseResult) request.getAttribute(ResponseResultInterceptor.RESPONSE_RESULT);
        return responseResultAnn != null && !ApiStyleEnum.NONE.name().equalsIgnoreCase(request.getHeader(HeaderConstants.API_STYLE));
    }

    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType, Class<? extends HttpMessageConverter<?>> selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {
        ResponseResult responseResultAnn = (ResponseResult) RequestContextUtil.getRequest().getAttribute(ResponseResultInterceptor.RESPONSE_RESULT);

        Class<? extends BaseResult> resultClazz = responseResultAnn.value();

        if (resultClazz.isAssignableFrom(PlatformResult.class)) {
            if (body instanceof DefaultErrorResult) {
                DefaultErrorResult defaultErrorResult = (DefaultErrorResult) body;
                return PlatformResult.builder()
                        .code(defaultErrorResult.getCode())
                        .msg(defaultErrorResult.getMessage())
                        .data(defaultErrorResult.getErrors())
                        .build();
            } else if (body instanceof String) {
                return JsonUtil.object2Json(PlatformResult.success(body));
            }

            return PlatformResult.success(body);
        }

        return body;
    }

}
