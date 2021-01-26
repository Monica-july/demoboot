package com.sqr.demoboot.zpractice.designPatterns.k_iterator.v2_myLinkedList;

public class MyLinkedList {
    private class Node{
        private Object obj;
        private Node next;
        public Node(Object obj) {
            this.obj = obj;
        }
    }
    private Node head = null;
    private Node tail = null;
    private int size = 0;

    public void add(Object data){
        Node node = new Node(data);
        if (head==null){
            head = node;
            tail = node;
        }
        tail.next = node;//尾结点指向新添加的节点
        tail = node;//新节点成为尾结点
        size++;
    }
    public int size(){
        return size;
    }
}
class Main{
    public static void main(String[] args) {
        MyLinkedList linkedList = new MyLinkedList();
        for (int i=0 ; i<20 ; i++){
            linkedList.add(i);
        }
        System.out.println(linkedList.size());
    }
}