package com.sqr.demoboot.zpractice.thread.a_004_interview.interview1;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

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
 * ③ CountDownLatch 门闩倒数
 * await countDown 通信简单  不涉及同步时使用CountDownLatch
 * 下面程序在countDown后 线程1、2都可运行 无法保证运行的先后顺序
 * --------------------------------------------------------------------------
 * 修改 再添加一个门闩 等t2执行完成后t1才能执
 */
public class Code03_CountDownLatchTrue<T> {
    volatile List<T> list = new ArrayList<>();
    public void add(T t){
        list.add(t);
    }
    public int size(){
        return list.size();
    }
    public static void main(String[] args) throws InterruptedException {
        Code03_CountDownLatchTrue<Integer> list_ = new Code03_CountDownLatchTrue<>();
        CountDownLatch latch = new CountDownLatch(1);
        CountDownLatch latch2 = new CountDownLatch(1);
        Thread t1 = new Thread(()->{
            for (int i = 0; i < 10 ; i++) {
                list_.add(i);
                System.out.println("t1 "+ i);
                if (list_.size()==5){/*等于5 countDown -1   t2开始执行*/
                    latch.countDown();
                    try {
                        latch2.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        Thread t2 = new Thread(()->{
            System.out.println("t2 start");
            if (list_.size()!=5){/*如果不等于 5 那就等待*/
                try {
                    latch.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("t2 exec");
            System.out.println("t2 end");
            latch2.countDown();
        });
        t2.start();
        Thread.sleep(1000);
        t1.start();
    }
}
