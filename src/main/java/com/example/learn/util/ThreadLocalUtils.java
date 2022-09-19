package com.example.learn.util;

/**
 * @Description:
 * @Author: wcy
 * @CreateDate: 2022/7/1 9:17
 */
public class ThreadLocalUtils {

    private static ThreadLocal<String> tokenThreadLocal = new ThreadLocal<>();

    public static void setToken(String token){
        tokenThreadLocal.set(token);
    }

    public static String getToken(){
        return tokenThreadLocal.get();
    }
    public static void removeToken(){
        if(tokenThreadLocal.get() != null){
            tokenThreadLocal.remove();
        }
    }
}
