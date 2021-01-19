package com.sqr.demoboot.zpractice.designPatterns.e_decorator;

public class HamNoodles extends NoodlesDecorator {

    public HamNoodles(Noodles noodles) {
        super(noodles);
    }

    @Override
    public void createNoodles() {
        super.createNoodles();
        adaHam();
    }

    private void adaHam(){
        System.out.println("加一根火腿");
    }
}
