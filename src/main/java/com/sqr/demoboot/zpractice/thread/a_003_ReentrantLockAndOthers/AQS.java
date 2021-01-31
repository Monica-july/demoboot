package com.sqr.demoboot.zpractice.thread.a_003_ReentrantLockAndOthers;

import java.util.concurrent.locks.ReentrantLock;

public class AQS {
    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock();
        lock.lock();
    }
}
