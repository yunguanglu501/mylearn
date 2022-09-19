package com.example.learn.date.t0901.socket;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

/**
 * ServerTest
 *
 * @author wcy
 * @date 2022/9/1
 */
public class ServerTest {
    public static void main(String[] args) throws Exception{
        //初始化服务端端口9090
        ServerSocket serverSocket = new ServerSocket(9090);
        System.out.println("服务端已启动，端口号为9090...");
        //开启循环监听
        while (true) {
            //等待客户端的连接
            Socket accept = serverSocket.accept();
            //将字节流转化为字符流，读取客户端发来的数据
            BufferedReader br = new BufferedReader(new InputStreamReader(accept.getInputStream()));
            //一行一行的读取客户端的数据
            String s = br.readLine();
            System.out.println("服务端收到客户端的信息：" + s);
            OutputStream outputStream = accept.getOutputStream();
            outputStream.write((s+" 客户端,我收到你说的消息了").getBytes(StandardCharsets.UTF_8));
        }
    }
}
