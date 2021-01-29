package com.sqr.demoboot.zpractice.designPatterns.j_proxy.v5;

/**
 * 问题：move方法需要记录坦克移动时间
 * 新增问题：move方法需要打印日志
 * 一般解决方法：新增一个tank类继承movable接口，重写move方法添加日志打印
 * 记录时间打印日志是坦克移动的额外行为
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
class TankTimeProxy implements Movable {
    Tank tank;
    public TankTimeProxy(Tank tank) {
        this.tank = tank;
    }
    @Override
    public void move() throws InterruptedException {
        long start = System.currentTimeMillis();
        tank.move();
        long end = System.currentTimeMillis();
        System.out.println(end-start);
    }
}

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Tank tank = new Tank();
        TankTimeProxy proxy = new TankTimeProxy(new Tank());
        proxy.move();
    }
}
