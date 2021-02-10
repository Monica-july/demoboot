package com.sqr.demoboot.zpractice.thread.a_004_interview.interview2;

import java.util.concurrent.CountDownLatch;

/**
 * 两个线程交替打印 a1 b2 c3
 * cas+volatile
 * 变量标识当前运行程序 打印完成后修改变量  该变量需要保证线程间是可见的
 *
 */
public class Code15_printCAS {
    enum RUN{
        T1,T2
    }
    static volatile RUN run = RUN.T1;
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(()->{
            for (int i=1 ; i<=26 ; i++){
                while (run==RUN.T2){}/*T2运行 T1等待*/
                System.out.print(i);
                run = RUN.T2;
            }
        });
        Thread t2 = new Thread(()->{
            char c = 'a';
            for (int i=0 ; i<26 ; i++){
                while (run==RUN.T1){}/*T1运行 T2等待*/
                System.out.println(c++);
                run = RUN.T1;
            }
        });
        t1.start();
        t2.start();
    }
}