package com.sqr.demoboot.zpractice.thread.a_003_ReentrantLockAndOthers.aqs;

import java.util.concurrent.CountDownLatch;

public class SeeCountDownLatch {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(2);
        latch.countDown();
        latch.countDown();
        latch.await();
    }
}
