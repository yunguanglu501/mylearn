package com.example.learn.ioc;

import cn.hutool.core.date.DatePattern;
import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;

import java.util.Date;

public class ProgrammerTest {

    public static void main(String[] args) {
        // new Programmer().showMaterial();

        // BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.genericBeanDefinition(Programmer.class);
        // beanDefinitionBuilder.addPropertyValue("name", "mghio");
        // beanDefinitionBuilder.addPropertyValue("age", 18);
        // beanDefinitionBuilder.addPropertyValue("hasGirlFriend", false);
        //
        // DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        // beanFactory.registerBeanDefinition("programmer", beanDefinitionBuilder.getBeanDefinition());
        //
        // Programmer programmer = (Programmer) beanFactory.getBean("programmer");
        // programmer.showMaterial();

        String pbrq="2022-07-21";
        // DateTime dateTime = DateUtil.parseDate(pbrq);
        // System.out.println("dateTime = " + dateTime);
        // String substring = DateUtil.formatChineseDate(dateTime, false, false).substring(5);
        // System.out.println("substring = " + substring);
        // Date recentDate = DateUtil.parse("2022-12-21 08:00:00", "yyyy-mm-dd");
        // System.out.println("recentDate = " + recentDate);
        Date date = DateUtil.parse(pbrq,DatePattern.NORM_DATE_FORMAT);
        System.out.println("date = " + date);

        Date date2 = DateUtil.parse(pbrq);
        System.out.println("date2 = " + date2);
    }

}
