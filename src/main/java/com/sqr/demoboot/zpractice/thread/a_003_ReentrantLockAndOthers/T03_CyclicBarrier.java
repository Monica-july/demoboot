package com.sqr.demoboot.zpractice.thread.a_003_ReentrantLockAndOthers;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * 循环栅栏 满人发车
 */
public class T03_CyclicBarrier {
    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(3);/*等够三个线程再一起处理*/
        List<Thread> threads = new ArrayList<>();
        for (int i=0 ; i<4 ; i++){
            threads.add(new Thread(()->{
                try {
                    cyclicBarrier.await();
                    int time = (int)(Math.random()*5000);
                    Thread.sleep(time);
                    System.out.println(Thread.currentThread().getName()+" end 运行时间："+time);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }));
        }
        threads.forEach(t->{
            t.start();
        });
        if (cyclicBarrier.getNumberWaiting()>0){
            cyclicBarrier.reset();
        }
    }
}
