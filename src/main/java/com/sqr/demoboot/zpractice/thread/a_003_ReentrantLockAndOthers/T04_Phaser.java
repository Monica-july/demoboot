package com.sqr.demoboot.zpractice.thread.a_003_ReentrantLockAndOthers;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Phaser;

/**
 * 阶段
 * 遗传算法 模拟达尔文进化论
 * 实例程序 婚礼
 * 四个步骤   arrive eat leave hug
 * 前三个步骤所有人都在  最后一个步骤只能是新郎新娘两个线程
 * 小程序有问题  待改
 */
class People{
    private String name;
    private Phaser phaser;

    public People(String name, Phaser phaser) {
        this.name = name;
        this.phaser = phaser;
    }

    public void arrive() throws InterruptedException {
        Thread.sleep((int)(Math.random()*3000));
        System.out.println(name+"到达现场");
        phaser.arriveAndAwaitAdvance();
    }
    public void eat() throws InterruptedException {
        Thread.sleep((int)(Math.random()*3000));
        System.out.println(name+"吃完");
        phaser.arriveAndAwaitAdvance();
    }
    public void leave() throws InterruptedException {
        Thread.sleep((int)(Math.random()*3000));
        System.out.println(name+"离开");
        phaser.arriveAndAwaitAdvance();
    }
    public void hug() throws InterruptedException {
        if (name.equals("新郎")||name.equals("新娘")){
            Thread.sleep((int)(Math.random()*3000));
            System.out.println(name+"洞房");
            phaser.arriveAndAwaitAdvance();
        }else {
            phaser.arriveAndDeregister();
        }
    }
}
class MyPhaer extends Phaser{
    @Override
    protected boolean onAdvance(int phase, int registeredParties) {
        switch (phase){
            case 0:
                System.out.println("所有人到达现场，婚礼正式开始");break;
            case 1:
                System.out.println("所有人吃完");break;
            case 2:
                System.out.println("所有人离开会场");break;
            case 3:
                System.out.println("新郎新娘拥抱。");break;
            default: break;
        }
        return true;
    }
}
public class T04_Phaser {
    public static void main(String[] args) {
        Phaser phaser = new MyPhaer();
        phaser.bulkRegister(7);
        List<Thread> threads = new ArrayList<>();
        for (int i = 0; i <7 ; i++) {
            People p;
            if (i==0){
                p = new People("新郎",phaser);
            } else if (i==1){
                p = new People("新娘",phaser);
            }else {
                p = new People("宾客"+i,phaser);
            }
            threads.add(new Thread(()->{
                try {
                    p.arrive();
                    p.eat();
                    p.leave();
                    p.hug();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }));
        }
        threads.forEach(t->t.start());
    }
}
