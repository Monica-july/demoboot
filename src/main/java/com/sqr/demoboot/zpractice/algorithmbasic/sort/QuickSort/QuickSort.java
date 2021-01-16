package com.sqr.demoboot.zpractice.algorithmbasic.sort.QuickSort;

import java.util.Arrays;

/**
 * 快速排序
 * 分区1：基准num 小于等于基准的在左边 大于基准的在右边
 * 分区2：基准num 比基准小的在左边 等于基准的不动 比基准大的在右边（荷兰国旗划分问题）
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] nums = {1,3,4,2,5};
//        int[] nums = {8,7,6,5,4,3,2,1,0};
//        int[] nums = {1,2,3,4,5,6,7,8,9};
//        int[] nums = {1,1,1,1,1,1};

//        quickSort1(nums,0,nums.length-1);
        System.out.println(Arrays.toString(nums));
    }

    /**
     * 快速排序1
     * 思路：以第一个数为基准  从左向右找 找到一个比基准大的，从右向左找  找到一个比基准小的，交换
     * 基准位置元素与 右 指针位置元素交换
     * @param nums
     * @param left
     * @param right
     */
    public static void quickSort1(int[] nums,int left,int right){
        if (left>=right){
            return;
        }
        int mark = nums[left];
        int pl = left;
        int pr = right;
        while (pl<pr){
            while (pl<right){
                if (nums[pl]>mark){
                    break;
                }
                pl++;
            }
            while (left<pr){
                if (nums[pr]<mark){
                    break;
                }
                pr--;
            }
            if (pl<pr){
                swap(nums,pl,pr);
            }
        }
        nums[left] = nums[pr];
        nums[pr] = mark;
        quickSort1(nums,left,pr-1);
        quickSort1(nums,pr+1,right);
    }

    public static int partiton(int[] nums,int left,int right){
        if (left>right){
            return -1;
        }
        if (left==right){
            return left;
        }
        int pl = left;
        int pr = right-1;
        while (pl<pr){
//            if (nums[pl])
        }
        return 0;
    }


    public static void swap(int[] nums,int i,int j){
//        int temp = nums[i];
//        nums[i] = nums[j];
//        nums[j]  = temp;
        nums[i] = nums[i]^nums[j];
        nums[j] = nums[i]^nums[j];
        nums[i] = nums[i]^nums[j];
    }
}
