package com.sqr.demoboot.zpractice.designPatterns.j_proxy.v9;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 分离代理行为和被代理对象
 * jdk动态代理
 * 被代理对象必须要实现接口
 * System.getProperties().put("jdk.proxy.ProxyGenerator.saveGeneratedFiles","true");
 */
interface Movable{
    void move() throws InterruptedException;
}

class Tank implements Movable {
    @Override
    public void move() throws InterruptedException {
        System.out.println("tank moving cla cla cla.....");
        Thread.sleep((long) (Math.random()*10000));/*模拟坦克移动时间*/
    }
}

class LogProxy implements InvocationHandler{
    Tank tank;

    public LogProxy(Tank tank) {
        this.tank = tank;
    }
    public void after(){
        System.out.println("method end");
    }
    public void before(){
        System.out.println("method start");
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        before();
        tank.move();
        after();
        return null;
    }
}

public class JdkProxy {
    public static void main(String[] args) throws InterruptedException {
        //reflection
        Tank tank = new Tank();

        System.getProperties().put("jdk.proxy.ProxyGenerator.saveGeneratedFiles","true");

        Movable movable = (Movable) Proxy.newProxyInstance(Tank.class.getClassLoader()/*被代理对象的classLoader*/
                , new Class[]{Movable.class}/*代理对象实现的接口*/
                , new LogProxy(tank));
        movable.move();
    }
}
