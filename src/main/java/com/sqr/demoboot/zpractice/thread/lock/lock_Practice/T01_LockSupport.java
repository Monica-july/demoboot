package com.sqr.demoboot.zpractice.thread.lock.lock_Practice;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

public class T01_LockSupport {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(()->{
            for (int i = 1; i <= 10 ; i++) {
                System.out.println(i);
                if (i==5){
                    LockSupport.park();
                }
            }
        });
        thread.start();
        TimeUnit.SECONDS.sleep(5);
        LockSupport.unpark(thread);
    }
}
