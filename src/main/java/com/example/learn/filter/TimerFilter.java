package com.example.learn.filter;

import javax.servlet.*;
import java.io.IOException;

/**
 * @Description:
 * @Author: wcy
 * @CreateDate: 2022/6/15 10:05
 */
public class TimerFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        long begin = System.currentTimeMillis();
        System.out.println("[Filter-Time]：进入Filter");
        // 执行servlet方法（如拦截请求，不执行Servlet，可不执行此方法）
        filterChain.doFilter(servletRequest, servletResponse);
        long end = System.currentTimeMillis();
        System.out.println("[Filter-Time]：结束Filter，共" + (end - begin) + "毫秒");
    }
}
