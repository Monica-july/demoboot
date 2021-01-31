package com.sqr.demoboot.zpractice.thread.a_004_interview.interview1;

import java.util.ArrayList;
import java.util.List;

/**
 * 面试题
 * 一个容器 有add size方法
 * 一个线程添加add  另一个线程到容器size==5时打印  线程1再继续执行
 * ① volatile 加上关键字后 看起来是正常执行了  但其实是因为t1睡了一秒钟
 * ② wait notify  wait会释放锁 notify不会释放锁 所以就必须让t2先执行进行监听
 * 下面这种写法t2等到t1结束才会执行
 * 因为t1虽然notify了t2 但是没有释放锁 t2获取不到锁 还是不会执行
 * 直至t1结束所释放 t2执行
 * --------------------------------------------------------------------------
 * 修改  t1唤醒其他线程 自己wait  t2执行结束 唤醒t1
 * 缺点:通信过于复杂
 */
public class Code02_WaitNotifyTrue<T> {
    volatile List<T> list = new ArrayList<>();
    public void add(T t){
        list.add(t);
    }
    public int size(){
        return list.size();
    }
    public static void main(String[] args) throws InterruptedException {
        Code02_WaitNotifyTrue<Integer> list_ = new Code02_WaitNotifyTrue<>();
        Thread t1 = new Thread(()->{
            synchronized (list_){
                for (int i = 0; i < 10 ; i++) {
//                    try {
//                        Thread.sleep(1000);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
                    list_.add(i);
                    System.out.println("t1 "+ i);
                    if (list_.size()==5){/*如果等于 5 唤醒t2  同时t1释放锁*/
                        list_.notify();
                        try {
                            list_.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        });
        Thread t2 = new Thread(()->{
            synchronized (list_){
                System.out.println("t2 start");
                if (list_.size()!=5){/*如果不等于 5 那就等待*/
                    try {
                        list_.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("t2 exec");
                System.out.println("t2 end");
                list_.notify();/*执行结束唤醒t1*/
            }
        });
        t2.start();
        Thread.sleep(1000);
        t1.start();
    }
}
