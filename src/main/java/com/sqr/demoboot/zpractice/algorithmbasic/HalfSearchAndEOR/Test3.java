package com.sqr.demoboot.zpractice.algorithmbasic.HalfSearchAndEOR;

/**
 * 局部最小值问题
 * 条件 一个数总与下一个位置的数不同
 * 找出局部最小值
 * 解：一个数总与左右两个数一定不同，那么就有可能产生局部最小，两个特殊位置0，length-1
 */
public class Test3 {
    public static void main(String[] args) {
        int[] nums = {9,6,9,1,3,7,8,6,5,9,7,6,5,8,112};
        System.out.println(getPartMinIndex(nums,0,nums.length-1));
    }
    public static int getPartMinIndex(int[] nums,int left,int right){
        if (right>left){
            //关注两个特殊位置
            if (nums[left]<nums[left+1]){
                return 0;
            }
            if (nums[right]<nums[right-1]){
                return right;
            }
            int middle = (right+left)>>1;
            if (nums[middle]<nums[middle-1] && nums[middle]<nums[middle+1]){
                return middle;
            }else if (nums[middle]<nums[middle-1]){
                return getPartMinIndex(nums,middle,right);
            }else {
                return getPartMinIndex(nums,left,middle);
            }
        }
        return nums[left];
    }
}
