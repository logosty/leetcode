package com.logosty.learning.leetcode.section300.part30;

/**
 * @author logosty(ganyingle) on 2020/10/23 19:21
 * 303. 区域和检索 - 数组不可变 简单
 * 给定一个整数数组  nums，求出数组从索引 i 到 j（i ≤ j）范围内元素的总和，包含 i、j 两点。
 *
 * 实现 NumArray 类：
 *
 * NumArray(int[] nums) 使用数组 nums 初始化对象
 * int sumRange(int i, int j) 返回数组 nums 从索引 i 到 j（i ≤ j）范围内元素的总和，包含 i、j 两点（也就是 sum(nums[i], nums[i + 1], ... , nums[j])）
 *
 *
 * 示例：
 *
 * 输入：
 * ["NumArray", "sumRange", "sumRange", "sumRange"]
 * [[[-2, 0, 3, -5, 2, -1]], [0, 2], [2, 5], [0, 5]]
 * 输出：
 * [null, 1, -1, -3]
 *
 * 解释：
 * NumArray numArray = new NumArray([-2, 0, 3, -5, 2, -1]);
 * numArray.sumRange(0, 2); // return 1 ((-2) + 0 + 3)
 * numArray.sumRange(2, 5); // return -1 (3 + (-5) + 2 + (-1))
 * numArray.sumRange(0, 5); // return -3 ((-2) + 0 + 3 + (-5) + 2 + (-1))
 *
 *
 * 提示：
 *
 * 0 <= nums.length <= 104
 * -105 <= nums[i] <= 105
 * 0 <= i <= j < nums.length
 * 最多调用 104 次 sumRange 方法
 */
public class Solution303 {

  class NumArray {
    int[] cache;

    public NumArray(int[] nums) {
      if (nums == null || nums.length == 0) {
        return;
      }
      cache = new int[nums.length];
      cache[0] = nums[0];
      for (int i = 1; i < nums.length; i++) {
        cache[i] = nums[i] + cache[i - 1];
      }
    }

    public int sumRange(int i, int j) {
      if (cache == null) {
        return 0;
      }

      if (i == 0) {
        return cache[j];
      }
      return cache[j] - cache[i - 1];

    }
  }
}
