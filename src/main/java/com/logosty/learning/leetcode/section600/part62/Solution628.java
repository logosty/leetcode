package com.logosty.learning.leetcode.section600.part62;

import java.util.Arrays;

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
  public int maximumProduct(int[] nums) {
    if (nums.length == 3) {
      return nums[0] * nums[1] * nums[2];
    }

    Arrays.sort(nums);
    int res = nums[nums.length - 1] * nums[nums.length - 2] * nums[nums.length - 3];
    res = Math.max(res, nums[0] * nums[1] * nums[nums.length - 1]);
    return res;
  }

  public static void main(String[] args) {
    System.out.println(new Solution628().maximumProduct(new int[]{1,2,3,4}));
  }
}
