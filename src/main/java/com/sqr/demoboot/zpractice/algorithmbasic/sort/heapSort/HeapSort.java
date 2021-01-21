package com.sqr.demoboot.zpractice.algorithmbasic.sort.heapSort;

import java.util.Arrays;

public class HeapSort {

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5};
        heapSort(nums);
        System.out.println(Arrays.toString(nums));
    }
    private static void heapSort(int[] nums){
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
