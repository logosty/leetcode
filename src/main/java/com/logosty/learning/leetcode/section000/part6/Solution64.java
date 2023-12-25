package com.logosty.learning.leetcode.section000.part6;

import com.logosty.learning.dataStructureAndAlgorithm.dynamicprogramming.MinPathSum;

/**
 * @author logosty(ganyingle) on 2023/12/25 18:25
 * description: 64 最小路径和 中等
 * 给定一个包含非负整数的 m x n 网格 grid ，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
 *
 * 说明：每次只能向下或者向右移动一步。
 *
 *
 *
 * 示例 1：
 *
 *
 * 输入：grid = [[1,3,1],[1,5,1],[4,2,1]]
 * 输出：7
 * 解释：因为路径 1→3→1→1→1 的总和最小。
 * 示例 2：
 *
 * 输入：grid = [[1,2,3],[4,5,6]]
 * 输出：12
 *
 *
 * 提示：
 *
 * m == grid.length
 * n == grid[i].length
 * 1 <= m, n <= 200
 * 0 <= grid[i][j] <= 200
 */
public class Solution64 {
    public int minPathSum(int[][] m) {

        return process(m, 0, 0);
    }

    public int minPathSum2(int[][] m) {
        return dp(m);
    }

    /**
     * 当前处于x,y位置，返回到目标位置的最小值
     */
    public int process(int[][] m, int x, int y) {
        //达到目的地
        if (x == m.length - 1 && y == m[0].length - 1) {
            return m[x][y];
        }

        if (x == m.length - 1) {
            return process(m, x, y + 1) + m[x][y];
        }
        if (y == m[0].length - 1) {
            return process(m, x + 1, y)+ m[x][y];
        }

        //走右边
        int p1 = process(m, x + 1, y);
        //走下面
        int p2 = process(m, x, y + 1);
        if (p1 == -1) {
            return m[x][y] + p2;
        }
        if (p2 == -1) {
            return m[x][y] + p1;
        }

        return m[x][y] + Math.min(p1, p2);
    }

    public int dp(int[][] m) {
        int length = m.length;
        int weight = m[0].length;

        int[][] dp = new int[length][weight];
        dp[length - 1][weight - 1] = m[length - 1][weight - 1];
        for (int i = length - 2; i >= 0; i--) {
            dp[i][weight - 1] = dp[i + 1][weight - 1] + m[i][weight - 1];
        }
        for (int i = weight - 2; i >= 0; i--) {
            dp[length - 1][i] = dp[length - 1][i + 1] + m[length - 1][i];
        }

        for (int i = length - 2; i >= 0; i--) {
            for (int j = weight - 2; j >= 0; j--) {
                dp[i][j] = Math.min(dp[i + 1][j], dp[i][j + 1]) + m[i][j];
            }
        }
        return dp[0][0];
    }


    public static void main(String[] args) {
        int[][] m = {{1, 2, 3, 4, 5, 6, 7}, {2, 3, 4, 5, 6, 7, 8}, {2, 3, 4, 5, 6, 7, 8}};
        System.out.println(new MinPathSum().minPathSum(m));
        System.out.println(new MinPathSum().minPathSum2(m));
    }
}
