package com.example.learn.util;

import cn.hutool.poi.excel.ExcelUtil;
import cn.hutool.poi.excel.ExcelWriter;
import com.example.learn.entity.User;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: wcy
 * @Date: 2022/7/8 14:39
 * @Version 1.0
 */
public class ExportUtil {
    public static void main(String[] args) {
        //获取的对象List即可
        List<User> users = new ArrayList<>();
        User user;
        for (int i = 1; i <= 500000; i++) {
            user = new User();
            user.setName("张" + i);
            user.setGender("男" + i);
            user.setAge(11);
            users.add(user);
        }
//将对象填充到数组rows


// 通过工具类创建writer
        ExcelWriter writer = ExcelUtil.getWriter("d:/writeBeanTest.xlsx");
// 合并单元格后的标题行，使用默认标题样式

// 一次性写出内容，使用默认样式，强制输出标题
        writer.write(users, true);
// 关闭writer，释放内存
        writer.close();
    }
}
