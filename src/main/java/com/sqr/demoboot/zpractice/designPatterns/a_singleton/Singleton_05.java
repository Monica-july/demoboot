package com.sqr.demoboot.zpractice.designPatterns.a_singleton;

/**
 * 懒汉 懒加载 用到的时候再加载
 * 缺点：线程不安全
 * 解决1.0 加锁 缺点：效率低
 * 解决2.0 在方法内部加锁 缺点：会这样还是会导致线程不安全的问题
 * 解决2.0 在方法内部加锁 进行双重检查 DCL 完美
 */
public class Singleton_05 {
    private static Singleton_05 INSTANCE;

    private Singleton_05() {
    }

    public static Singleton_05 getINSTANCE() {
        if (INSTANCE==null){
            synchronized(Singleton_05.class){
                if (INSTANCE == null){
                    INSTANCE = new Singleton_05();
                }
            }
        }
        return INSTANCE;
    }

    public static void main(String[] args) {
        for (int i = 0; i <100 ; i++) {
            new Thread(()-> {
                System.out.println(Singleton_05.getINSTANCE().hashCode());
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }
}
