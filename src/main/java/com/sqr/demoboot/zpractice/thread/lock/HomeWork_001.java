package com.sqr.demoboot.zpractice.thread.lock;

import java.util.concurrent.locks.LockSupport;

/**
 * 两个线程交叉顺序打印 a1 b3 c3
 */
public class HomeWork_001 {
    char cWord = 'a';
    int iNum = 1;
    public static void main(String[] args) {
        HomeWork_001 homeWork_001 = new HomeWork_001();
        Thread t1 = new Thread(()->{
            for (int i=0 ; i<26 ; i++){
                System.out.print(homeWork_001.cWord);
                homeWork_001.cWord++;
                LockSupport.park();
            }
        });
        Thread t2 = new Thread(()->{
            LockSupport.park();
            for (int i=0 ; i<26 ; i++){
                System.out.print(homeWork_001.iNum);
                System.out.println();
                homeWork_001.iNum++;
                LockSupport.unpark(t1);
            }
        });
        t1.start();
        t2.start();
    }
}
