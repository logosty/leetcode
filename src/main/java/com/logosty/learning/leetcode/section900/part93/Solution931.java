package com.logosty.learning.leetcode.section900.part93;

/**
 * @author logosty(ganyingle) on 2024/4/8 17:03
 * description: 931. 下降路径最小和 中等
 * 给你一个 n x n 的 方形 整数数组 matrix ，请你找出并返回通过 matrix 的下降路径 的 最小和 。
 * <p>
 * 下降路径 可以从第一行中的任何元素开始，并从每一行中选择一个元素。在下一行选择的元素和当前行所选元素最多相隔一列（即位于正下方或者沿对角线向左或者向右的第一个元素）。具体来说，位置 (row, col) 的下一个元素应当是
 * (row + 1, col - 1)、(row + 1, col) 或者 (row + 1, col + 1) 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：matrix = [[2,1,3],[6,5,4],[7,8,9]]
 * 输出：13
 * 解释：如图所示，为和最小的两条下降路径
 * 示例 2：
 * <p>
 * <p>
 * <p>
 * 输入：matrix = [[-19,57],[-40,-5]]
 * 输出：-59
 * 解释：如图所示，为和最小的下降路径
 * <p>
 * <p>
 * 提示：
 * <p>
 * n == matrix.length == matrix[i].length
 * 1 <= n <= 100
 * -100 <= matrix[i][j] <= 100
 */
public class Solution931 {
    public int minFallingPathSum(int[][] matrix) {
        int length = matrix.length;
        int weight = matrix[0].length;

        int[][] dp = new int[length][weight];

        //填充最后一层
        System.arraycopy(matrix[length - 1], 0, dp[length - 1], 0, weight);

        for (int row = length - 2; row >= 0; row--) {
            for (int col = 0; col < weight; col++) {
                int min = dp[row + 1][col];
                if (col >= 1) {
                    min = Math.min(min, dp[row + 1][col - 1]);
                }
                if (col < weight - 1) {
                    min = Math.min(min, dp[row + 1][col + 1]);
                }
                dp[row][col] = min + matrix[row][col];
            }
        }
        int res = dp[0][0];
        for (int i = 1; i < dp.length; i++) {
            res = Math.min(res, dp[0][i]);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Solution931().minFallingPathSum(
                new int[][] {{100, -42, -46, -41}, {31, 97, 10, -10}, {-58, -51, 82, 89}, {51, 81, 69, -51}}));
    }
}
