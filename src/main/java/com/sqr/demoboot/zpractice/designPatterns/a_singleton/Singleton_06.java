package com.sqr.demoboot.zpractice.designPatterns.a_singleton;

/**
 * 懒汉 懒加载 用到的时候再加载
 * 缺点：线程不安全
 * 解决1.0 加锁 缺点：效率低
 * 解决2.0 在方法内部加锁 缺点：会这样还是会导致线程不安全的问题
 * 解决3.0 在方法内部加锁 进行双重检查 DCL 完美   注意需要添加volatile关键字 禁止指令重排序
 */
public class Singleton_06 {
    private static volatile Singleton_06 INSTANCE;

    private Singleton_06() {
    }

    public static Singleton_06 getINSTANCE() {
        if (INSTANCE==null){
            synchronized(Singleton_06.class){
                if (INSTANCE == null){
                    INSTANCE = new Singleton_06();
                }
            }
        }
        return INSTANCE;
    }

    public static void main(String[] args) {
        for (int i = 0; i <100 ; i++) {
            new Thread(()-> {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Singleton_06.getINSTANCE().hashCode());
            }).start();
        }
    }
}
