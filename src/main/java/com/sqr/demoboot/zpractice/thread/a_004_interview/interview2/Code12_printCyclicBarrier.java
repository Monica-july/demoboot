package com.sqr.demoboot.zpractice.thread.a_004_interview.interview2;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.locks.LockSupport;

/**
 * 两个线程交替打印 a1 b2 c3
 * CyclicBarrier 有问题
 */
public class Code12_printCyclicBarrier {
    public static void main(String[] args) throws InterruptedException {
        CyclicBarrier barrier = new CyclicBarrier(1);
        Thread t1 = new Thread(()->{
            for (int i=1 ; i<=26 ; i++){
                System.out.print(i);
                barrier.reset();
                try {
                    barrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }
        });
        Thread t2 = new Thread(()->{
            try {
                barrier.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
            char c = 'a';
            for (int i=0 ; i<26 ; i++){
                System.out.println(c++);
                barrier.reset();
                try {
                    barrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }
        });
        t1.start();
        Thread.sleep(1000);
        t2.start();
    }
}
