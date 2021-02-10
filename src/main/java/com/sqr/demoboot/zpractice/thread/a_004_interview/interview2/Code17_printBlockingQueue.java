package com.sqr.demoboot.zpractice.thread.a_004_interview.interview2;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * 两个线程交替打印 a1 b2 c3
 * cas+volatile
 * 变量标识当前运行程序 打印完成后修改变量  该变量需要保证线程间是可见的
 * ArrayBlockingQueue 固定长度 1  put一个 take一个
 */
public class Code17_printBlockingQueue {
    public static void main(String[] args) throws InterruptedException {
        BlockingQueue queue1 = new ArrayBlockingQueue(1);
        BlockingQueue queue2 = new ArrayBlockingQueue(1);

        Thread t1 = new Thread(()->{
            for (int i=1 ; i<=26 ; i++){
                try {
                    System.out.print(i);;
                    queue1.put("ok");
                    queue2.take();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        Thread t2 = new Thread(()->{
            char c = 'a';
            for (int i=0 ; i<26 ; i++){
                try {
                    queue1.take();
                    System.out.println(c++);
                    queue2.put("ok");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        t1.start();
        t2.start();
    }
}