package com.sqr.demoboot.zpractice.designPatterns.c_factory.abstractFactory;

import com.sqr.demoboot.zpractice.designPatterns.c_factory.abstractFactory.food.Food;
import com.sqr.demoboot.zpractice.designPatterns.c_factory.abstractFactory.food.MushRoom;
import com.sqr.demoboot.zpractice.designPatterns.c_factory.abstractFactory.vehicle.Vehicle;
import com.sqr.demoboot.zpractice.designPatterns.c_factory.abstractFactory.weapon.Weapon;

public class Main {
    public static void main(String[] args) {
//        AbstractFactory factory = new MagicFactory();//魔法世界
        AbstractFactory factory = new ModernFactory();//现代世界
        Food food = factory.createFood();
        food.eat();
        Vehicle vehicle = factory.createVehicle();
        vehicle.go();
        Weapon weapon =factory.createWeapon();
        weapon.shoot();
    }
}
