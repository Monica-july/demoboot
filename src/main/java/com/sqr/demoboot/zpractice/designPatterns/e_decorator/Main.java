package com.sqr.demoboot.zpractice.designPatterns.e_decorator;

public class Main {
    public static void main(String[] args) {
        Noodles noodles = new DaoxiaoNoodles();
        NoodlesDecorator decorator = new EggNoodles(new HamNoodles(noodles));
        decorator.createNoodles();
    }
}
