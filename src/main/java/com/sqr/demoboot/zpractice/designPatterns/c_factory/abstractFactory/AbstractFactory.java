package com.sqr.demoboot.zpractice.designPatterns.c_factory.abstractFactory;

import com.sqr.demoboot.zpractice.designPatterns.c_factory.abstractFactory.food.Food;
import com.sqr.demoboot.zpractice.designPatterns.c_factory.abstractFactory.vehicle.Vehicle;
import com.sqr.demoboot.zpractice.designPatterns.c_factory.abstractFactory.weapon.Weapon;

public abstract class AbstractFactory {
    abstract Food createFood();
    abstract Vehicle createVehicle();
    abstract Weapon createWeapon();
}
