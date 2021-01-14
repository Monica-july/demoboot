package com.sqr.demoboot.zpractice.algorithmbasic.HalfSearchAndEOR;

/**
 * 交换两个数
 */
public class EorTest1 {
    public static void main(String[] args) {
        int a = 8;
        int b = 10;
        a = a^b;
        b = a^b;
        a = a^b;
        System.out.println(a);
        System.out.println(b);
    }
}
