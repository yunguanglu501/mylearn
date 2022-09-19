package com.example.learn.loader;

import java.io.InputStream;

/**
 * @Description:
 * @Author: wcy
 * @CreateDate: 2022/6/30 16:22
 */
public class MyClassLoader extends ClassLoader{

    /**
     * 加载class文件
     * 重写此方法的目的是为了能让此方法被外部调用，父类的 findClass 是 protected 修饰的，只能被子类调用
     * @param name   类的全类名 示例： com.xd.User
     * @return
     * @throws ClassNotFoundException
     */
    @Override
    public Class<?> findClass(String name) throws ClassNotFoundException {


        try {
            // 获取class文件名称  去掉包路径
            System.out.println("name = " + name);
            String fileName = name.substring(name.lastIndexOf(".") + 1) + ".class";
            // 获取文件输入流
            InputStream is = this.getClass().getResourceAsStream(fileName);
            // 读取字节
            byte[] b = new byte[is.available()];
            is.read(b);
            // 将byte字节流解析成jvm能够识别的Class对象
            return defineClass(name, b, 0, b.length);
        } catch (Exception e) {
            throw new ClassNotFoundException();
        }
    }

    ///**
    // * 加载class文件
    // * 重写此方法的目的是为了能让此方法被外部调用，父类的 findClass 是 protected 修饰的，只能被子类调用
    // * @param name   类的全类名 示例： com.xd.User
    // * @return
    // * @throws ClassNotFoundException
    // */
    //@Override
    //public Class<?> findClass(String name) throws ClassNotFoundException {
    //
    //
    //    try {
    //
    //        String fileName = name.replaceAll("\\.","/") + ".class";
    //        fileName = "/"+ fileName;
    //        // 获取文件输入流
    //        InputStream is = this.getClass().getResourceAsStream(fileName);
    //        // 读取字节
    //        byte[] b = new byte[is.available()];
    //        is.read(b);
    //        // 将byte字节流解析成jvm能够识别的Class对象
    //        return defineClass(name, b, 0, b.length);
    //    } catch (Exception e) {
    //        throw new ClassNotFoundException();
    //    }
    //}

}
