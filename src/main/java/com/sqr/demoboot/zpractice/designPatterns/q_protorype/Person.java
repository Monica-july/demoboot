package com.sqr.demoboot.zpractice.designPatterns.q_protorype;

public class Person implements Cloneable{
    public String name;
    public int age;
    public Location location;

    public Person(String name, int age, Location location) {
        this.name = name;
        this.age = age;
        this.location = location;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                location.toString();
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
