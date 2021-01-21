package com.sqr.demoboot.zpractice.algorithmbasic.sort.heapSort;

import java.util.Arrays;

public class HeapSort {

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7,8,9,10,11,12};
//        heapSort1(nums);
        heapSort2(nums);
        System.out.println(Arrays.toString(nums));
    }

    /**
     * 0-n 个元素组成大根堆 从0到n依次添加到堆中 O(nlogn)
     * pop最大值 将0位置元素与heapSize-1位置元素交换，整理出新的大根堆 此时最大元素已排好序
     * 循环第二部，每次heapSize-- 直到heapSize==0 结束  排序完成
     * @param nums
     */
    private static void heapSort1(int[] nums){
        if (nums.length<=1){
            return;
        }
        for (int i = 0; i < nums.length ; i++) {
            heapInsert(nums,i);
        }
        int heapSize = nums.length;
        swap(nums,0,--heapSize);
        while (heapSize>0){
            heapify(nums,0,heapSize);
            swap(nums,0,--heapSize);
        }
    }

    /**
     * 组织大根堆步骤优化
     * heapSort1 是从0开始逐个添加
     * heapSort2 将原数组想象为一个完全二叉树
     * 从最后一个元素向上看，heapify 组织大根堆
     * @param nums
     */
    private static void heapSort2(int[] nums){
        if (nums.length<=1){
            return;
        }
        for (int i=nums.length-1 ; i>=0 ; i--){
            heapify(nums,i,nums.length);
        }
        int heapSize = nums.length;
        swap(nums,0,--heapSize);
        while (heapSize>0){
            heapify(nums,0,heapSize);
            swap(nums,0,--heapSize);
        }
    }
    private static void heapInsert(int[] nums,int index){
        while (nums[index]>nums[(index-1)/2]){
            swap(nums,index,(index-1)/2);
            index = (index-1)/2;
        }
    }
    private static void heapify(int[] nums,int index,int heapSize){
        int left = index*2+1;
        while (left<heapSize){
            int right = left+1 < heapSize ? left+1 :left;
            int largerIndex = nums[left]>nums[right]?left:right;
            if (nums[index]<nums[largerIndex]){
                swap(nums,index,largerIndex);
                index = largerIndex;
                left = index*2+1;
            }else {
                break;
            }
        }
    }
    private static void swap(int[] heap,int i,int j){
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }
}
