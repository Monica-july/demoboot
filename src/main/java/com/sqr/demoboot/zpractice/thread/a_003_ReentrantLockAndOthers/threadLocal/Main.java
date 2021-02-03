package com.sqr.demoboot.zpractice.thread.a_003_ReentrantLockAndOthers.threadLocal;

/**
 * ThreadLocal 线程本地变量
 * set
 * get
 * remove
 */
public class Main {
    static int num = 10;
    public static void main(String[] args) throws InterruptedException {
        ThreadLocal local = new ThreadLocal();
        new Thread(()->{
            local.set(num);
            local.get();
            System.out.println(local.get().toString());
        }).start();
        Thread.sleep(5000);
        new Thread(()->{
            /**
             * 获取不到 抛出空指针异常
             */
            System.out.printf(local.get().toString());
        }).start();
    }
}
