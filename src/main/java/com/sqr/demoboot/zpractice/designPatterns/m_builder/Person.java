package com.sqr.demoboot.zpractice.designPatterns.m_builder;

/**
 * 人
 */
public class Person {
    //基础信息
    private String name;
    private int age;
    private String gender;
    //学历
    private String school;
    private String grade;
    //location
    private String country;
    private String location;

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", school='" + school + '\'' +
                ", grade='" + grade + '\'' +
                ", country='" + country + '\'' +
                ", location='" + location + '\'' +
                '}';
    }

    public static class PersonBuilder{
        Person person = new Person();
        public PersonBuilder basicPersonBuild(String n,int a,String g){
            person.name = n;
            person.gender = g;
            return this;
        }
        public PersonBuilder schoolPersonBuild(String s,String g){
            person.school = s;
            person.grade = g;
            return this;
        }
        public PersonBuilder locationPersonBuild(String c,String l){
            person.country = c;
            person.location = l;
            return this;
        }
        public Person build(){
            return person;
        }
    }

}
