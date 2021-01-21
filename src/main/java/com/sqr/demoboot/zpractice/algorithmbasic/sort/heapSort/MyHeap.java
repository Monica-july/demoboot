package com.sqr.demoboot.zpractice.algorithmbasic.sort.heapSort;

import java.util.Arrays;

public class MyHeap {
    private int[] heap;
    private int heapSize;
    private int limit;
    //

    public MyHeap(int limit) {
        this.heap = new int[limit];
        this.limit = limit;
        this.heapSize = 0;
    }
    /*
    * 是否为空
    * */
    public boolean isEmpty(){
        return heapSize==0;
    }
    /*
    * 是否已满
    * */
    public boolean isFull(){
        return heapSize==limit;
    }
    /*
    * 添加节点
    * */
    public void push(int value){
        if (isFull()){
            System.out.println("heap is full");
            return;
        }
        //新增节点
        heap[heapSize] = value;
        //元素位置调整
        heapInsert(heap,heapSize++);
    }
    //添加新节点 向上看 调整堆为大根堆
    private void heapInsert(int[] heap, int index) {
        //退出循环条件  1、index==0  2、当前位置元素小于父节点位置元素
        while (heap[index]>heap[(index-1)/2]){
            swap(heap,index,(index-1)/2);
            index = (index-1)/2;
        }
    }
    /*
    * 弹出最大值
    * */
    public int pop(){
        int max = heap[0];
        swap(heap,0,--heapSize);
        heapify(heap,0,heapSize);
        return max;
    }
    private void heapify(int[] heap,int index,int heapSize){
        int left = index*2+1;//计算左孩子节点位置
        while (left<heapSize){ //边界条件  无左节点
            int right = index*2+2>=heapSize?index*2+1:index*2+2;//右孩子节点位置计算  如果没有右孩子 则right=left
            int largest = heap[left]> heap[right]?left:right;//父节点与孩子节点大小
            if (heap[index]<heap[largest]){
                swap(heap,index,largest);
                index = largest;
                left = index*2+1;
            }else {
                break;
            }
        }
    }
    private void swap(int[] heap,int i,int j){
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    @Override
    public String toString() {
        return "MyHeap{" +
                "heap=" + Arrays.toString(heap) +
                '}';
    }

    public static void main(String[] args) {
        int limit = 10;
        MyHeap heap = new MyHeap(limit);
        for (int i=0 ; i<limit ; i++){
            heap.push(i+1);
        }
        System.out.println(heap.toString());
        for (int i=0 ; i<heap.limit ; i++){
            System.out.println(heap.pop());
        }
        System.out.println(heap.toString());
    }
}
