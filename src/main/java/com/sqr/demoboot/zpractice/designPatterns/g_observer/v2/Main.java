package com.sqr.demoboot.zpractice.designPatterns.g_observer.v2;

/**
 * 抽象出一个孩子类 还是等待判断 不重要
 */
class Child{
    boolean cry = false;
    void wakeUp(){
        System.out.println("wake up! crying wuwuwu.......");
        cry = true;
    }
}
public class Main {
    public static void main(String[] args) {
        Child child = new Child();
        new Thread(()->{
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (child.cry){
                System.out.println("feed ........");
            }
        }).start();
        child.wakeUp();
    }
}
