package com.logosty.learning.leetcode.section3100.part317;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author logosty(ganyingle) on 2024/9/6 15:19
 * description: 3176. 求出最长好子序列 I 中等
 * 给你一个整数数组 nums 和一个 非负 整数 k 。如果一个整数序列 seq 满足在下标范围 [0, seq.length - 2] 中 最多只有 k 个下标 i 满足 seq[i] != seq[i + 1] ，那么我们称这个整数序列为 好 序列。
 *
 * 请你返回 nums 中 好
 * 子序列
 *  的最长长度。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [1,2,1,1,3], k = 2
 *
 * 输出：4
 *
 * 解释：
 *
 * 最长好子序列为 [1,2,1,1,3] 。
 *
 * 示例 2：
 *
 * 输入：nums = [1,2,3,4,5,1], k = 0
 *
 * 输出：2
 *
 * 解释：
 *
 * 最长好子序列为 [1,2,3,4,5,1] 。
 *
 *
 *
 * 提示：
 *
 * 1 <= nums.length <= 500
 * 1 <= nums[i] <= 109
 * 0 <= k <= min(nums.length, 25)
 */
public class Solution3176 {
    public int maximumLength(int[] nums, int k) {
        int length = nums.length;

        //包含以i结尾的数字的最多n次变化 的 最长子序列
        int[] dp = new int[length];
        dp[0] = 1;
        Map<Integer,Integer> lastOneCache = new HashMap<>();

        //上一行对应index的最大值
        int[] lastMaxValues = new int[length];
        lastMaxValues[0] = 1;

        for (int i = 0; i <= k; i++) {
            lastOneCache.clear();
            lastOneCache.put(nums[0], 0);
            int lastMax = 1;

            for (int j = 1; j < dp.length; j++) {
                int curNum = nums[j];
                if (i >= j) {
                    dp[j] = j + 1;
                    lastOneCache.put(curNum, j);
                    lastMax = lastMaxValues[j];
                    lastMaxValues[j] = dp[j];
                    continue;
                }

                int cur = 1;
                if (i > 0) {
                    cur = Math.max(cur, lastMax + 1);
                }

                //找到前一个相同数字的下标
                if (lastOneCache.containsKey(curNum)) {
                    cur = Math.max(cur, dp[lastOneCache.get(curNum)] + 1);
                }

                lastMax = lastMaxValues[j];
                dp[j] = cur;
                lastMaxValues[j] = Math.max(lastMaxValues[j - 1], dp[j]);
                lastOneCache.put(curNum, j);
            }
        }
        return Arrays.stream(dp).max().getAsInt();
    }

    public static void main(String[] args) {
        int[] nums = {10,10,11};
        new Solution3176().maximumLength(nums, 1);
    }
}
