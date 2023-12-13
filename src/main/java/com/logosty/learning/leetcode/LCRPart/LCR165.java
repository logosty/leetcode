package com.logosty.learning.leetcode.LCRPart;

/**
 * @author logosty(ganyingle) on 2023/12/13 14:56
 * description: LCR 165. 解密数字 中等
 * 现有一串神秘的密文 ciphertext，经调查，密文的特点和规则如下：
 * <p>
 * 密文由非负整数组成
 * 数字 0-25 分别对应字母 a-z
 * 请根据上述规则将密文 ciphertext 解密为字母，并返回共有多少种解密结果。
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: ciphertext = 216612
 * 输出: 6
 * 解释: 216612 解密后有 6 种不同的形式，分别是 "cbggbc"，"vggbc"，"vggm"，"cbggm"，"cqggbc" 和 "cqggm"
 * <p>
 * <p>
 * 提示：
 * <p>
 * 0 <= ciphertext < 231
 */
public class LCR165 {
    public int crackNumber(int ciphertext) {
        int digit = 1;
        int ci = ciphertext;
        while (ci >= 10) {
            ci /= 10;
            digit++;
        }

        int[] dp = new int[digit];
        dp[digit - 1] = 1;

        ci = ciphertext;
        int cur, pre = -1, i = 1;

        while (ci != 0) {
            cur = ci % 10;
            ci /= 10;

            if (i == 1) {
                i++;
                pre = cur;
                continue;
            }

            //单转
            int ways = dp[digit - i + 1];

            //多转
            if (cur > 0 && cur * 10 + pre < 26) {
                ways += i > 2 ? dp[digit - i + 2] : 1;
            }

            dp[digit - i] = ways;
            pre = cur;
            i++;
        }

        return dp[0];
    }

    public static void main(String[] args) {
        System.out.println(new LCR165().crackNumber(1250156147));

    }

}
