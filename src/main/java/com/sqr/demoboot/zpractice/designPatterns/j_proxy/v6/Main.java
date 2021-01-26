package com.sqr.demoboot.zpractice.designPatterns.j_proxy.v6;


import com.sqr.demoboot.zpractice.designPatterns.c_factory.Moveable;

/**
 * 问题：move方法需要记录坦克移动时间
 * 新增问题：move方法需要打印日志
 * 一般解决方法：新增一个tank类继承movable接口，重写move方法添加日志打印
 * 记录时间打印日志是坦克移动的额外行为
 * 多个代理 实现movable接口 聚合一个被代理对象 类似于装饰器
 * ************ *
 * 静态代理模式 *
 * ************ *
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

class TankTimeProxy implements Movable {
    Movable movable;
    public TankTimeProxy(Movable movable) {
        this.movable = movable;
    }
    @Override
    public void move() throws InterruptedException {
        long start = System.currentTimeMillis();
        movable.move();
        long end = System.currentTimeMillis();
        System.out.println(end-start);
    }
}
class TankLogProxy implements Movable {
    Movable movable;
    public TankLogProxy(Movable movable) {
        this.movable = movable;
    }
    @Override
    public void move() throws InterruptedException {
        System.out.println("===================start====================");
        movable.move();
        System.out.println("===================end====================");
    }
}

public class Main {
    public static void main(String[] args) throws InterruptedException {
        //先记录时间 再打印日志
//        Movable proxy = new TankLogProxy(new TankTimeProxy(new Tank()));
        //先打印日志 再记录时间
        Movable proxy = new TankTimeProxy(new TankLogProxy(new Tank()));
        proxy.move();
    }
}
