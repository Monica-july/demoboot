package com.sqr.demoboot.zpractice.designPatterns.k_iterator.v4_iterator;

public interface MyCollection {
    void add(Object obj);
    int size();
    MyIterator iterator();
}
