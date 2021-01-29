package com.sqr.demoboot.zpractice.designPatterns.g_observer.v4;

import java.util.ArrayList;
import java.util.List;

/**
 * child weakUp
 * father feed
 * mother hug
 * dog bark
 */
class Child{
    boolean cry = false;
    Father father = new Father();
    Mother mother = new Mother();
    Dog dog = new Dog();
    public void weakUp() {
        System.out.println("wake up! crying wuwuwu.......");
        cry = true;
        father.feed();
        mother.hug();
        dog.bark();
    }

}
class Father {
    public void feed(){
        System.out.println("baby crying! feed!");
    }
}

class Mother {
    public void hug(){
        System.out.println("baby crying! hug baby.");
    }
}

class Dog {
    public void bark(){
        System.out.println("wang! wang! wang!");
    }
}

public class Main {
    public static void main(String[] args) {
        Child child = new Child();
        child.weakUp();
    }
}
