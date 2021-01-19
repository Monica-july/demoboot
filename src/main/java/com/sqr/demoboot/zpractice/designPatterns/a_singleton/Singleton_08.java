package com.sqr.demoboot.zpractice.designPatterns.a_singleton;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 枚举单例
 * 当以上方法在使用反射创建时 实例就会产生多个
 * 枚举类型实际上是一个 abstract class
 */
public enum Singleton_08 {
    INSTANCE;

    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        /**
         * 反射创建单例测试
         */
        //正常创建
        Singleton_06 normal1 = Singleton_06.getINSTANCE();
        Singleton_06 normal2 = Singleton_06.getINSTANCE();
        System.out.println("normal1==normal2："+(normal1==normal2));
        //反射创建
        Constructor constructor = Singleton_06.class.getDeclaredConstructor();
        constructor.setAccessible(true);//绕过private检查
        Singleton_06 reflect1 = (Singleton_06) constructor.newInstance();
        Singleton_06 reflect2 = (Singleton_06) constructor.newInstance();
        System.out.println("reflect1==reflect2："+(reflect1==reflect2));
        /**
         * 枚举单例测试
         */
        for (int i = 0; i <100 ; i++) {
            new Thread(()-> {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Singleton_08.INSTANCE.hashCode());
            }).start();
        }
    }
}
