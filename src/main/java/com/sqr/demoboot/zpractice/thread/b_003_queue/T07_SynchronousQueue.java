package com.sqr.demoboot.zpractice.thread.b_003_queue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;

public class T07_SynchronousQueue {
    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<String> queue = new SynchronousQueue<>();
        new Thread(()->{
//            for (;;){
                try {
                    System.out.println(queue.take());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
//            }
        }).start();
        queue.put("222");//放进去一个处理一个
        queue.put("555");//可以再添加 等待消费者消费 阻塞状态
        queue.put("333");
//        queue.add("add");//java.lang.IllegalStateException: Queue full
        System.out.println(queue.size());
    }
}
