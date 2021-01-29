package com.sqr.demoboot.zpractice.designPatterns.j_proxy.cglib;


import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

class Tank {
    public void move() throws InterruptedException {
        System.out.println("tank moving cla cla cla.....");
        Thread.sleep((long) (Math.random()*10000));/*模拟坦克移动时间*/
    }
}
public class Main {
    public static void main(String[] args) throws InterruptedException {
        //增强器
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(Tank.class);
        enhancer.setCallback(new MethodInterceptor() {
            @Override
            public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                System.out.println(o.getClass().getSuperclass().getName());
                System.out.println("before");
                methodProxy.invokeSuper(o,objects);
                System.out.println("after");
                return null;
            }
        });
        Tank tank = (Tank) enhancer.create();
        tank.move();
    }
}
