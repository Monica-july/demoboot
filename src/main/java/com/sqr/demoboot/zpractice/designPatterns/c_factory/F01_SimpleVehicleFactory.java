package com.sqr.demoboot.zpractice.designPatterns.c_factory;

public class F01_SimpleVehicleFactory {
    private static final F01_SimpleVehicleFactory simpleVehicleFactory = new F01_SimpleVehicleFactory();
    private F01_SimpleVehicleFactory(){}

    public static F01_SimpleVehicleFactory getSimpleVehicleFactory() {
        return simpleVehicleFactory;
    }

    public Car createCar(){
        return new Car();
    }
    public Plane createPlane(){
        return new Plane();
    }
    public Broom createBroom(){
        return new Broom();
    }
}
