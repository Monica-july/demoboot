package com.sqr.demoboot.zpractice.algorithmbasic.HalfSearchAndEOR;

/**
 * 1、有序数组查找指定元素 3
 */
public class Test1 {
    public static void main(String[] args) {
        int[] nums = {1,2,3,3,4,5,6,7,8,9,10,15,17,19,19,19,20,21,23,23,24,25};
        System.out.println(getIndex(nums,0,nums.length-1,23));
    }
    public static int getIndex(int[] nums,int left,int right,int target){
        int middle = (right+left)>>1;
        if (right>=left){
            if (nums[middle]==target){
                return middle;
            }else if (nums[middle]>target){
                return getIndex(nums,left,middle,target);
            }else {
                return getIndex(nums,middle,right,target);
            }
        }
        return -1;
    }
}
