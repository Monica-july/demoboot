package com.sqr.demoboot.zpractice.thread.a_003_ReentrantLockAndOthers;

import java.util.concurrent.locks.ReentrantLock;

/**
 * AbstractQueueSynchronized
 */
public class AQS {
    public static void main(String[] args) throws InterruptedException {
        /*ReentrantLock lock源码阅读*/
        /**
         *
         */
        ReentrantLock lock = new ReentrantLock();
        lock.lock();
        Thread.sleep(1000);
        lock.unlock();
    }
}
