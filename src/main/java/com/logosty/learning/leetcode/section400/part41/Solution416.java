package com.logosty.learning.leetcode.section400.part41;

import java.util.Arrays;

/**
 * @author logosty(ganyingle) on 2024/7/16 16:40
 * description: 416. 分割等和子集 中等
 * 给你一个 只包含正整数 的 非空 数组 nums 。请你判断是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,5,11,5]
 * 输出：true
 * 解释：数组可以分割成 [1, 5, 5] 和 [11] 。
 * 示例 2：
 * <p>
 * 输入：nums = [1,2,3,5]
 * 输出：false
 * 解释：数组不能分割成两个元素和相等的子集。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 200
 * 1 <= nums[i] <= 100
 */
public class Solution416 {
    public boolean canPartition(int[] nums) {
        int len = nums.length;

        Arrays.sort(nums);
        int sum = Arrays.stream(nums).sum();
        if (sum % 2 != 0) {
            return false;
        }
        int target = sum / 2;

//        dp[j]: 代表0-i的范围是否存在和为j的子集
        boolean[] dp = new boolean[target + 1];

//        初始化
        if (nums[0] <= target) {
            dp[nums[0]] = true;
        }

//        从第1层开始跑，每层仅仅依赖上一层的数值
        for (int i = 1; i < len; i++) {
            for (int j = target; j >= 1; j--) {
                if (j >= nums[i]) {
                    dp[j] = dp[j] || dp[j - nums[i]];
                }
            }
        }
        return dp[target];
    }
}
