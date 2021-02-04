package com.sqr.demoboot.zpractice.algorithmbasic.sort.buketSort;

import java.util.Arrays;
import java.util.Enumeration;

/**
 * 桶排序思想
 * 基数排序
 *
 */
public class BucketSort {
    public static void main(String[] args) {
        int[] nums = {209,1534,8,123,87};
        nums = bucketSort(nums);
        System.out.println(Arrays.toString(nums));
    }
    public static int[] bucketSort(int[] nums){
        //最大位数计算
        int maxDigit = digitCount(nums);
        for (int i = 0; i < maxDigit ; i++) {
            //当前位数字出现次数统计
            int[] count = new int[10];
            for (int j = 0; j < nums.length ; j++) {
                int index = getDigit(nums[j],i);
                count[index]++;
            }
            int[] countTrieSum = new int[10];
            countTrieSum[0] = count[0];
            //计算大于等于index的元素个数
            for (int j = 1; j < count.length ; j++) {
                countTrieSum[j] = countTrieSum[j-1]+count[j];
            }
            int[] help = new int[nums.length];
            for (int j = nums.length-1; j >=0 ; j--) {
                int digitNum = getDigit(nums[j],i);
                help[countTrieSum[digitNum]-1] = nums[j];
                countTrieSum[digitNum] --;
            }
            nums = Arrays.copyOfRange(help,0,help.length);
        }
        return nums;
    }

    /**
     * 获取当前位数字
     * @param num
     * @param index
     * @return
     */
    public static int getDigit(int num,int index) {
        int temp = (int) (Math.pow(10,index));
        int rel = num/(temp)%10;
        return rel;
    }

    /**
     * 数组中元素最大位数计算
     * @param nums
     * @return
     */
    public static int digitCount(int[] nums){
        if (nums.length==0){
            return -1;
        }
        int maxDigit = 0;
        int[] digit = new int[nums.length];
        for (int i = 0; i < nums.length ; i++) {
            int temp = nums[i];
            while (temp!=0){
                digit[i]++;
                temp/=10;
            }
            maxDigit=maxDigit>digit[i]?maxDigit:digit[i];
        }
        return maxDigit;
    }
}
