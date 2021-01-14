package com.sqr.demoboot.zpractice.thread.lock;

public class Sync_001 implements Runnable{
    private /*volatile*/ int count=10;
    public /*synchronized*/ void sub(){
        count--;
        System.out.println(Thread.currentThread().getName() + " count = " + count);
    }

    public static void main(String[] args) {
        Sync_001 sync_001 = new Sync_001();
        for (int i = 0; i < 10 ; i++) {
            new Thread((Runnable) sync_001,"Thread-"+i).start();
        }
    }

    @Override
    public void run() {
        sub();
    }
}
