package com.sqr.demoboot.zpractice.designPatterns.k_iterator.v4_iterator;

import java.util.Arrays;

public class MyArrayList implements MyCollection {
    private Object[] o;
    private int index = 0;

    public MyArrayList() {
        this.o = new Object[10];
    }

    public MyArrayList(int len) {
        this.o = new Object[len];
    }
    @Override
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
    @Override
    public int size(){
        return index;
    }

    @Override
    public MyIterator iterator() {
        return new MyArrayListIterator();
    }
    private class MyArrayListIterator implements MyIterator{
        private int currentIndex = 0;
        @Override
        public boolean hasNext() {
            if (currentIndex<index){
                return true;
            }
            return false;
        }

        @Override
        public Object next() {
            return o[currentIndex++];
        }
    }
}