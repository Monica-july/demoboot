package com.sqr.demoboot.zpractice.designPatterns.a_singleton;

/**
 * 饿汉
 * 静态私有final属性初始化
 * 构造方法私有
 * 线程安全
 */
public class Singleton_01 {
    private static final Singleton_01 INSTANCE = new Singleton_01();
    private Singleton_01() {
    }

    public static Singleton_01 getINSTANCE() {
        return INSTANCE;
    }

    public static void main(String[] args) {
        for (int i=0 ; i <100 ; i++){
            new Thread(()-> System.out.println(Singleton_01.getINSTANCE().hashCode())).start();
        }
    }
}
