package com.sqr.demoboot.zpractice.algorithmbasic.HalfSearchAndEOR;

/**
 * 一个数组中两个数出现了奇数次，其他数出现了偶数次，找出这个两个出现奇数次的数
 */
public class EorTest4 {
    public static void main(String[] args) {
        int[] nums = {1,1,1,1,3,3,3,2,2,2};
        int eor = 0;
        for (int i=0 ; i<nums.length ; i++){
            eor= eor^nums[i];
        }
        int eorOneIndex = eor&(-eor);
        int a = 0;
        for (int i=0 ; i<nums.length ; i++){
            if ((nums[i]&eorOneIndex)!=0){
                a = a^nums[i];
            }
        }
        int b = eor^a;
        System.out.println("a:"+a+"   b:"+b);
    }
}
