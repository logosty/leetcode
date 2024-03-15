package com.logosty.learning.leetcode.section000.part9;

/**
 * @author logosty(ganyingle) on 2024/3/15 16:23
 * description: 97. 交错字符串 中等
 * 给定三个字符串 s1、s2、s3，请你帮忙验证 s3 是否是由 s1 和 s2 交错 组成的。
 *
 * 两个字符串 s 和 t 交错 的定义与过程如下，其中每个字符串都会被分割成若干 非空
 * 子字符串
 * ：
 *
 * s = s1 + s2 + ... + sn
 * t = t1 + t2 + ... + tm
 * |n - m| <= 1
 * 交错 是 s1 + t1 + s2 + t2 + s3 + t3 + ... 或者 t1 + s1 + t2 + s2 + t3 + s3 + ...
 * 注意：a + b 意味着字符串 a 和 b 连接。
 *
 *
 *
 * 示例 1：
 *
 *
 * 输入：s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac"
 * 输出：true
 * 示例 2：
 *
 * 输入：s1 = "aabcc", s2 = "dbbca", s3 = "aadbbbaccc"
 * 输出：false
 * 示例 3：
 *
 * 输入：s1 = "", s2 = "", s3 = ""
 * 输出：true
 *
 *
 * 提示：
 *
 * 0 <= s1.length, s2.length <= 100
 * 0 <= s3.length <= 200
 * s1、s2、和 s3 都由小写英文字母组成
 *
 *
 * 进阶：您能否仅使用 O(s2.length) 额外的内存空间来解决它?
 */
public class Solution97 {

    //25ms击败5.08%使用 Java 的用户
    public boolean isInterleave(String s1, String s2, String s3) {
        int l1 = s1.length();
        int l2 = s2.length();
        int l3 = s3.length();

        if (l1 + l2 != l3) {
            return false;
        }

        //l1===row,l2===line
        boolean[][] dp = new boolean[l2 + 1][l1 + 1];

        //初始化第0层
        dp[0][0] = true;

        //从第0层到第n层
        for (int floor = 1; floor <= l3; floor++) {
            char tailChar = s3.charAt(floor - 1);

            for (int line = l2; line >= 0; line--) {
                for (int row = l1; row >= 0; row--) {
                    if (line + row != floor) {
                        dp[line][row] = false;
                        continue;
                    }

                    boolean r1 = false;
                    if (row != 0) {
                        r1 = s1.charAt(row - 1) == tailChar && dp[line][row - 1];
                    }
                    boolean r2 = false;
                    if (line != 0) {
                        r2 = s2.charAt(line - 1) == tailChar && dp[line - 1][row];
                    }

                    dp[line][row] = r1 || r2;
                }
            }
        }

        return dp[l2][l1];
    }
}
