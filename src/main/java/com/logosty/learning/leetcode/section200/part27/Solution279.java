package com.logosty.learning.leetcode.section200.part27;

/**
 * @author logosty(ganyingle) on 2024/3/20 19:22
 * description: 279. 完全平方数 中等
 * 给你一个整数 n ，返回 和为 n 的完全平方数的最少数量 。
 * <p>
 * 完全平方数 是一个整数，其值等于另一个整数的平方；换句话说，其值等于一个整数自乘的积。例如，1、4、9 和 16 都是完全平方数，而 3 和 11 不是。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 12
 * 输出：3
 * 解释：12 = 4 + 4 + 4
 * 示例 2：
 * <p>
 * 输入：n = 13
 * 输出：2
 * 解释：13 = 4 + 9
 * <p>
 * 提示：
 * <p>
 * 1 <= n <= 104
 */
public class Solution279 {
    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {

            int min = Integer.MAX_VALUE;
            for (int j = 1; j * j <= i; j++) {
                min = Math.min(min, 1 + dp[i - j * j]);
            }
            dp[i] = min;
        }
        return dp[n];

    }


    public static void main(String[] args) {
        System.out.println(new Solution279().numSquares(12));

    }
}
