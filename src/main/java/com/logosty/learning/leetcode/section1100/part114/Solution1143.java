package com.logosty.learning.leetcode.section1100.part114;

/**
 * @author logosty(ganyingle) on 2024/3/20 21:15
 * description: 1143. 最长公共子序列 中等
 * 给定两个字符串 text1 和 text2，返回这两个字符串的最长 公共子序列 的长度。如果不存在 公共子序列 ，返回 0 。
 *
 * 一个字符串的 子序列 是指这样一个新的字符串：它是由原字符串在不改变字符的相对顺序的情况下删除某些字符（也可以不删除任何字符）后组成的新字符串。
 *
 * 例如，"ace" 是 "abcde" 的子序列，但 "aec" 不是 "abcde" 的子序列。
 * 两个字符串的 公共子序列 是这两个字符串所共同拥有的子序列。
 *
 *
 *
 * 示例 1：
 *
 * 输入：text1 = "abcde", text2 = "ace"
 * 输出：3
 * 解释：最长公共子序列是 "ace" ，它的长度为 3 。
 * 示例 2：
 *
 * 输入：text1 = "abc", text2 = "abc"
 * 输出：3
 * 解释：最长公共子序列是 "abc" ，它的长度为 3 。
 * 示例 3：
 *
 * 输入：text1 = "abc", text2 = "def"
 * 输出：0
 * 解释：两个字符串没有公共子序列，返回 0 。
 *
 *
 * 提示：
 *
 * 1 <= text1.length, text2.length <= 1000
 * text1 和 text2 仅由小写英文字符组成。
 */
public class Solution1143 {
    public int longestCommonSubsequence(String text1, String text2) {
        int l1 = text1.length();
        int l2 = text2.length();

        //l2的长度
        int[] dp = new int[l2 + 1];

        //从第1层开始
        for (int row = 1; row <= l1; row++) {
            int leftDown = dp[0];
            for (int col = 1; col <= l2; col++) {
                int tmp = dp[col];
                //r1
                if (text1.charAt(row - 1) == text2.charAt(col - 1)) {
                    dp[col] = 1 + leftDown;
                } else {
                    //r2,r3
                    dp[col] = Math.max(dp[col - 1], dp[col]);
                }
                leftDown = tmp;

            }
        }

        return dp[l2];
    }

    public int longestCommonSubsequence1(String text1, String text2) {
        int[][] dp = new int[text1.length()][text2.length()];
        char[] charArray1 = text1.toCharArray();
        char[] charArray2 = text2.toCharArray();

        dp[0][0] = charArray1[0] == charArray2[0] ? 1 : 0;
        //构建第一行
        for (int i = 1; i < dp[0].length; i++) {
            if (dp[0][i - 1] == 1) {
                dp[0][i] = 1;
                continue;
            }
            dp[0][i] = charArray1[0] == charArray2[i] ? 1 : 0;
        }
        //构建第一列
        for (int i = 1; i < dp.length; i++) {
            if (dp[i - 1][0] == 1) {
                dp[i][0] = 1;
                continue;
            }
            dp[i][0] = charArray2[0] == charArray1[i] ? 1 : 0;
        }

        for (int row = 1; row < dp.length; row++) {
            for (int col = 1; col < dp[0].length; col++) {
                int cur = dp[row - 1][col - 1] + (charArray1[row] == charArray2[col] ? 1 : 0);
                cur = Math.max(cur, dp[row][col - 1]);
                cur = Math.max(cur, dp[row - 1][col]);
                dp[row][col] = cur;
            }
        }
        return dp[dp.length - 1][dp[0].length - 1];
    }

    public static void main(String[] args) {
        System.out.println(new Solution1143().longestCommonSubsequence("aaaa", "aaaa"));
    }
}
