package com.sqr.demoboot.zpractice.thread.inperrupt;

import java.util.concurrent.TimeUnit;

public class My02 {
    public static void main(String[] args) throws InterruptedException {
        Thread thread22 = new MyThread2();
        thread22.start();
        Thread.sleep(8000);
        thread22.interrupt();
    }
}
class MyThread2 extends Thread{
    @Override
    public void run() {
        System.out.println("start");
        while (!isInterrupted()){
            try {
                System.out.println("my thread2");
                Thread.sleep(TimeUnit.SECONDS.toSeconds(1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
                interrupt();//也可以使用break跳出循环；
            }
        }
        System.out.println("end");
    }
}