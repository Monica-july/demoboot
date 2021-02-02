package com.sqr.demoboot.zpractice.thread.a_003_ReentrantLockAndOthers.aqs;

import java.util.concurrent.locks.AbstractQueuedSynchronizer;

public class Sync_ extends AbstractQueuedSynchronizer {
    /*获取锁*/
    @Override
    protected boolean tryAcquire(int arg) {
        if (compareAndSetState(0,1)){
            setExclusiveOwnerThread(Thread.currentThread());
            return true;
        }
        return false;
    }

    /*释放锁*/
    @Override
    protected boolean tryRelease(int arg) {
        setExclusiveOwnerThread(null);
        setState(0);
        return true;
    }

}
