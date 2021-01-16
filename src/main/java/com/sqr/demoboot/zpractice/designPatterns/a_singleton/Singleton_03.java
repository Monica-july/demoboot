package com.sqr.demoboot.zpractice.designPatterns.a_singleton;

/**
 * 懒汉 懒加载 用到的时候再加载
 * 缺点：线程不安全
 * 解决1.0 加锁 缺点：效率低
 */
public class Singleton_03 {
    private static Singleton_03 INSTANCE;

    private Singleton_03() {
    }

    public static synchronized Singleton_03 getINSTANCE() {
        if (INSTANCE==null){
            INSTANCE = new Singleton_03();
        }
        return INSTANCE;
    }

    public static void main(String[] args) {
        for (int i = 0; i <100 ; i++) {
            new Thread(()-> {
                System.out.println(Singleton_03.getINSTANCE().hashCode());
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }
}
