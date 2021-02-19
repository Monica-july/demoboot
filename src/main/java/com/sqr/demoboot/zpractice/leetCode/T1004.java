package com.sqr.demoboot.zpractice.leetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个由若干 0 和 1 组成的数组 A，我们最多可以将 K 个值从 0 变成 1 。
 *
 * 返回仅包含 1 的最长（连续）子数组的长度。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：A = [1,1,1,0,0,0,1,1,1,1,0], K = 2
 * 输出：6
 * 解释：
 * [1,1,1,0,0,1,1,1,1,1,1]
 * 粗体数字从 0 翻转到 1，最长的子数组长度为 6。
 * 示例 2：
 *
 * 输入：A = [0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1], K = 3
 * 输出：10
 * 解释：
 * [0,0,1,1,1,1,1,1,1,1,1,1,0,0,0,1,1,1,1]
 * 粗体数字从 0 翻转到 1，最长的子数组长度为 10。
 *  
 *
 * 提示：
 *
 * 1 <= A.length <= 20000
 * 0 <= K <= A.length
 * A[i] 为 0 或 1
 *
 * 解题思路：滑动窗口
 * 两个左右指针
 * 移动思路：右指针主动前移，拖着左指针向前。右指针每次向前移动一步，左指针移动时移动多步。右指针主动前移探索未知，左指针被迫前移寻找合适边界。
 */
public class T1004 {
    public static void main(String[] args) {
        int[] A = {0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1};
        System.out.println(longestOnes(A,3));
    }
    public static int longestOnes(int[] A, int K) {
        int left = 0;
        int right = 0;
        int zeroCount = 0;
        int len = 0;
        while (right<A.length){
            if (A[right]==0)zeroCount++;
            while (zeroCount>K){
                if (A[left++]==0){
                    zeroCount--;
                }
            }
            len = Math.max(len,right-left+1);
            right++;
        }
        return len;
    }
}
