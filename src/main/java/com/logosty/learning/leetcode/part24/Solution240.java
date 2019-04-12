package com.logosty.learning.leetcode.part24;

/**
 * Created with IDEA by logosty
 * Date:2019/4/10 Time:16:47
 * Description: 中等 240. 搜索二维矩阵 II
 *
 * 编写一个高效的算法来搜索 m x n 矩阵 matrix 中的一个目标值 target。该矩阵具有以下特性：
 *
 * 每行的元素从左到右升序排列。
 * 每列的元素从上到下升序排列。
 * 示例:
 *
 * 现有矩阵 matrix 如下：
 *
 * [
 *   [1,   4,  7, 11, 15],
 *   [2,   5,  8, 12, 19],
 *   [3,   6,  9, 16, 22],
 *   [10, 13, 14, 17, 24],
 *   [18, 21, 23, 26, 30]
 * ]
 * 给定 target = 5，返回 true。
 *
 * 给定 target = 20，返回 false。
 */
public class Solution240 {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int start, end;
        int[] curRow;
        int maxRightIndex = matrix[0].length - 1;

        for (int i = 0; i < matrix.length; i++) {
            curRow = matrix[i];
            if (curRow[0] > target) {
                return false;
            }
            if (curRow[0] == target) {
                return true;
            }


            if (curRow[curRow.length - 1] < target) {
                continue;
            }
            if (curRow[curRow.length - 1] == target) {
                return true;
            }

            start = 0;
            int index;
            end = maxRightIndex;

            while (true) {
                if (start == end || end == start + 1) {
                    if (curRow[start] == target || curRow[end] == target) {
                        return true;
                    } else {
                        break;
                    }
                }

                index = (start + end) / 2;

                if (curRow[index] == target) {
                    return true;
                }
                if (curRow[index] < target) {
                    start = index + 1;
                    continue;
                }

                maxRightIndex = index - 1;
                end = index - 1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1,2,3,4,5},
//                {2,5,8,12,19},
//                {3,6,9,16,22},
//                {10,13,14,17,24},
//                {18,21,23,26,30}
        };

        System.out.println(new Solution240().searchMatrix(matrix, 4));
    }

}
