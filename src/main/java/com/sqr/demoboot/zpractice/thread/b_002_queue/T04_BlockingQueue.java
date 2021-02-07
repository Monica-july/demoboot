package com.sqr.demoboot.zpractice.thread.b_002_queue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * BlockingQueue 接口 阻塞队列
 * put() take() 阻塞的
 * 实现类  LinkedBlockingQueue  maxSize = Integer.MAX_VALUE
 */
public class T04_BlockingQueue {
    static BlockingQueue<String> queue = new LinkedBlockingQueue<>(50);
    public static void main(String[] args) {
        //生产者线程
        new Thread(()->{
            for (int i = 0; i < 100 ; i++) {
                try {
                    queue.put("a"+i);
                    Thread.sleep((int)(Math.random()*1000));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        //消费者线程
        for (int i = 0; i < 5 ; i++) {
            new Thread(()->{
                for (;;){
                    try {
                        System.out.println(Thread.currentThread().getName()+":"+queue.take());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            },"c"+i).start();
        }
    }
}
