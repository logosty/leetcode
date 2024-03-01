package com.logosty.learning.leetcode.section2300.part236;

/**
 * @author logosty(ganyingle) on 2024/3/1 17:26
 * description: 2369.检查数组是否存在有效划分 中等
 * 给你一个下标从 0 开始的整数数组 nums ，你必须将数组划分为一个或多个 连续 子数组。
 * <p>
 * 如果获得的这些子数组中每个都能满足下述条件 之一 ，则可以称其为数组的一种 有效 划分：
 * <p>
 * 子数组 恰 由 2 个相等元素组成，例如，子数组 [2,2] 。
 * 子数组 恰 由 3 个相等元素组成，例如，子数组 [4,4,4] 。
 * 子数组 恰 由 3 个连续递增元素组成，并且相邻元素之间的差值为 1 。例如，子数组 [3,4,5] ，但是子数组 [1,3,5] 不符合要求。
 * 如果数组 至少 存在一种有效划分，返回 true ，否则，返回 false 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [4,4,4,5,6]
 * 输出：true
 * 解释：数组可以划分成子数组 [4,4] 和 [4,5,6] 。
 * 这是一种有效划分，所以返回 true 。
 * 示例 2：
 * <p>
 * 输入：nums = [1,1,1,2]
 * 输出：false
 * 解释：该数组不存在有效划分。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 2 <= nums.length <= 105
 * 1 <= nums[i] <= 106
 */
public class Solution2369 {
    public boolean validPartition(int[] nums) {
        if (nums.length <= 1) {
            return false;
        }
        return validPartitionCount(nums, 0, 1);
    }

    public boolean validPartitionCount(int[] nums, int startIndex, int currentIndex) {
        if (startIndex >= nums.length) {
            return true;
        }
        if (currentIndex >= nums.length) {
            return false;
        }
        //相邻
        if (currentIndex == startIndex + 1) {
            //相等
            if (nums[currentIndex] == nums[startIndex]) {
                return validPartitionCount(nums, startIndex, currentIndex + 1) ||
                        //截断重新开始
                        validPartitionCount(nums, currentIndex + 1, currentIndex + 2);
            } else {
                //不相等且不连续
                if (nums[currentIndex] != nums[startIndex] + 1) {
                    return false;
                }
                //不相等但连续
                return validPartitionCount(nums, startIndex, currentIndex + 1);
            }
        } else {
            //保证传递下来的必是相等或者已经连续两个
            //相等的情况
            if (nums[startIndex] == nums[startIndex + 1]) {
                return nums[startIndex] == nums[currentIndex]
                        //截断重新开始
                        && validPartitionCount(nums, currentIndex + 1, currentIndex + 2);
            } else {
                //连续的情况
                return nums[startIndex] == nums[currentIndex] - 2
                        //截断重新开始
                        && validPartitionCount(nums, currentIndex + 1, currentIndex + 2);
            }
        }
    }

    public static void main(String[] args) {
        int[] ints = new int[]{1,1,3,3,4,5};
        System.out.println(new Solution2369().validPartition(ints));
    }
}
