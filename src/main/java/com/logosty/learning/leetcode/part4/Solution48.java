package com.logosty.learning.leetcode.part4;

import java.util.Arrays;

/**
 * Created with IDEA by logosty
 * Date:2019/4/4 Time:16:14
 * Description:中等 48. 旋转图像
 *
 * 给定一个 n × n 的二维矩阵表示一个图像。
 *
 * 将图像顺时针旋转 90 度。
 *
 * 说明：
 *
 * 你必须在原地旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要使用另一个矩阵来旋转图像。
 *
 * 示例 1:
 *
 * 给定 matrix =
 * [
 *   [1,2,3],
 *   [4,5,6],
 *   [7,8,9]
 * ],
 *
 * 原地旋转输入矩阵，使其变为:
 * [
 *   [7,4,1],
 *   [8,5,2],
 *   [9,6,3]
 * ]
 * 示例 2:
 *
 * 给定 matrix =
 * [
 *   [ 5, 1, 9,11],
 *   [ 2, 4, 8,10],
 *   [13, 3, 6, 7],
 *   [15,14,12,16]
 * ],
 *
 * 原地旋转输入矩阵，使其变为:
 * [
 *   [15,13, 2, 5],
 *   [14, 3, 4, 1],
 *   [12, 6, 8, 9],
 *   [16, 7,10,11]
 * ]
 */
public class Solution48 {
    public void rotate(int[][] matrix) {
        for (int x = 0; x < matrix.length / 2; x++) {
            for (int y = x; y < matrix.length - 1 - x; y++) {
                int cur;
                int last;

                //1旋
                cur = matrix[y][matrix.length - 1 - x];
                matrix[y][matrix.length - 1 - x] = matrix[x][y];

                //2旋
                last = cur;
                cur = matrix[matrix.length - 1 - x][matrix.length - 1 - y];
                matrix[matrix.length - 1 - x][matrix.length - 1 - y] = last;

                //3旋
                last = cur;
                cur = matrix[matrix.length - 1 - y][x];
                matrix[matrix.length - 1 - y][x] = last;

                //4旋
                matrix[x][y] = cur;
            }

        }
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {5, 1, 9, 11},
                {2, 4, 8, 10},
                {13, 3, 6, 7},
                {15, 14, 12, 16}
        };

        for (int i = 0; i < matrix.length; i++) {
            System.out.println(Arrays.toString(matrix[i]));
        }

        System.out.println();
        new Solution48().rotate(matrix);

        for (int i = 0; i < matrix.length; i++) {
            System.out.println(Arrays.toString(matrix[i]));
        }


    }
}
