package com.sqr.demoboot.zpractice.thread.b_002_queue;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.CountDownLatch;

/**
 * 队列
 * offer
 * peek
 * poll
 */
public class T03_ConcurrentQueue {
    public static void main(String[] args) throws InterruptedException {
        Queue<String> list1 = new ConcurrentLinkedQueue<>();
        Queue<String> list2 = new ConcurrentLinkedQueue<>();
        List<Thread> threads1 = new ArrayList<>();
        List<Thread> threads2 = new ArrayList<>();
        CountDownLatch latch1 = new CountDownLatch(100);
        CountDownLatch latch2 = new CountDownLatch(100);

        /*--------------------------------------*/
        long s1 = System.currentTimeMillis();
        for (int t=0 ; t<100 ; t++){
            threads1.add(new Thread(()->{
                for (int i = 0; i < 1000 ; i++) {
                    list1.add(i+"");
                }
                latch1.countDown();
            }));
        }
        threads1.forEach(t->t.start());
        latch1.await();
        long e1 = System.currentTimeMillis();
        System.out.println(e1-s1);
        System.out.println(list1.size());
        /*--------------------------------------*/

        /*--------------------------------------*/
        long s2 = System.currentTimeMillis();
        for (int t=0 ; t<100 ; t++){
            threads2.add(new Thread(()->{
                for (int i = 0; i < 1000 ; i++) {
                    list2.offer(i+"");
                }
                latch2.countDown();
            }));
        }
        threads2.forEach(t->t.start());
        latch2.await();
        long e2 = System.currentTimeMillis();
        System.out.println(e2-s2);
        System.out.println(list2.size());
        /*--------------------------------------*/
    }
}
