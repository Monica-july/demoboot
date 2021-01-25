package com.sqr.demoboot.zpractice.designPatterns.k_iterator.v5_t;

public interface MyCollection<T> {
    void add(T obj);
    int size();
    MyIterator iterator();
}
