package com.sqr.demoboot.zpractice.designPatterns.k_iterator.v4_iterator;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * collection容器接口
 * 数组类型容器、链表类型容器
 * add、size、remove、get......
 * 问题：不同容器怎么实现遍历
 */
public class Main {
    public static void main(String[] args) {
//        MyCollection list = new MyArrayList();
        MyCollection list = new MyLinkedList();
        for (int i = 0; i <20 ; i++) {
            list.add(i);
        }
        MyIterator iterator = list.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next().toString());
        }
    }
}
