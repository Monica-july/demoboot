package com.sqr.demoboot.zpractice.designPatterns.k_iterator.v3_collection;

/**
 * collection容器接口
 * 数组类型容器、链表类型容器
 * add、size、remove、get......
 * 问题：不同容器怎么实现遍历
 */
public class Main {
    public static void main(String[] args) {
        MyCollection collection = new MyArrayList();
        for (int i = 0; i <20 ; i++) {
            collection.add(i);
        }
        System.out.println(collection.size());
    }
}
