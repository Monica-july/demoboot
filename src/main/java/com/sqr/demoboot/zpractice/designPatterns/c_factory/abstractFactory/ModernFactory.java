package com.sqr.demoboot.zpractice.designPatterns.c_factory.abstractFactory;

import com.sqr.demoboot.zpractice.designPatterns.c_factory.abstractFactory.food.Bread;
import com.sqr.demoboot.zpractice.designPatterns.c_factory.abstractFactory.food.Food;
import com.sqr.demoboot.zpractice.designPatterns.c_factory.abstractFactory.vehicle.Car;
import com.sqr.demoboot.zpractice.designPatterns.c_factory.abstractFactory.vehicle.Vehicle;
import com.sqr.demoboot.zpractice.designPatterns.c_factory.abstractFactory.weapon.AK47;
import com.sqr.demoboot.zpractice.designPatterns.c_factory.abstractFactory.weapon.Weapon;

public class ModernFactory extends AbstractFactory {
    @Override
    Food createFood() {
        return new Bread();
    }

    @Override
    Vehicle createVehicle() {
        return new Car();
    }

    @Override
    Weapon createWeapon() {
        return new AK47();
    }
}
