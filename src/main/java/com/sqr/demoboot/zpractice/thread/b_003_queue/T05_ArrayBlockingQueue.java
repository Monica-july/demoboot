package com.sqr.demoboot.zpractice.thread.b_003_queue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * ArrayBlockingQueue
 * 固定长度的
 * 超过长度再向里面存数据会阻塞
 * offer 尝试存放 try
 */
public class T05_ArrayBlockingQueue {
    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<String> queue = new ArrayBlockingQueue<>(10);
        for (int i = 0; i < 10 ; i++) {
            queue.put(""+i);
        }
//        queue.put("11");
        queue.offer("13", 3,TimeUnit.SECONDS);
        System.out.println(queue.size());
    }
}
