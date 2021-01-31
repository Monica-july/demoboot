package com.sqr.demoboot.zpractice.thread.a_003_ReentrantLockAndOthers;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

/**
 * 门闩
 * 倒数
 */
public class T02_CountDownLatch {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(4);
        List<Thread> threads = new ArrayList<>();
        for (int i=0 ; i<4 ; i++){
            threads.add(new Thread(()->{
                try {
                    int time = (int)(Math.random()*5000);
                    Thread.sleep(time);
                    System.out.println(Thread.currentThread().getName()+" end 运行时间："+time);
                    latch.countDown();
                    System.out.println("当前运行线程数量："+latch.getCount());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }));
        }
        threads.forEach(t->t.start());
        latch.await();
        System.out.println("program end");
    }
}
