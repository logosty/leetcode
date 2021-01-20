package com.logosty.learning.leetcode.section600.part62;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @author logosty(ganyingle) on 2021/1/20 10:52
 * 628. 三个数的最大乘积 简单
 * 给定一个整型数组，在数组中找出由三个数组成的最大乘积，并输出这个乘积。
 *
 * 示例 1:
 *
 * 输入: [1,2,3]
 * 输出: 6
 * 示例 2:
 *
 * 输入: [1,2,3,4]
 * 输出: 24
 * 注意:
 *
 * 给定的整型数组长度范围是[3,10^4]，数组中所有的元素范围是[-1000, 1000]。
 * 输入的数组中任意三个数的乘积不会超出32位有符号整数的范围。
 */
public class Solution628 {

  /**
   * 执行用时：
   * 12 ms
   * , 在所有 Java 提交中击败了
   * 69.60%
   * 的用户
   * 内存消耗：
   * 40 MB
   * , 在所有 Java 提交中击败了
   * 22.85%
   * 的用户
   */
  public int maximumProduct2(int[] nums) {
    if (nums.length == 3) {
      return nums[0] * nums[1] * nums[2];
    }

    Arrays.sort(nums);
    int res = nums[nums.length - 1] * nums[nums.length - 2] * nums[nums.length - 3];
    res = Math.max(res, nums[0] * nums[1] * nums[nums.length - 1]);
    return res;
  }

  /**
   * 执行用时：
   * 2 ms
   * , 在所有 Java 提交中击败了
   * 99.13%
   * 的用户
   * 内存消耗：
   * 40.1 MB
   * , 在所有 Java 提交中击败了
   * 16.82%
   * 的用户
   */
  public int maximumProduct(int[] nums) {
    if (nums.length == 3) {
      return nums[0] * nums[1] * nums[2];
    }

    // 最小的和第二小的
    int min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE;
    // 最大的、第二大的和第三大的
    int max1 = Integer.MIN_VALUE, max2 = Integer.MIN_VALUE, max3 = Integer.MIN_VALUE;

    for (int num : nums) {
      if (num > max1) {
        max3 = max2;
        max2 = max1;
        max1 = num;
      } else if (num > max2) {
        max3 = max2;
        max2 = num;
      } else if (num > max3) {
        max3 = num;
      }

      if (num < min1) {
        min2 = min1;
        min1 = num;
      } else if (num < min2) {
        min2 = num;
      }
    }

    return Math.max(min1 * min2 * max1, max1 * max2 * max3);
  }

  public static void main(String[] args) {
    System.out.println(new Solution628().maximumProduct(new int[]{1,2,3,4}));
  }
}
