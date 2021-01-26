package com.sqr.demoboot.zpractice.designPatterns.s_templateMethod;
abstract class F{
    void m(){
        opt1();
        opt2();
    }
    abstract void opt1();
    abstract void opt2();
}
class Sub extends F{

    @Override
    void opt1() {
        System.out.println("操作1");
    }

    @Override
    void opt2() {
        System.out.println("操作2");
    }
}
public class Main {
    public static void main(String[] args) {
        Sub sub = new Sub();
        sub.m();
    }
}
