package com.sqr.demoboot.zpractice.thread.create;

import java.util.concurrent.*;

public class MyThread extends Thread {
    public static volatile boolean running = true;

    @Override
    public void run() {
        try {
            while (running){
                Thread.sleep(TimeUnit.SECONDS.toSeconds(1000));
                System.out.println(this.getName()+"thread running");
            }
//            Thread.sleep(TimeUnit.SECONDS.toSeconds(10000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(this.getName()+"my thread");
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Thread thread1 = new MyThread();
        Thread thread2 = new MyThread();
        thread1.start();
        thread2.start();
        Thread.sleep(TimeUnit.SECONDS.toSeconds(4000));
        running=false;
//        thread1.stop();
//        thread1.suspend();//挂起
//        Thread1.sleep(TimeUnit.SECONDS.toSeconds(2000));
//        thread1.resume();//恢复挂起的线程

        Thread run = new Thread(new MyRun());
        run.start();
        run.interrupt();
        Thread.sleep(TimeUnit.SECONDS.toSeconds(4000));
//
//        Thread lambda = new Thread(()-> System.out.println("my thread----------------"));
//        lambda.start();
//
//        ExecutorService service = Executors.newCachedThreadPool();//创建线程池
//        MyCall call = new MyCall();//创建线程
//        Future<String> future = service.submit(call);//线程提交
//        System.out.println(future.get());//获取返回结果
    }
}

class MyRun implements Runnable{
    @Override
    public void run() {
        System.out.println("my runnable");
    }
}
class MyCall implements Callable<String>{
    public MyCall() {
    }
    @Override
    public String call() throws Exception {
        System.out.println("my callable");
        Thread.sleep(TimeUnit.SECONDS.toSeconds(10000));
        return "callable";
    }
}