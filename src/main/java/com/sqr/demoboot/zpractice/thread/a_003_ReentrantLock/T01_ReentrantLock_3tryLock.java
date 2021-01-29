package com.sqr.demoboot.zpractice.thread.a_003_ReentrantLock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * ReentrantLock 方法
 * lock 使用完成后必须要释放锁
 * tryLock 尝试获取锁  不管获没获取到锁方法都会继续执行
 * new ReentrantLock(true) 公平锁，默认为非公平锁
 */
public class T01_ReentrantLock_3tryLock {
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
        boolean locked=false;
        try {
            locked = lock.tryLock(3, TimeUnit.SECONDS);
            System.out.println("method2 获取锁："+locked);
            System.out.println("exec m2...........");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            if (locked){
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        T01_ReentrantLock_3tryLock t01_reentrantLock = new T01_ReentrantLock_3tryLock();
        Thread thread1 = new Thread(t01_reentrantLock::method1);
        thread1.start();
        Thread.sleep(1000);
        new Thread(t01_reentrantLock::method2).start();
        thread1.interrupt();
    }
}
