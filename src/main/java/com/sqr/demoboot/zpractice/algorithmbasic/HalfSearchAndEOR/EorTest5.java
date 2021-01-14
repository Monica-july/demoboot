package com.sqr.demoboot.zpractice.algorithmbasic.HalfSearchAndEOR;

import java.util.Arrays;

/**
 * 一个数组中一种数出现了k次，其他数出现了m次,并且m>1,k<m，找出这个出现k次的数
 * k=3,m=4
 */
public class EorTest5 {
    public static void main(String[] args) {
        int[] nums = {7,7,7,7,7,7,3,3,3,3,3,3,2,2,2};
        int[] oneCount = new int[32];
        for (int i=0 ; i<nums.length ; i++){

            int index = nums[i]^(nums[i]-1);
            oneCount[index]++;
        }
        int a = 0;
        for (int i=0 ; i<oneCount.length ; i++){
            if (oneCount[i]%4==0){
                oneCount[i] = 0;
            }else {
                oneCount[i] = 1;
            }
            a = a+oneCount[i]*(2<<i);
        }
        System.out.println(Arrays.toString(oneCount));
        System.out.println(a);
    }
}
                                                                                                               