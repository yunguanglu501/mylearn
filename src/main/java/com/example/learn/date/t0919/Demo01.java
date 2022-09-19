package com.example.learn.date.t0919;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Demo01
 *
 * @author wcy
 */
public class Demo01 {

    public static void main(String[] args) throws Exception {
        method2();
    }


    public static void method2(){
        InputStream in = null;
        try{
            in = new BufferedInputStream(new FileInputStream("D:\\0915.txt"));
            byte [] buf = new byte[1024];
            int bytesRead = in.read(buf);
            while(bytesRead != -1)
            {
                for(int i=0;i<bytesRead;i++){
                    System.out.print((char)buf[i]);}
                bytesRead = in.read(buf);
            }
        }catch (IOException e)
        {
            e.printStackTrace();
        }finally{
            try{
                if(in != null){
                    in.close();
                }
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }
}
