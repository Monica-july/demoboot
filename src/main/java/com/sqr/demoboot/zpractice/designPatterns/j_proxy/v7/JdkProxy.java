package com.sqr.demoboot.zpractice.designPatterns.j_proxy.v7;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 分离代理行为和被代理对象
 * jdk动态代理
 * 被代理对象必须要实现接口
 */
interface Movable{
    void move() throws InterruptedException;
}
class Tank implements Movable{
    @Override
    public void move() throws InterruptedException {
        System.out.println("tank moving cla cla cla.....");
        Thread.sleep((long) (Math.random()*10000));/*模拟坦克移动时间*/
    }
}
public class JdkProxy {
    public static void main(String[] args) throws InterruptedException {
        //reflection
        Tank tank = new Tank();
        Movable movable = (Movable) Proxy.newProxyInstance(Tank.class.getClassLoader()/*被代理对象的classLoader*/
                , new Class[]{Movable.class}/*代理对象实现的接口*/
                , new InvocationHandler() { /*执行的方法*/
                    @Override            //生成的代理对象 //被调用的方法  //参数
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        System.out.println("method "+method.getName()+" start");
                        Object o = method.invoke(tank,args);
                        System.out.println("method "+method.getName()+" end");
                        return o;
                    }
                });
        movable.move();
    }
}
