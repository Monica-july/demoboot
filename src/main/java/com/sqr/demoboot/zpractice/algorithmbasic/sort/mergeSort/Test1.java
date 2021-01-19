package com.sqr.demoboot.zpractice.algorithmbasic.sort.mergeSort;

import java.util.Arrays;

/**
 * 小数和
 * 一个数组中左边比自己小的数的总和为小数和，求所有数的小数总和
 * {1,3,4,2,5}
 * 1左边：无
 * 3左边：1
 * 4左边：1,3
 * 2左边：1
 * 5左边：1,2,3,4
 * 解题思路： 利用归并排序merge比较的过程，根据下标计算出当前组右边有多少个数比自己大
 */
public class Test1 {
    public static void main(String[] args) {
        int[] nums = {1,3,4,2,5};
//        int samllSum = mergeSort1(nums);
        int samllSum = mergeSort2(nums);
        System.out.println(samllSum);
    }

    /**
     * mergeSort1  递归实现
     * @param nums
     */
    public static int mergeSort1(int[] nums){
        return process(nums,0,nums.length-1);
    }
    public static int process(int[] nums,int left,int right){
        if (left==right){
            return 0;
        }
        int middle = (right+left)>>1;
        return process(nums,left,middle)+
        process(nums,middle+1,right)+
        merge(nums,left,middle,right);
    }
    public static int merge(int[] nums,int left,int middle,int right){
        int[] help = new int[right-left+1];
        int pL = left;
        int pR = middle+1;
        int i=0;
        int rel = 0;
        while (pL<=middle && pR <= right){
            rel += nums[pL]<nums[pR]?(right-pR+1)*nums[pL]:0;//小数和统计
            help[i++] = nums[pL]<nums[pR]?nums[pL++]:nums[pR++];//排序
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
        return rel;
    }

    /**
     * 非递归实现
     * @param nums
     */
    public static int mergeSort2(int[] nums){
        int rel = 0;
        if (nums.length<=1){
            return 0;
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
                rel += merge(nums,left,middle,right);
                left = right+1;
            }
            if (mergeSize>(len>>1)){
                break;
            }
            mergeSize<<=1;
        }
        return rel;
    }
}
