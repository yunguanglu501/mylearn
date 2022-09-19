package com.example.learn.inteceptor;

/**
 * @Description:
 * @Author: wcy
 * @CreateDate: 2022/7/1 9:19
 */

import com.example.learn.util.ThreadLocalUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;

@Component
public class TokenInterceptor extends HandlerInterceptorAdapter {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String s = UUID.randomUUID().toString();
        System.out.println("interceptor:" + s);
        ThreadLocalUtils.setToken(s);
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        //在方法执行完成移除token
        ThreadLocalUtils.removeToken();
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
    }
}


