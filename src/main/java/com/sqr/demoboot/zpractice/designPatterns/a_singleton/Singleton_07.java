package com.sqr.demoboot.zpractice.designPatterns.a_singleton;

/**
 * 饿汉
 * 静态内部类
 * java虚拟机在加载类的时候第一次不会加载内部类
 */
public class Singleton_07 {
    private Singleton_07() {
    }
    static class MyInnerSingle_07{
        private static final Singleton_07 INSTANCE = new Singleton_07();
    }
    public static Singleton_07 getINSTANCE(){
        return MyInnerSingle_07.INSTANCE;
    }

    public static void main(String[] args) {
        for (int i = 0; i <100 ; i++) {
            new Thread(()-> {
                System.out.println(Singleton_07.getINSTANCE().hashCode());
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }
}
