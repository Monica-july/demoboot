package com.sqr.demoboot.zpractice.designPatterns.a_singleton;

import java.util.concurrent.TimeUnit;

/**
 * 懒汉 懒加载 用到的时候再加载
 * 缺点：线程不安全
 */
public class Singleton_02 {
    private static Singleton_02 INSTANCE;

    private Singleton_02() {
    }

    public static Singleton_02 getINSTANCE() {
        if (INSTANCE==null){
            INSTANCE = new Singleton_02();
        }
        return INSTANCE;
    }

    public static void main(String[] args) {
        for (int i = 0; i <100 ; i++) {
            new Thread(()-> {
                System.out.println(Singleton_02.getINSTANCE().hashCode());
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }
}
