package com.example.learn.config;

import com.example.learn.filter.RequestCachingFilter;
import com.example.learn.filter.TimerFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

/**
 * @Description:
 * @Author: wcy
 * @CreateDate: 2022/6/15 10:06
 */
@Configuration
public class WebFilterConfig {
    @Bean
    public FilterRegistrationBean timerFilter() {
        FilterRegistrationBean registrationBean = new FilterRegistrationBean();
        // 设置：实现类
        registrationBean.setFilter(new TimerFilter());
        // 设置：UrlPatterns
        registrationBean.setUrlPatterns(Arrays.asList("/*"));
        // 设置：优先级
        registrationBean.setOrder(1);
        return registrationBean;
    }



    @Bean
    public RequestCachingFilter requestCachingFilter() {
        return new RequestCachingFilter();
    }

    @Bean
    public FilterRegistrationBean requestCachingFilterRegistration(
            RequestCachingFilter requestCachingFilter) {
        FilterRegistrationBean bean = new FilterRegistrationBean(requestCachingFilter);
        bean.setOrder(1);
        return bean;
    }
}
