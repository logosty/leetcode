package com.logosty.learning.leetcode.muti;

import java.util.Arrays;

/**
 * @author logosty(ganyingle) on 2025-11-03 13:24:47
 * description: 1000006. 一次编辑 [medium]
 * <p>字符串有三种编辑操作:插入一个英文字符、删除一个英文字符或者替换一个英文字符。 给定两个字符串，编写一个函数判定它们是否只需要一次(或者零次)编辑。</p>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>示例 1：</strong></p>
 *
 * <pre>
 * <strong>输入：</strong>
 * first = "pale"
 * second = "ple"
 * <strong>输出：</strong>True</pre>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>示例 2：</strong></p>
 *
 * <pre>
 * <strong>输入：</strong>
 * first = "pales"
 * second = "pal"
 * <strong>输出：</strong>False
 * </pre>
 */
class Solution1000006 {

    //IMPORTANT!! Submit Code Region Begin(Do not remove this line)
    class Solution {
        public boolean oneEditAway(String first, String second) {
            if (Math.abs(first.length() - second.length()) > 1) {
                return false;
            }
            if (first.isEmpty() || second.isEmpty()) {
                return true;
            }

            char[] chars1 = first.toCharArray();
            char[] chars2 = second.toCharArray();

            long[] dp = new long[chars1.length + 1];
            //初始化第一层 即 second 只取0个的情况
            Arrays.fill(dp, Integer.MAX_VALUE);
            dp[0] = 0;
            dp[1] = 1;

            for (int i = 1; i <= chars2.length; i++) {
                long lastLeft = dp[0];
                for (int j = 0; j <= chars1.length; j++) {
                    if (Math.abs(i - j) > 1) {
                        lastLeft = dp[j];
                        dp[j] = Integer.MAX_VALUE;
                        continue;
                    }
                    if (j == 0) {
                        lastLeft = dp[j];
                        dp[j] = dp[j] + 1;
                        continue;
                    }

                    long result = Math.min(dp[j - 1], dp[j]) + 1;
                    result = Math.min(result, Math.max(i, j));
                    result = Math.min(result, lastLeft + (chars1[j - 1] == chars2[i - 1] ? 0 : 1));

                    lastLeft = dp[j];
                    dp[j] = result;
                }
            }
            return dp[dp.length - 1] <= 1;
        }
    }
    //IMPORTANT!! Submit Code Region End(Do not remove this line)

    //    public static void main(String[] args) {
    //        new Solution().oneEditAway("islander", "islander");
    //    }
}
