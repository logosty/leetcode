package com.logosty.learning.leetcode.section000.part3;

import java.util.Arrays;

/**
 * @author logosty(ganyingle) on 2020/11/10 10:54
 * 31. 下一个排列 中等
 * 实现获取下一个排列的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。
 *
 * 如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。
 *
 * 必须原地修改，只允许使用额外常数空间。
 *
 * 以下是一些例子，输入位于左侧列，其相应输出位于右侧列。
 * 1,2,3 → 1,3,2
 * 3,2,1 → 1,2,3
 * 1,1,5 → 1,5,1
 */
public class Solution31 {

  public static void main(String[] args) {
    int[] ints = {3,2,1};

    System.out.println(Arrays.toString(ints));
    new Solution31().nextPermutation(ints);
    System.out.println(Arrays.toString(ints));
  }

  /**
   * 执行用时：
   * 1 ms
   * , 在所有 Java 提交中击败了
   * 98.72%
   * 的用户
   * 内存消耗：
   * 38.7 MB
   * , 在所有 Java 提交中击败了
   * 85.34%
   * 的用户
   * @param nums
   */
  public void nextPermutation(int[] nums) {
    if (nums.length <= 1) {
      return;
    }

    for (int i = nums.length - 2; i >= 0; i--) {
      int cur = nums[i];
      if (cur >= nums[i + 1]) {
        continue;
      }
      for (int j = nums.length - 1; j > i; j--) {
        if (nums[j] <= cur) {
          continue;
        }

        swith(nums, i, j);
        reversal(nums, i + 1, nums.length - 1);
        return;
      }

    }
    reversal(nums, 0, nums.length - 1);

  }

  private void swith(int[] nums, int first, int second) {
    if (first == second) {
      return;
    }
    nums[first] = nums[first] ^ nums[second];
    nums[second] = nums[first] ^ nums[second];
    nums[first] = nums[first] ^ nums[second];
  }

  private void reversal(int[] nums, int begin, int end) {

    for (int i = 0; i <= (end - begin) / 2; i++) {
      swith(nums, begin + i, end - i);
    }
  }
}
