package com.example.learn.proxydemo;

/**
 * TestM
 *
 * @author wcy
 * @date 2022/8/20
 */
public class TestM {
    public static void main(String[] args) {
        UserMapperImpl userMapper = new UserMapperImpl();
        ProxyHandler proxyHandler = new ProxyHandler(userMapper);
        Mapper mapper = (Mapper) proxyHandler.getNewInstance();
        mapper.connectionJDBC();
    }
}
