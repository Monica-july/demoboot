package com.sqr.demoboot.zpractice.thread.a_004_interview.interview2;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.LockSupport;

/**
 * 两个线程交替打印 a1 b2 c3
 * LockSupport
 */
public class Code11_printLockSupport {
    static Thread t1,t2;
    public static void main(String[] args) {
        t1 = new Thread(()->{
            for (int i=1 ; i<=26 ; i++){
                System.out.print(i);
                LockSupport.unpark(t2);
                LockSupport.park();
            }
        });
        t2 = new Thread(()->{
            char c = 'a';
            for (int i=0 ; i<26 ; i++){
                LockSupport.park();
                System.out.println(c++);
                LockSupport.unpark(t1);
            }
        });
        t1.start();
        t2.start();
    }
}
