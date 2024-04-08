package com.logosty.learning.leetcode.section700.part74;

import java.util.Arrays;

/**
 * @author logosty(ganyingle) on 2024/4/8 16:45
 * description: 740. 删除并获得点数 中等
 * 给你一个整数数组 nums ，你可以对它进行一些操作。
 * <p>
 * 每次操作中，选择任意一个 nums[i] ，删除它并获得 nums[i] 的点数。之后，你必须删除 所有 等于 nums[i] - 1 和 nums[i] + 1 的元素。
 * <p>
 * 开始你拥有 0 个点数。返回你能通过这些操作获得的最大点数。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [3,4,2]
 * 输出：6
 * 解释：
 * 删除 4 获得 4 个点数，因此 3 也被删除。
 * 之后，删除 2 获得 2 个点数。总共获得 6 个点数。
 * 示例 2：
 * <p>
 * 输入：nums = [2,2,3,3,3,4]
 * 输出：9
 * 解释：
 * 删除 3 获得 3 个点数，接着要删除两个 2 和 4 。
 * 之后，再次删除 3 获得 3 个点数，再次删除 3 获得 3 个点数。
 * 总共获得 9 个点数。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 2 * 104
 * 1 <= nums[i] <= 104
 */
public class Solution740 {
    public int deleteAndEarn(int[] nums) {
        Arrays.sort(nums);

        int contains = nums[0];
        int notContains = 0;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                contains += nums[i];
                continue;
            }

            int max = Math.max(contains, notContains);
            //不相邻，那就无所谓了
            if (nums[i] != nums[i - 1] + 1) {
                contains = max + nums[i];
                notContains = max;
            } else {
                //相邻
                contains = notContains + nums[i];
                notContains = max;
            }
        }
        return Math.max(contains, notContains);
    }

    public static void main(String[] args) {
        System.out.println(new Solution740().deleteAndEarn(new int[] {2, 3, 3, 4}));
    }
}
