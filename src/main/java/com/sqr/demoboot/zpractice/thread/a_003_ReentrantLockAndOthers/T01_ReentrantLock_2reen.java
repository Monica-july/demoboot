package com.sqr.demoboot.zpractice.thread.a_003_ReentrantLockAndOthers;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * ReentrantLock 锁的可重入性
 * 启动两个线程
 * 线程1执行method1 时间10秒
 * 线程1启动一秒后调用线程2
 * lock 使用完成后必须要手动释放锁  synchronized是jvm来释放的
 */
public class T01_ReentrantLock_2reen {
    Lock lock = new ReentrantLock();
    public void method1() {
        try {
            lock.lock();/*aaa 锁定*/
            for (int i = 0; i <10 ; i++) {
                System.out.println(i);
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();/*aaa 释放锁*/
        }
    }
    public void method2() {
        try {
            lock.lock();
            System.out.println("exec m2...........");
        }finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        T01_ReentrantLock_2reen t01_reentrantLock = new T01_ReentrantLock_2reen();
        new Thread(t01_reentrantLock::method1).start();
        Thread.sleep(1000);
        new Thread(t01_reentrantLock::method2).start();
    }
}
