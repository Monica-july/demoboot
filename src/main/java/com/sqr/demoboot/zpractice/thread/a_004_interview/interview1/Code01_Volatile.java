package com.sqr.demoboot.zpractice.thread.a_004_interview.interview1;

import java.util.ArrayList;
import java.util.List;

/**
 * 面试题
 * 一个容器 有add size方法
 * 一个线程添加add  另一个线程到容器size==5时打印  线程1再继续执行
 * ① volatile 加上关键字后 看起来是正常执行了  但其实是因为t1睡了一秒钟
 */
public class Code01_Volatile<T> {
    volatile List<T> list = new ArrayList<>();
    public void add(T t){
        list.add(t);
    }
    public int size(){
        return list.size();
    }
    public static void main(String[] args) {
        Code01_Volatile<Integer> list_ = new Code01_Volatile<>();
        Thread t1 = new Thread(()->{
            for (int i = 0; i < 10 ; i++) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                list_.add(i);
                System.out.println("t1 "+ i);
            }
        });
        Thread t2 = new Thread(()->{
            while (true){
                if (list_.size()==5){
                    System.out.println("t2 exec");
                    break;
                }
            }
        });
        t1.start();
        t2.start();
    }
}
