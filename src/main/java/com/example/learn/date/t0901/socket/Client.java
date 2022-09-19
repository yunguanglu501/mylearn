package com.example.learn.date.t0901.socket;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

/**
 * Client
 *
 * @author wcy
 * @date 2022/9/1
 */
public class Client {
    public static void main(String[] args) throws Exception{
        Socket socket = new Socket("127.0.0.1", 9090);
        //向服务端发送数据
        PrintStream ps = new PrintStream(new BufferedOutputStream(socket.getOutputStream()));
        //读取服务端返回的数据
        BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        ps.println("hello word,china!!,中国万岁");
        ps.flush();
        String info = br.readLine();
        System.out.println(info);
        ps.close();
        br.close();



    }
}
