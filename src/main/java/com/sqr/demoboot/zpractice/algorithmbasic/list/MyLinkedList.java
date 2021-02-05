package com.sqr.demoboot.zpractice.algorithmbasic.list;

public class MyLinkedList<T> {
    Node<T> head;
    Node<T> tail;
    int size;

    public MyLinkedList() {
        head=null;
        tail=null;
        size=0;
    }
    /*添加节点*/
    public void insert(T t){
        Node<T> node = new Node<>(t);
        if (head==null){
            head = node;
            tail = node;
        }
        tail.next = node;
        tail=node;
    }
    /*删除节点*/

}
