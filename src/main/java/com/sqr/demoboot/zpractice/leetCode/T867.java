package com.sqr.demoboot.zpractice.leetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *给你一个二维整数数组 matrix， 返回 matrix 的 转置矩阵 。
 *
 * 矩阵的 转置 是指将矩阵的主对角线翻转，交换矩阵的行索引与列索引。
 *
 * 2     4   -1        2   -10   18
 *-10    5   11   >>>  4    5    -7
 * 18    -7   6       -1    11    6
 *  
 * 示例 1：
 *
 * 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * 输出：[[1,4,7],[2,5,8],[3,6,9]]
 *
 * 示例 2：
 *
 * 输入：matrix = [[1,2,3],[4,5,6]]
 * 输出：[[1,4],[2,5],[3,6]]
 *  
 *
 * 提示：
 *
 * m == matrix.length
 * n == matrix[i].length
 * 1 <= m, n <= 1000
 * 1 <= m * n <= 105
 * -109 <= matrix[i][j] <= 109
 */
public class T867 {
    public static void main(String[] args) {
//        int[][] matrix = {{2,4,-1},{-10,5,11},{18,-7,6}};
        int[][] matrix = {{1,2,3},{4,5,6}};
        int[][] rel = transpose(matrix);
        for (int i = 0; i < rel.length; i++) {
            for (int j = 0; j < rel[i].length; j++) {
                System.out.printf(rel[i][j]+",");
            }
            System.out.println("");
        }
    }
    public static int[][] transpose(int[][] matrix) {
        int[][] rel = new int[matrix[0].length][matrix.length];
        for (int i = 0; i < matrix.length ; i++) {
            for (int j = 0; j < matrix[i].length ; j++) {
                rel[j][i] = matrix[i][j];
            }
        }
        List list = new ArrayList();
        list.add("");
        return rel;
    }
}
class Y{
    public static void main(String[] args) {
        int h;
        String key = "vlaue";
        System.out.println((h=key.hashCode())^(h>>>16));
    }
}
