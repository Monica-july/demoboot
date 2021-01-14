package com.sqr.demoboot.zpractice.algorithmbasic.HalfSearchAndEOR;

/**
 * 2、有序数组中找到>=3的最左位置
 */
public class Test2 {
    public static void main(String[] args) {
        int[] nums = {1,2,3,3,4,5,6,7,8,9,10};
        System.out.println(getIndex(nums,0,nums.length,3));
    }
    public static int getIndex(int nums[],int left,int right,int target){
        //如果当前元素大于等于目标元素
        if (right>left){
            int middle = (right+left)>>1;
            if (nums[middle]>=target){
                //向左寻找
                return getIndex(nums,left,middle-1,3);
            }else {
                //向右寻找
                return getIndex(nums,middle+1,right,3);
            }
        }
        return nums[left];
    }
}
