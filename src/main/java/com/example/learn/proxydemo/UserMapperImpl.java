package com.example.learn.proxydemo;

/**
 * UserMapperImpl
 *
 * @author wcy
 * @date 2022/8/20
 */
public class UserMapperImpl implements Mapper {
    @Override
    public void connectionJDBC() {
        System.out.println("进行数据库操作 CURD");
    }
}
