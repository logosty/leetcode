package com.logosty.learning.leetcode.part7;

/**
 * Created with IDEA by logosty
 * Date:2019/4/10 Time:14:16
 * Description: 中等 74. 搜索二维矩阵
 *
 * 编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。该矩阵具有如下特性：
 *
 * 每行中的整数从左到右按升序排列。
 * 每行的第一个整数大于前一行的最后一个整数。
 * 示例 1:
 *
 * 输入:
 * matrix = [
 *   [1,   3,  5,  7],
 *   [10, 11, 16, 20],
 *   [23, 30, 34, 50]
 * ]
 * target = 3
 * 输出: true
 * 示例 2:
 *
 * 输入:
 * matrix = [
 *   [1,   3,  5,  7],
 *   [10, 11, 16, 20],
 *   [23, 30, 34, 50]
 * ]
 * target = 13
 * 输出: false
 */
public class Solution74 {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        //二分查找列
        int row;

        int start = 0;
        int end = matrix.length - 1;
        while (true) {
            row = (start + end) / 2;
            if (matrix[row][0] == target) {
                return true;
            }

            //大于
            if (matrix[row][0] > target) {
                if (row == 0) {
                    return false;
                }
                end = row - 1;
                continue;
            }

            //小于
            if (row == matrix.length - 1) {
                if (matrix[row][matrix[row].length - 1] == target) {
                    return true;
                }
                if (matrix[row][matrix[row].length - 1] > target) {
                    break;
                }
                return false;
            }

            if (matrix[row + 1][0] > target) {
                break;
            }
            if (matrix[row + 1][0] == target) {
                row++;
                break;
            }
            start = row + 1;
        }



        //二分查找行
        start = 0;
        end = matrix[row].length - 1;
        int index;
        while (true) {
            if (end == start + 1 || end == start) {
                return matrix[row][start] == target || matrix[row][end] == target;
            }
            index = (start + end) / 2;

            if (matrix[row][index] == target) {
                return true;
            }

            if (matrix[row][index] > target) {
                end = index - 1;
                continue;
            }

            start = index + 1;
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1},
                {3}
        };

        System.out.println(new Solution74().searchMatrix(matrix, 4));
    }
}
