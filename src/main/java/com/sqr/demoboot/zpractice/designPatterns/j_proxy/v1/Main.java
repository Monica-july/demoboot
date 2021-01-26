package com.sqr.demoboot.zpractice.designPatterns.j_proxy.v1;

/**
 * 问题：move方法需要记录坦克移动时间
 *
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
public class Main {
    public static void main(String[] args) throws InterruptedException {
        Tank tank = new Tank();
        tank.move();
    }
}
