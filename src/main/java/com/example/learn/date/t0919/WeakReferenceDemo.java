package com.example.learn.date.t0919;

import java.lang.ref.WeakReference;
import java.util.concurrent.TimeUnit;

/**
 * WeakReferenceDemo
 *
 * @author wcy
 */
public class WeakReferenceDemo {
        public static void main(String[] args) {
        //强引用
        RoleDTO role = new RoleDTO(1, "CEO");

        //弱引用
        WeakReference<RoleDTO> weakReference = new WeakReference<>(new RoleDTO(1, "CTO"));
        //主动让出发GC
        System.gc();
        try {
            //给GC留点时间，保证GC执行完成
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (role == null) {
            System.out.println("强引用指向的RoleDTO对象 已经被回收");
        }

        //weakReference.get()获取弱引用指向的对象，如果对象是null，表示被回收
        if (weakReference.get() == null) {
            System.out.println("弱引用指向的RoleDTO对象 已经被回收");
        }

    }
}
