package com.sqr.demoboot.zpractice.designPatterns.q_protorype;

public class Main {
    public static void main(String[] args) throws CloneNotSupportedException {
        Location location = new Location("云南省","贵州");
        Person person = new Person("姜云升",28,location);
        //浅克隆 只克隆当前对象 其引用类型成员均指向原对象的内存地址
        Person personClone = (Person) person.clone();
        System.out.println(personClone.location==person.location);
        //深克隆 引用类型实现cloneable接口 重写clone方法 并执行clone操作
        personClone.location = (Location)person.location.clone();
        System.out.println(personClone.location==person.location);
    }
}
