package com.example.learn.neicun;

import org.openjdk.jol.info.ClassLayout;

/**
 * UserTest1
 *
 * @author wcy
 * @date 2022/8/11
 */
public class UserTest1 {
    public static void main(String[] args) throws Exception{
        //64位系统中markword占8字节。这8字节可是对象很重要的属性。包括对象HashCode、GC次数、锁标记等信息都是存储在markword中的。
        // UserNeiCun userNeiCun = new UserNeiCun();
        // System.out.println("userNeiCun.hashCode() = " + userNeiCun.hashCode());
        // String s = ClassLayout.parseInstance(userNeiCun).toPrintable();
        // System.out.println("s = " + s);
        Thread.sleep(5000);
        UserNeiCun userNeiCun2 = new UserNeiCun();
        userNeiCun2.setAge(18);
        userNeiCun2.setMoney(1.0d);
        // System.out.println("ClassLayout.parseInstance(userNeiCun).toPrintable() = " + ClassLayout.parseInstance(userNeiCun2).toPrintable());
        synchronized (userNeiCun2){
            System.out.println("ClassLayout.parseInstance(userNeiCun2).toPrintable() = " + ClassLayout.parseInstance(userNeiCun2).toPrintable());
        }

    }
}
