package com.sqr.demoboot.zpractice.algorithmbasic.HalfSearchAndEOR;

/**
 * 一个数组中一个数出现了奇数次，其他数出现了偶数次，找出这个出现奇数次的数
 */
public class EorTest2 {
    public static void main(String[] args) {
        int[] nums = {1,1,1,1,3,3,3};
        int eor = 0;
        for (int i=0 ; i<nums.length ; i++){
            eor= eor^nums[i];
        }
        System.out.println(eor);
    }
}
