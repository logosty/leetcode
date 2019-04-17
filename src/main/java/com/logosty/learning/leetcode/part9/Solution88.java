package com.logosty.learning.leetcode.part9;

/**
 * Created with IDEA by logosty
 * Date:2019/4/12 Time:17:35
 * Description: 简单 88. 合并两个有序数组
 *
 * 给定两个有序整数数组 nums1 和 nums2，将 nums2 合并到 nums1 中，使得 num1 成为一个有序数组。
 *
 * 说明:
 *
 * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n。
 * 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
 * 示例:
 *
 * 输入:
 * nums1 = [1,2,3,0,0,0], m = 3
 * nums2 = [2,5,6],       n = 3
 *
 * 输出: [1,2,2,3,5,6]
 */
public class Solution88 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
//        todo
        if (n <= 0) {
            return;
        }

        for (int i = 0; i < nums1.length; i++) {
            if (nums1[i] > nums2[0]) {
                nums1[i] += nums2[0];
                nums2[0] = nums1[i] - nums2[0];
                nums1[i] -= nums2[0];
                resort(nums2);
            }
        }

        for (int i = 0; i < nums2.length; i++) {
            nums1[m + i] = nums2[i];
        }
    }

    public void resort(int[] nums) {
        if (nums.length <= 1) {
            return;
        }
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] <= nums[i + 1]) {
                return;
            }
            nums[i + 1] += nums[i];
            nums[i] = nums[i + 1] - nums[i];
            nums[i + 1] -= nums[i];
        }
    }
}
