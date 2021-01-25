package com.sqr.demoboot.zpractice.designPatterns.m_builder;

public class Main {
    public static void main(String[] args) {
        Person person = new Person.PersonBuilder()
                .basicPersonBuild("张三",16,"男")
                .schoolPersonBuild("北京人大附中","高二")
                .locationPersonBuild("中国","北京").build();
        System.out.println(person.toString());
    }
}
