package com.sqr.demoboot.zpractice.designPatterns.k_iterator.v5_t;

public class MyLinkedList<T> implements MyCollection<T> {
    private class Node{
        private T obj;
        private Node next;
        public Node(T obj) {
            this.obj = obj;
        }
    }
    private Node head = null;
    private Node tail = null;
    private int size = 0;
    @Override
    public void add(T data){
        Node node = new Node(data);
        if (head==null){
            head = node;
            tail = node;
        }
        tail.next = node;//尾结点指向新添加的节点
        tail = node;//新节点成为尾结点
        size++;
    }
    @Override
    public int size(){
        return size;
    }

    @Override
    public MyLinkedListIterator iterator() {
        return new MyLinkedListIterator();
    }

    private class MyLinkedListIterator implements MyIterator {
        int cousor = size;
        Node currentNode = head;
        @Override
        public boolean hasNext() {
            return cousor!=0;
        }

        @Override
        public T next() {
            T o = currentNode.obj;
            cousor--;
            currentNode = currentNode.next;
            return o;
        }
    }
}