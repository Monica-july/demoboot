package com.sqr.demoboot.zpractice.algorithmbasic.sort.mergeSort;

import java.util.Arrays;

/**
 * 归并排序
 */
public class MergeSort {
    public static void main(String[] args) {
        int[] nums = {3,4,1,2,5};
//        mergeSort1(nums);
        mergeSort2(nums);
        System.out.println(Arrays.toString(nums));
    }

    /**
     * mergeSort1  递归实现
     * @param nums
     */
    public static void mergeSort1(int[] nums){
        process(nums,0,nums.length-1);
    }
    public static void process(int[] nums,int left,int right){
        if (left==right){
            return;
        }
        int middle = (right+left)>>1;
        process(nums,left,middle);
        process(nums,middle+1,right);
        merge(nums,left,middle,right);
    }
    public static void merge(int[] nums,int left,int middle,int right){
        int[] help = new int[right-left+1];
        int pL = left;
        int pR = middle+1;
        int i=0;
        while (pL<=middle && pR <= right){
            help[i++] = nums[pL]<nums[pR]?nums[pL++]:nums[pR++];
        }
        while (pL<=middle){
            help[i++] = nums[pL++];
        }
        while (pR<=right){
            help[i++] = nums[pR++];
        }
        for (int j = 0; j < help.length ; j++) {
            nums[left+j] = help[j];
        }
    }

    /**
     * 非递归实现
     * @param nums
     */
    public static void mergeSort2(int[] nums){
        if (nums.length<=1){
            return;
        }
        int len = nums.length;
        int mergeSize = 1;//步长
        while (mergeSize<len){
            int left = 0;
            while (left<len){
                if (mergeSize>=(len-left)){
                    break;
                }
                int middle = left+mergeSize-1;
                int right = middle+Math.min(mergeSize,len-middle-1);
                merge(nums,left,middle,right);
                left = right+1;
            }
            if (mergeSize>(len>>1)){
                break;
            }
            mergeSize<<=1;
        }
    }
}
