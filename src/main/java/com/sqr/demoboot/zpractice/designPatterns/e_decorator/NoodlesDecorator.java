package com.sqr.demoboot.zpractice.designPatterns.e_decorator;

public abstract class NoodlesDecorator extends Noodles{
    protected Noodles noodles;

    public NoodlesDecorator(Noodles noodles) {
        this.noodles = noodles;
    }

    public void createNoodles(){
        noodles.createNoodles();
    }

}
