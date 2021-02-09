package com.sqr.demoboot.zpractice.thread.a_004_interview.interview2;

import java.util.concurrent.CountDownLatch;

/**
 * 两个线程交替打印 a1 b2 c3
 * LockSupport
 */
public class Code14_printWaitNodifyCDL {
    public static void main(String[] args) throws InterruptedException {
        Object obj = new Object();
        CountDownLatch latch = new CountDownLatch(1);
        Thread t1 = new Thread(()->{
            synchronized (obj){
                //控制线程1先执行
                for (int i=1 ; i<=26 ; i++){
                    try {
                        System.out.print(i);
                        latch.countDown();
                        obj.notify();
                        obj.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                obj.notify(); //程序停止
            }
        });
        Thread t2 = new Thread(()->{
            char c = 'a';
            synchronized (obj){
                try {
                    latch.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                for (int i=0 ; i<26 ; i++){
                    try {
                        System.out.println(c++);
                        obj.notify();
                        obj.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                obj.notify();
            }
        });
        t1.start();
        t2.start();
    }
}
