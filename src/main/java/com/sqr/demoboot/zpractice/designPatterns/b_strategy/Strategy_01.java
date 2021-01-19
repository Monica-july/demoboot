package com.sqr.demoboot.zpractice.designPatterns.b_strategy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * 策略模式
 * java中的 comparator就是一种策略模式
 */
class Person{
    int age;
    String name;

    public Person() {
    }

    public Person(int age, String name) {
        this.age = age;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}
class PersonComparator implements Comparator<Person>{

    @Override
    public int compare(Person o1, Person o2) {
        if (o1.age>o2.age){
            return 1;
        }else if (o1.age<o2.age){
            return -1;
        }
        return 0;
    }
}
public class Strategy_01 {
    public static void main(String[] args) {
        List<Person> people = new ArrayList<>();
        Person person1 = new Person(23,"tom");
        Person person2 = new Person(21,"joey");
        Person person3 = new Person(29,"herry");
        Person person4 = new Person(27,"jerry");
        people.add(person1);
        people.add(person2);
        people.add(person3);
        people.add(person4);
//        Collections.sort(people,new PersonComparator());
        Collections.sort(people, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                if (o1.age>o2.age){
                    return 1;
                }else if (o1.age<o2.age){
                    return -1;
                }
                return 0;
            }
        });
        for (Person p:people) {
            System.out.println(p.toString());
        }
    }
}
