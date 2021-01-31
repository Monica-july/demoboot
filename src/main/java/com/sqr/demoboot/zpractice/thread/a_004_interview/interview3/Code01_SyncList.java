package com.sqr.demoboot.zpractice.thread.a_004_interview.interview3;

import java.util.ArrayList;
import java.util.List;

/**
 * 生产者消费者问题
 * 槽大小 10
 * 生产者 2
 * 消费者 6
 * 经典写法 使用synchronized实现
 */
public class Code01_SyncList<T> {
    private List<T> list = new ArrayList<>();/*容器*/
    private static final int MaxSize = 10;/*定量容器中元素最大个数*/
    private int count = 0;/*当前容器中元素数量*/
    /*添加 */
    public synchronized void add(T t) throws InterruptedException {
        //判断容器是否满了
        while (count==MaxSize){
            this.wait();
        }
        list.add(t);
        count++;
        System.out.println(Thread.currentThread().getName()+"生产了---"+t.toString());
        this.notifyAll();
    }
    public synchronized T get() throws InterruptedException {
        //判断是否为空
        while (count==0){
            this.wait();
        }
        T t = list.get(count-1);
        list.remove(t);
        count--;
        System.out.println(Thread.currentThread().getName()+"获取了---"+t.toString());
        this.notifyAll();
        return t;
    }
    public synchronized int getCount(){
        return count;
    }
}
class Main{
    public static void main(String[] args) throws InterruptedException {
        Code01_SyncList<String> list = new Code01_SyncList<>();
        List<Thread> products = new ArrayList<>(2);
        List<Thread> customers = new ArrayList<>(2);
        for (int i = 0; i < 2 ; i++) {
            int finalI = i;
            products.add(new Thread(()->{
                try {
                    for (int j = 0; j < 9 ; j++) {
                        list.add("product-"+ finalI +"-" +j);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            },"product-"+i));
        }
        for (int i = 0; i < 5 ; i++) {
            customers.add(new Thread(()->{
                try {
                    for (int j = 0; j < 6 ; j++) {
                        list.get();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            },"customer"+i));
        }
        customers.forEach(c->c.start());
        Thread.sleep(1000);
        products.forEach(p->p.start());
    }
}