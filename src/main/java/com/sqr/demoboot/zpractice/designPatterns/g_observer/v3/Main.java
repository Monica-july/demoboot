package com.sqr.demoboot.zpractice.designPatterns.g_observer.v3;

/**
 * 在孩子weakUp时调用父亲的feed方法
 * 缺点耦合度太高
 * 不适用与有多个观察者
 */
class Child{
    Father father = new Father();

    public void weakUp() {
        System.out.println("wake up! crying wuwuwu.......");
        father.feed();
    }
}
class Father{
    public void feed(){
        System.out.println("baby crying! feed!");
    }
}
public class Main {
    public static void main(String[] args) {
        Child child = new Child();
        child.weakUp();
    }
}
