package com.sqr.demoboot.zpractice.designPatterns.q_protorype;

public class Location implements Cloneable {
    public String province;
    public String city;

    public Location(String province, String city) {
        this.province = province;
        this.city = city;
    }

    @Override
    public String toString() {
        return "Location{" +
                "province='" + province + '\'' +
                ", city='" + city + '\'' +
                '}';
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
