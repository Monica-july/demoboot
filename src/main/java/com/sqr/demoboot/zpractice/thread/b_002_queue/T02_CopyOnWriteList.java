package com.sqr.demoboot.zpractice.thread.b_002_queue;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.Vector;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CountDownLatch;

/**
 * 写时复制
 * 线程安全
 * 写效率低 读效率高 适用于写少读多的情况
 */
public class T02_CopyOnWriteList {
    public static void main(String[] args) throws InterruptedException {
        List<Integer> list =
                new CopyOnWriteArrayList<>();/*写 3929*/
//                new Vector<>();/*写 39 */
//                new ArrayList<>();/*线程不安全*/
        List<Thread> threadList = new ArrayList<>();
        CountDownLatch latch = new CountDownLatch(100);
        long startWrite = System.currentTimeMillis();
        for (int i = 0; i < 100 ; i++) {
            threadList.add(new Thread(()->{
                for (int j = 0; j < 1000 ; j++) {
                    list.add((int)(Math.random()*1000));
                }
                latch.countDown();
            }));
        }
        threadList.forEach(t->t.start());
        latch.await();
        long endWrite = System.currentTimeMillis();
        System.out.println(endWrite-startWrite);
        System.out.println(list.size());
//        threadList.clear();
//        for (int i = 0; i < 100 ; i++) {
//            threadList.add(new Thread(()->{
//                for (int j = 0; j < 1000 ; j++) {
//                    System.out.println();
//                }
//            }));
//        }

    }
}
