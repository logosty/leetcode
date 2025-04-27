package com.logosty.learning.leetcode.section000.part16;

/**
 * @author logosty(ganyingle) on 2025/4/27 16:16
 * description: 寻找峰值 中等
 * 峰值元素是指其值严格大于左右相邻值的元素。
 * <p>
 * 给你一个整数数组 nums，找到峰值元素并返回其索引。数组可能包含多个峰值，在这种情况下，返回 任何一个峰值 所在位置即可。
 * <p>
 * 你可以假设 nums[-1] = nums[n] = -∞ 。
 * <p>
 * 你必须实现时间复杂度为 O(log n) 的算法来解决此问题。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,2,3,1]
 * 输出：2
 * 解释：3 是峰值元素，你的函数应该返回其索引 2。
 * 示例 2：
 * <p>
 * 输入：nums = [1,2,1,3,5,6,4]
 * 输出：1 或 5
 * 解释：你的函数可以返回索引 1，其峰值元素为 2；
 * 或者返回索引 5， 其峰值元素为 6。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 1000
 * -231 <= nums[i] <= 231 - 1
 * 对于所有有效的 i 都有 nums[i] != nums[i + 1]
 */
public class Solution162 {
    public int findPeakElement(int[] nums) {
        if (nums.length <= 2) {
            return nums[0] > nums[nums.length - 1] ? 0 : nums.length - 1;
        }

        return findPeakElement(nums, 0, nums.length - 1);
    }

    //    保证start和end中那个大的边界外一定是小于自己的
    private int findPeakElement(int[] nums, int start, int end) {
        if (start == end - 1) { //仅有2个元素，取大值
            return nums[start] > nums[end] ? start : end;
        }

        int mid = start + (end - start) / 2;

        if (nums[mid] < nums[start]) {
            return findPeakElement(nums, start, mid);
        }
        if (nums[mid] < nums[end]) {
            return findPeakElement(nums, mid, end);
        }

        //中间节点大于两侧
        if (nums[mid] < nums[mid - 1]) {
            return findPeakElement(nums, start, mid - 1);
        }

        if (nums[mid] < nums[mid + 1]) {
            return findPeakElement(nums, mid + 1, end);
        }
        return mid;
    }
}
