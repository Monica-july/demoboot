package com.sqr.demoboot.zpractice.leetCode;

public class Util {
    public static int[] getRandomNums(int maxSize,int maxVal){
        int[] nums = new int[maxSize];
        for (int i=0 ; i<maxSize ; i++){
            nums[i] = (int)(Math.random()*(maxVal+1))-(int)(Math.random()*maxVal);
        }
        return nums;
    }
}
