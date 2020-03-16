package com.logosty.learning.leetcode.part9;

import java.util.Arrays;

/**
 * Created with IDEA by logosty Date:2019/4/12 Time:17:35
 * Description: 简单 88. 合并两个有序数组
 * <p>
 * 给定两个有序整数数组 nums1 和 nums2，将 nums2 合并到 nums1 中，使得 num1 成为一个有序数组。
 * <p>
 * 说明:
 * <p>
 * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n。 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。 示例:
 * <p>
 * 输入: nums1 = [1,2,3,0,0,0], m = 3 nums2 = [2,5,6],       n = 3
 * <p>
 * 输出: [1,2,2,3,5,6]
 */
public class Solution88 {

  public void merge(int[] nums1, int m, int[] nums2, int n) {
    int posRes = n + m - 1;

    while (posRes >= 0) {

      if (m - 1 < 0) {
        nums1[posRes] = nums2[n - 1];
        n--;
        posRes--;
        continue;
      } else if (n - 1 < 0) {
        nums1[posRes] = nums1[m - 1];
        m--;
        posRes--;
        continue;
      }

      if (nums2[n - 1] >= nums1[m - 1]) {
        nums1[posRes] = nums2[n - 1];
        n--;
      } else {
        nums1[posRes] = nums1[m - 1];
        m--;
      }
      posRes--;


    }

  }

  public static void main(String[] args) {
    int[] nums1 = {1, 2, 3, 0, 0, 0};
    int[] nums2 = {2, 5, 6};

    new Solution88().merge(nums1, 3, nums2, 3);

    System.out.println(Arrays.toString(nums1));
  }
}
