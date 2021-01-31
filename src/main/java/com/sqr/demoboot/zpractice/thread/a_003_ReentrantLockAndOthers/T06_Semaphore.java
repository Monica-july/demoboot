package com.sqr.demoboot.zpractice.thread.a_003_ReentrantLockAndOthers;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;

/**
 * 信号量
 * 应用场景--限流
 */
public class T06_Semaphore {
    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(3,true);/*参数1 同时允许执行的线程数量 参数2 是否是公平锁*/
        List<Thread> threads = new ArrayList<>();
        for (int i = 0; i < 4 ; i++) {
            threads.add(new Thread(()->{
                try {
                    //获得信号量
                    semaphore.acquire();
                    System.out.println(Thread.currentThread().getName()+" start");
                    Thread.sleep((int)(Math.random()*10000));
                    System.out.println(Thread.currentThread().getName()+" end");
                    //释放信号量
                    semaphore.release();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }));
        }
        threads.forEach(t->t.start());
    }
}
