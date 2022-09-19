package com.example.learn.date.t0915;

/**
 * QuickStartDemo
 *
 * @author wcy
 */
public class QuickStartDemo {
    public static void main(String[] args) {

        new Thread(() -> {
            // 存储数据：根据业务来决定要你存储的数据，可能是一个入参，可能是当前对象的userId
            Integer data = Integer.valueOf("1");
            Context.set(data);

            // 经过多层调用处理之后，现在可能已经不在之前的类中，你想要获取数据，只需要通过Context作为key，就能拿到当前线程你存储的数据
            Integer result = Context.get();
            System.out.println(Thread.currentThread().getName() + " Context.get() = " + result);

            // 处理完后，及时清理数据
            Context.clear();
            Integer integer = Context.get();
            System.out.println("integer = " + integer);
        }).start();

        // 因为主线程没有设置过值，所有获取的数据为默认值
        System.out.println(Thread.currentThread().getName() + " Context.get() = " + Context.get());
    }
}


class Context {
    /**
     * 创建ThreadLocal，并设置默认值（懒加载），一般作为一个静态变量存储
     */
    private final static ThreadLocal<Integer> CONTEXT = ThreadLocal.withInitial(() -> 0);

    public static Integer get() {
        return CONTEXT.get();
    }

    public static void set(Integer data) {
        CONTEXT.set(data);
    }

    public static void clear() {
        CONTEXT.remove();
    }
}


