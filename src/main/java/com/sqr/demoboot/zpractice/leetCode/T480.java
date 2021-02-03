package com.sqr.demoboot.zpractice.leetCode;

import com.sqr.demoboot.zpractice.thread.a_003_ReentrantLockAndOthers.threadLocal.M;

import java.util.Arrays;

/**
 * 中位数是有序序列最中间的那个数。如果序列的长度是偶数，则没有最中间的数；此时中位数是最中间的两个数的平均数。
 *
 * 例如：
 *
 * [2,3,4]，中位数是 3
 * [2,3]，中位数是 (2 + 3) / 2 = 2.5
 * 给你一个数组 nums，有一个长度为 k 的窗口从最左端滑动到最右端。窗口中有 k 个数，每次窗口向右移动 1 位。你的任务是找出每次窗口移动后得到的新窗口中元素的中位数，并输出由它们组成的数组。
 *
 *  
 *
 * 示例：
 *
 * 给出 nums = [1,3,-1,-3,5,3,6,7]，以及 k = 3。
 *
 * 窗口位置                      中位数
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       1
 *  1 [3  -1  -3] 5  3  6  7      -1
 *  1  3 [-1  -3  5] 3  6  7      -1
 *  1  3  -1 [-3  5  3] 6  7       3
 *  1  3  -1  -3 [5  3  6] 7       5
 *  1  3  -1  -3  5 [3  6  7]      6
 *  因此，返回该滑动窗口的中位数数组 [1,-1,-1,3,5,6]。
 *
 *  
 *
 * 提示：
 *
 * 你可以假设 k 始终有效，即：k 始终小于输入的非空数组的元素个数。
 * 与真实值误差在 10 ^ -5 以内的答案将被视作正确答案。
 */
public class T480 {
    public static void main(String[] args) {
        int maxSize = 10000;
        int maxVal = 1000000000;
        for (int i=0 ; i<10 ; i++){
            int[] nums = Util.getRandomNums(maxSize,maxVal);
            System.out.println(Arrays.toString(nums));
            int k = 0;
            while (k==0){
                k = Math.abs((int)(Math.random()*nums.length));
            }
            System.out.println(k);
            long start = System.currentTimeMillis();
            double[] rel = medianSlidingWindow(nums,k);
            System.out.println(Arrays.toString(rel));
            long end = System.currentTimeMillis();
            System.out.println(i+"====================================="+(end-start));
        }
    }
    public static double[] medianSlidingWindow(int[] nums, int k) {
        double[] rel = new double[nums.length-k+1];
        for (int i = k-1,j=0 ; i < nums.length ; i++,j++) {
            int start = i-k+1;
            int[] windowCopy = Arrays.copyOfRange(nums,start,start+k);
            sort(windowCopy);
            if (k%2==0){
                rel[j] = ((double) (windowCopy[(k-1)/2]))/2+((double) (windowCopy[(k-1)/2+1]))/2;
            }else {
                rel[j] = windowCopy[(k-1)/2];
            }
        }
        return rel;
    }
    public static void sort(int[] nums){
        quickSort(nums,0,nums.length-1);
    }
    public static void quickSort(int[] nums,int left,int right){
        if (left>=right){
            return;
        }
        int mark = nums[left];
        int pl = left;
        int pr = right;
        while (pl<pr){
            while(pl<=right&&nums[pl]<=mark){
                pl++;
            }
            while(pr>left&&nums[pr]>=mark){
                pr--;
            }
            if (pl<pr){
                swap(nums,pl,pr);
            }
        }
        nums[left] = nums[pr];
        nums[pr] = mark;
        quickSort(nums,left,pr-1);
        quickSort(nums,pr+1,right);
    }
    public static void swap(int[] nums,int i,int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
