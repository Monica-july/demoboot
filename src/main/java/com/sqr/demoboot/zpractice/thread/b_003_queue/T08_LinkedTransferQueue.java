package com.sqr.demoboot.zpractice.thread.b_003_queue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedTransferQueue;

/**
 * transfer是 LinkedTransferQueue独有的  子类方法
 */
public class T08_LinkedTransferQueue {
    public static void main(String[] args) throws InterruptedException {

        LinkedTransferQueue<String> queue = new LinkedTransferQueue<>();
        /*消费线程*/
        new Thread(()->{
            try {
                System.out.println(queue.take());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        queue.transfer("abc");//transfer 不会继续向下执行，先要启动消费者处理线程 等待处理
    }
}
