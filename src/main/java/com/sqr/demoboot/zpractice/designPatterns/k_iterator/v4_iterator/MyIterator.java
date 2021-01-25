package com.sqr.demoboot.zpractice.designPatterns.k_iterator.v4_iterator;

/**
 * 容器遍历的迭代器接口
 * hasNext 检查是否还有下一个
 * next 获取下一个元素
 */
public interface MyIterator {
    boolean hasNext();
    Object next();
}
