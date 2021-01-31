package com.sqr.demoboot.zpractice.thread.a_003_ReentrantLockAndOthers;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * ReentrantLock 方法
 * lock 使用完成后必须要释放锁
 * tryLock 尝试获取锁  不管获没获取到锁方法都会继续执行
 * new ReentrantLock(true) 公平锁，默认为非公平锁
 * lockInterruptibly 对线程打断做出响应
 */
public class T01_ReentrantLock_4interrupt {
    Lock lock = new ReentrantLock();
    public void method1() {
        try {
            lock.lock();/*aaa 锁定*/
            for (int i = 0; i <10 ; i++) {
                System.out.println(i);
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            System.out.println(Thread.currentThread().getName()+" Interrupt!!!");
        }finally {
            lock.unlock();/*aaa 释放锁*/
        }
    }
    public void method2() {
        try {
            lock.lockInterruptibly();
            System.out.println("exec m2...........");
        } catch (InterruptedException e) {
            System.out.println(Thread.currentThread().getName()+" Interrupt!!!");
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        T01_ReentrantLock_4interrupt t01_reentrantLock = new T01_ReentrantLock_4interrupt();
        Thread thread1 = new Thread(t01_reentrantLock::method1);
        thread1.start();
        Thread.sleep(1000);
        new Thread(t01_reentrantLock::method2).start();
        thread1.interrupt();
    }
}
