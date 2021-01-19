package com.sqr.demoboot.zpractice.designPatterns.c_factory;

/**
 * 任何可以产生对象的方法或者类，都可以称之为工厂
 */
public class Main {
    public static void main(String[] args) {
//        Moveable m = new Car();
//        Moveable m = new Plane();
//        m.go();
        /**
         * 简单工厂
         */
        Moveable moveable = F01_SimpleVehicleFactory.getSimpleVehicleFactory().createBroom();
        moveable.go();
    }
}
