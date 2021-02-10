package com.sqr.demoboot.zpractice.thread.a_004_interview.interview2;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 两个线程交替打印 a1 b2 c3
 * cas+volatile
 * 变量标识当前运行程序 打印完成后修改变量  该变量需要保证线程间是可见的
 * ReentrantLock + Condition
 * bug:无法指定线程执行顺序
 */
public class Code16_printReentrantLock {
    public static void main(String[] args) throws InterruptedException {
        ReentrantLock lock = new ReentrantLock();
        Condition condition =lock.newCondition();
        Thread t1 = new Thread(()->{
            try {
                lock.lock();
                for (int i=1 ; i<=26 ; i++){
                    System.out.print(i);
                    condition.signal();
                    condition.await();
                }
                condition.signal();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        });
        Thread t2 = new Thread(()->{
            char c = 'a';
            try {
                lock.lock();
                for (int i=0 ; i<26 ; i++){
                    System.out.println(c++);
                    condition.signal();
                    condition.await();
                }
                condition.signal();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        });
        t1.start();
        t2.start();
    }
}