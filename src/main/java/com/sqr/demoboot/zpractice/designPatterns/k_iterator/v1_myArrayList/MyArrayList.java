package com.sqr.demoboot.zpractice.designPatterns.k_iterator.v1_myArrayList;

import java.util.Arrays;

public class MyArrayList {
    private Object[] o;
    private int index = 0;

    public MyArrayList() {
        this.o = new Object[10];
    }

    public MyArrayList(int len) {
        this.o = new Object[len];
    }

    public void add(Object obj) {
        if (o.length==index){
            o = Arrays.copyOf(o,o.length*2);
        }
        o[index] = obj;
        index++;
    }

    public Object get(int index){
        if (index<this.index){
            return o[index];
        }
        return null;
    }
    public int size(){
        return index;
    }
}
class Main{
    public static void main(String[] args) {
        MyArrayList myArrayList = new MyArrayList();
        for (int i=0 ; i<20 ; i++){
            myArrayList.add(""+i);
        }
        System.out.println(myArrayList.size());
    }
}