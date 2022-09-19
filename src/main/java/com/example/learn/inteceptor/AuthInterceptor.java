package com.example.learn.inteceptor;

/**
 * @Description:
 * @Author: wcy
 * @CreateDate: 2022/6/15 10:09
 */

import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

/**
 * 鉴权Interceptor
 */
@Component
public class AuthInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("[Interceptor-auth]：进入preHandle");
        if (handler instanceof HandlerMethod) {
            HandlerMethod handlerMethod = (HandlerMethod) handler;
            System.out.println("[Interceptor-auth]：访问信息=" + handlerMethod.getShortLogMessage());
            // 获取head鉴权信息
            String sign = request.getHeader("sign");
            if (!"123456".equals(sign)) {
                // 鉴权不通过
                response.setCharacterEncoding("utf-8");
                response.setContentType("application/json; charset=utf-8");
                PrintWriter writer = response.getWriter();
                JSONObject jsonObject = new JSONObject();
                jsonObject.put("success", false);
                jsonObject.put("message", "鉴权失败");
                writer.write(jsonObject.toJSONString());
                writer.flush();
                writer.close();
                System.out.println("[Interceptor-auth]：----------鉴权不通过----------");
                System.out.println("[Interceptor-auth]：结束preHandle");
                return false;
            } else {
                // 鉴权通过
                System.out.println("[Interceptor-auth]：----------鉴权通过----------");
                System.out.println("[Interceptor-auth]：结束preHandle");
                return true;
            }
        }
        System.out.println("[Interceptor-auth]：结束preHandle");
        // 返回true为通过校验，返回false为不通过校验
        return true;
    }

//    @Override
//    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
//        System.out.println("[Interceptor-auth]：postHandle ModelAndView=" + JSONObject.toJSONString(modelAndView));
//    }
//
//    @Override
//    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
//        System.out.println("[Interceptor-auth]：afterCompletion Exception=" + JSONObject.toJSONString(ex));
//    }
}
