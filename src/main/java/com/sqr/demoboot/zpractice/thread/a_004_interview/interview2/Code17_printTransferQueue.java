package com.sqr.demoboot.zpractice.thread.a_004_interview.interview2;

import java.util.concurrent.LinkedTransferQueue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 两个线程交替打印 a1 b2 c3
 * cas+volatile
 * 变量标识当前运行程序 打印完成后修改变量  该变量需要保证线程间是可见的
 *
 */
public class Code17_printTransferQueue {
    public static void main(String[] args) throws InterruptedException {
        LinkedTransferQueue queue = new LinkedTransferQueue();

        Thread t1 = new Thread(()->{
            for (int i=1 ; i<=26 ; i++){
                try {
                    queue.transfer(i);
                    System.out.println(queue.take());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        Thread t2 = new Thread(()->{
            char c = 'a';
            for (int i=0 ; i<26 ; i++){
                try {
                    System.out.print(queue.take());
                    queue.transfer(c);
                    c++;
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        t1.start();
        t2.start();
    }
}