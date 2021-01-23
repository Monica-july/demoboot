package com.sqr.demoboot.zpractice.designPatterns.g_observer.v5;

import java.util.ArrayList;
import java.util.List;

/**
 * child weakUp
 * father feed
 * mother hug
 * dog bark
 * 抽象出一个观察者 事件发生有对应的action动作
 * 具体的观察者实现接口
 * 在被观察的child中 维护一个观察者list 发生事件wakeUp时调用actionCry方法
 */
class Child{
    boolean cry = false;
    List<Observer> observers = new ArrayList<>();
    public void weakUp() {
        System.out.println("wake up! crying wuwuwu.......");
        cry = true;
        actionCry();
    }

    public void addObserver(Observer observer){
        observers.add(observer);
    }

    public void actionCry(){
        for (Observer observer:observers){
            observer.actionCry();
        }
    }
}
interface Observer{
    void actionCry();
}
class Father implements Observer{
    public void feed(){
        System.out.println("baby crying! feed!");
    }

    @Override
    public void actionCry() {
        feed();
    }
}
class Mother implements Observer{
    public void hug(){
        System.out.println("baby crying! hug baby.");
    }
    @Override
    public void actionCry() {
        hug();
    }
}
class Dog implements Observer{
    public void bark(){
        System.out.println("wang! wang! wang!");
    }
    @Override
    public void actionCry() {
        bark();
    }
}

public class Main {
    public static void main(String[] args) {
        Child child = new Child();
        child.observers.add(new Father());
        child.observers.add(new Mother());
        child.observers.add(new Dog());
        child.weakUp();
    }
}
