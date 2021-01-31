package com.sqr.demoboot.zpractice.thread.a_003_ReentrantLockAndOthers;

import java.util.concurrent.Exchanger;
import java.util.concurrent.atomic.AtomicReference;

/*
* 线程间的数据交换
* exchange 线程处于阻塞状态
* */
public class T07_Exchanger {
    public static void main(String[] args) {
        Exchanger<String> exchanger = new Exchanger<>();
        new Thread(()->{
            String str = "线程1设置值";
            try {
                System.out.println(Thread.currentThread().getName()+" start");
                System.out.println(Thread.currentThread().getName()+"值内容："+str);
                exchanger.exchange(str);
                System.out.println(Thread.currentThread().getName()+"change后："+str);
                Thread.sleep((int)(Math.random()*3000));
                System.out.println(Thread.currentThread().getName()+" end");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(()->{
            String str = "线程2设置值";
            try {
                System.out.println(Thread.currentThread().getName()+" start");
                System.out.println(Thread.currentThread().getName()+"值内容："+str);
                exchanger.exchange(str);
                System.out.println(Thread.currentThread().getName()+"change后："+str);
                Thread.sleep((int)(Math.random()*3000));
                System.out.println(Thread.currentThread().getName()+" end");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

    }
}
