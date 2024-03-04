package com.logosty.learning.leetcode.section100.part16;

/**
 * @author logosty(ganyingle) on 2024/3/4 16:33
 * description: 169. 多数元素 简单
 * 169. 多数元素
 * 已解答
 * 简单
 * 相关标签
 * 相关企业
 * 给定一个大小为 n 的数组 nums ，返回其中的多数元素。多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。
 *
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [3,2,3]
 * 输出：3
 * 示例 2：
 *
 * 输入：nums = [2,2,1,1,1,2,2]
 * 输出：2
 *
 *
 * 提示：
 * n == nums.length
 * 1 <= n <= 5 * 104
 * -109 <= nums[i] <= 109
 *
 *
 * 进阶：尝试设计时间复杂度为 O(n)、空间复杂度为 O(1) 的算法解决此问题。
 */
public class Solution169 {
    public int majorityElement(int[] nums) {
        int moreOne = -1;
        int moreOneTimes = 0;

        for (int num : nums) {
            if (moreOneTimes == 0) {
                moreOneTimes = 1;
                moreOne = num;
                continue;
            }

            if (num == moreOne) {
                moreOneTimes++;
            } else {
                moreOneTimes--;
            }
        }

        return moreOne;
    }
}
