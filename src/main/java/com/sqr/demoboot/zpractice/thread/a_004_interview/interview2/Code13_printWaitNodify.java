package com.sqr.demoboot.zpractice.thread.a_004_interview.interview2;

import java.util.concurrent.locks.LockSupport;

/**
 * 两个线程交替打印 a1 b2 c3
 * LockSupport
 */
public class Code13_printWaitNodify {
    public static void main(String[] args) throws InterruptedException {
        Object obj = new Object();
        Thread t1 = new Thread(()->{
            synchronized (obj){
                for (int i=1 ; i<=26 ; i++){
                    try {
                        System.out.print(i);
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
        Thread.sleep(1000);
        t2.start();
    }
}
