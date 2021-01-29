package com.sqr.demoboot.zpractice.algorithmbasic.sort.heapSort;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MinHeapSort{
    public static void main(String[] args) {
        int testTime = 1000;
        int maxSize = 100;
        int maxVal = 100;
        int k = 10;
        for (int i = 0; i < testTime ; i++) {
            int[] nums = getRandomNums(maxSize,maxVal);
            int[] nums1 = Arrays.copyOf(nums,nums.length);
            int[] nums2 = Arrays.copyOf(nums,nums.length);
            //堆排序
            minHeapSort(nums1);
            Arrays.sort(nums2);
            if (isEqual(nums1,nums2)){
                System.out.println("success!!!");
            }else {
                System.out.println("error!!!");
                break;
            }
        }
    }
    private static void minHeapSort(int[] nums){
        if (nums.length<=1){
            return;
        }
        //小根堆
        PriorityQueue minHeap = new PriorityQueue();
        //添加数据
        for (int i = 0; i < nums.length ; i++) {
            minHeap.add(nums[i]);
        }
        //排序
        for (int i = 0; i < nums.length ; i++) {
            nums[i] = (int)minHeap.poll();
        }
    }
    private static int[] getRandomNums(int maxSize,int maxVal){
        int[] nums = new int[(int)(Math.random()*(maxSize+1))];
        for (int i=0 ; i<nums.length ; i++){
            nums[i] = (int)((maxVal+1)*Math.random())-(int)(maxVal*Math.random());
        }
//        Arrays.sort(nums);
//        //打乱顺序
//        for (int i=0 ; i<nums.length ; i++){
//
//        }
        return nums;
    }
    private static boolean isEqual(int[] nums1,int[] nums2){
        for (int i=0 ; i<nums1.length ; i++){
            if (nums1[i]!=nums2[i]){
                System.out.println(Arrays.toString(nums1));
                System.out.println(Arrays.toString(nums2));
                return false;
            }
        }
        return true;
    }
}