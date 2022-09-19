package com.example.learn.lamdar;

/**
 * 我们要判断多个苹果里面的绿颜色和大于150g的苹果，或者说后面会加入更多的筛选条件，
 * 用if/else太显得臃肿，所以，java8提出了行为参数化，我们按照以下两步来进行行为参数化的说明，也是对自己的学习的一个总结。
 * 处理这种问题首先要先建立一个公共的接口，这个接口里有一个方法，就是来接收所有的条件：
 * 然后分别建立两个实现，一个是颜色，一个是重量，可以把参数作为重写方法的主要内容。
 *两个类里面都针对不同的条件进行判断，返回一个boolean类型的结果，我们在执行的时候就可以直接判断，那个实体对象符合条件，返回了true，然后将其放入list中返回。
 * FormatApple
 *行为参数化
 * @author wcy
 * @date 2022/8/9
 */
public interface FormatApple {
    boolean test(Apple apple);
}

