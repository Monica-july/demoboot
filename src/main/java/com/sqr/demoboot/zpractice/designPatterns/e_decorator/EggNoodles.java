package com.sqr.demoboot.zpractice.designPatterns.e_decorator;

public class EggNoodles extends NoodlesDecorator {

    public EggNoodles(Noodles noodles) {
        super(noodles);
    }

    @Override
    public void createNoodles() {
        super.createNoodles();
        addEgg();
    }

    private void addEgg(){
        System.out.println("加一个鸡蛋");
    }
}
