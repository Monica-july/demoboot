package com.sqr.demoboot.zpractice.designPatterns.k_iterator.v5_t;

import java.util.ArrayList;

/**
 * collection容器接口
 * 数组类型容器、链表类型容器
 * add、size、remove、get......
 * 问题：不同容器怎么实现遍历
 * 添加泛型
 */
public class Main {
    public static void main(String[] args) {
        MyCollection list = new MyArrayList();
//        MyCollection<String> list = new MyLinkedList();
        for (int i = 0; i <20 ; i++) {
            list.add(i+"a");
        }
        MyIterator<String> iterator = list.iterator();
        while (iterator.hasNext()){
            String data = iterator.next();
            System.out.println(data);
        }
    }
}
