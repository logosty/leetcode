package com.logosty.learning.leetcode.section500.part51;

/**
 * @author logosty(ganyingle) on 2024/7/16 17:05
 * description: 516. 最长回文子序列 中等
 * 给你一个字符串 s ，找出其中最长的回文子序列，并返回该序列的长度。
 *
 * 子序列定义为：不改变剩余字符顺序的情况下，删除某些字符或者不删除任何字符形成的一个序列。
 *
 *
 *
 * 示例 1：
 *
 * 输入：s = "bbbab"
 * 输出：4
 * 解释：一个可能的最长回文子序列为 "bbbb" 。
 * 示例 2：
 *
 * 输入：s = "cbbd"
 * 输出：2
 * 解释：一个可能的最长回文子序列为 "bb" 。
 *
 *
 * 提示：
 *
 * 1 <= s.length <= 1000
 * s 仅由小写英文字母组成
 */
public class Solution516 {
    public int longestPalindromeSubseq(String s) {
        int len = s.length();

//        dp[i][j]: 代表下标从i开始到j结束的字串最长序列
        int[][] dp = new int[len][len];

        //初始化所有斜线和最下面一层
        for (int i = 0; i < len; i++) {
            dp[i][i] = 1;
        }

//      从最下面一层开始往上遍历
        for (int i = len - 2; i >= 0; i--) {
            for (int j = i + 1; j < len; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j - 1], Math.max(dp[i + 1][j], dp[i][j - 1]));
                }
            }
        }

        return dp[0][len - 1];
    }
}
