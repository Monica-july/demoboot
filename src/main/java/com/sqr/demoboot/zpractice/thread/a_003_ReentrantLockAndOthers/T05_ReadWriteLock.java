package com.sqr.demoboot.zpractice.thread.a_003_ReentrantLockAndOthers;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 读写锁
 */
public class T05_ReadWriteLock {
    public static void main(String[] args) {
        ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();
        Lock readLock = readWriteLock.readLock();
        Lock writeLock = readWriteLock.writeLock();
        List<Thread> threads = new ArrayList<>();
        /*两个写线程*/
        for (int i = 0; i < 2 ; i++) {
            threads.add(new Thread(()->{
                writeLock.lock();
                try {
                    Thread.sleep(2000);
                    System.out.println(Thread.currentThread().getName()+" write end");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    writeLock.unlock();
                }
            }));
        }
        /*八个读线程*/
        for (int i = 0; i < 8 ; i++) {
            threads.add(new Thread(()->{
                readLock.lock();
                try {
                    Thread.sleep(1000);
                    System.out.println(Thread.currentThread().getName()+" read end");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    readLock.unlock();
                }
            }));
        }
        threads.forEach(t->t.start());
    }
}
