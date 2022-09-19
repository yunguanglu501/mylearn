package com.example.learn.entity;

import cn.hutool.core.date.DateUtil;
import com.alibaba.fastjson.JSONObject;
import com.google.common.base.Splitter;

import java.io.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

/**
 * SerializableTest
 *
 * @author wcy
 * @date 2022/8/25
 */
public class SerializableTest {

    private static void serialize(SeriUser user) throws Exception {
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(new File("D:\\111.txt")));
        oos.writeObject(user);
        oos.close();
    }

    private static SeriUser deserialize() throws Exception {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(new File("D:\\111.txt")));
        return (SeriUser) ois.readObject();
    }

    public static void main(String[] args) throws Exception{
        // SeriUser user = new SeriUser();
        // user.setName("tyshawn");
        // user.setAge(18);
        // System.out.println("序列化前的结果: " + user);
        //
        // // serialize(user);
        //
        // SeriUser dUser = deserialize();
        // System.out.println("反序列化后的结果: " + dUser);
        //
        //
        //     String test = "  河南商丘,767,32,,哈哈 ";
        //     List<String> lists = Splitter.on(',').omitEmptyStrings().trimResults().splitToList(test);
        //     System.out.println(lists);
        // List<String> list = Lists.newArrayList("a","b","c"," ");
        // String s = Joiner.on(",").join(list); // 以逗号分割
        // System.out.println(s); // a,b,c,
        // Splitter split = Splitter.on(',').trimResults().omitEmptyStrings(); // 去前后空格&&去空string
        // List<String> list1 = split.splitToList(s);
        // System.out.println(JSON.toJSONString(list1)); // ["a","b","c"]

        // String x = null;
        // String s = JSONObject.toJSONString(x);
        // System.out.println("s = " + s);
        //
        // JSONObject jsonObject = JSONObject.parseObject(x);
        // System.out.println("jsonObject = " + jsonObject);

        String s = DateUtil.formatLocalDateTime(LocalDateTime.now());
        System.out.println("s = " + s);

        String s1 = DateUtil.formatDate(new Date());
        System.out.println("s1 = " + s1);
    }

}
