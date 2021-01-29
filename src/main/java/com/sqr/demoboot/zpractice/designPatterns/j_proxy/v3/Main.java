package com.sqr.demoboot.zpractice.designPatterns.j_proxy.v3;

/**
 * 问题：move方法需要记录坦克移动时间
 * 新增问题：move方法需要打印日志  v4实现
 */
interface Movable{
    void move() throws InterruptedException;
}

class Tank implements Movable {
    @Override
    public void move() throws InterruptedException {
        long start = System.currentTimeMillis();
        System.out.println("tank moving cla cla cla.....");
        Thread.sleep((long) (Math.random()*10000));/*模拟坦克移动时间*/
        long end = System.currentTimeMillis();
        System.out.println(end-start);
    }
}

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Tank tank = new Tank();
        tank.move();
    }
}
