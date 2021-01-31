package com.sqr.demoboot.zpractice.thread.a_003_ReentrantLockAndOthers;

/**
 * 锁的可重入性
 * 两个方法 当方法method1执行到i==2时执行method2
 */
public class T01_ReentrantLock_1sync {
    synchronized public void method1() {
        for (int i = 0; i <10 ; i++) {
            System.out.println(i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (i==2){
                method2();
            }
        }
    }
    synchronized public void method2() {
        System.out.println("exec m2...........");
    }

    public static void main(String[] args) throws InterruptedException {
        T01_ReentrantLock_1sync t01_reentrantLock = new T01_ReentrantLock_1sync();
        new Thread(t01_reentrantLock::method1).start();
    }
}
