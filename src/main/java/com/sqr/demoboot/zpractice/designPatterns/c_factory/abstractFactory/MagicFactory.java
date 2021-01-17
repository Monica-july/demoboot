package com.sqr.demoboot.zpractice.designPatterns.c_factory.abstractFactory;

import com.sqr.demoboot.zpractice.designPatterns.c_factory.abstractFactory.food.Food;
import com.sqr.demoboot.zpractice.designPatterns.c_factory.abstractFactory.food.MushRoom;
import com.sqr.demoboot.zpractice.designPatterns.c_factory.abstractFactory.vehicle.Broom;
import com.sqr.demoboot.zpractice.designPatterns.c_factory.abstractFactory.vehicle.Vehicle;
import com.sqr.demoboot.zpractice.designPatterns.c_factory.abstractFactory.weapon.Laser;
import com.sqr.demoboot.zpractice.designPatterns.c_factory.abstractFactory.weapon.Weapon;

public class MagicFactory extends AbstractFactory {
    @Override
    Food createFood() {
        return new MushRoom();
    }

    @Override
    Vehicle createVehicle() {
        return new Broom();
    }

    @Override
    Weapon createWeapon() {
        return new Laser();
    }
}
