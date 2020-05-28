package com.logosty.learning.leetcode.section500.part52;

import com.logosty.learning.annotation.ToOptimization;
import java.util.HashMap;
import java.util.Map;

/**
 * @author logosty(ganyingle) on 2020/5/27 11:33
 * 523. 连续的子数组和 中等
 * 给定一个包含非负数的数组和一个目标整数 k，编写一个函数来判断该数组是否含有连续的子数组，其大小至少为 2，总和为 k 的倍数，即总和为 n*k，其中 n 也是一个整数。
 *
 * 示例 1:
 *
 * 输入: [23,2,4,6,7], k = 6
 * 输出: True
 * 解释: [2,4] 是一个大小为 2 的子数组，并且和为 6。
 * 示例 2:
 *
 * 输入: [23,2,6,4,7], k = 6
 * 输出: True
 * 解释: [23,2,6,4,7]是大小为 5 的子数组，并且和为 42。
 * 说明:
 *
 * 数组的长度不会超过10,000。
 * 你可以认为所有数字总和在 32 位有符号整数范围内。
 */
@ToOptimization
public class Solution523 {

  public boolean checkSubarraySum(int[] nums, int k) {

    if (nums.length <= 1) {
      return false;
    }

    int sum;
    for (int i = 0; i < nums.length - 1; i++) {
      sum = nums[i];
      for (int j = i + 1; j < nums.length; j++) {
        sum = sum + nums[j];
        if (k == 0) {
          if (sum == 0) {
            return true;
          } else {
            break;
          }
        }
        if (sum % k == 0) {
          return true;
        }
      }
    }

    return false;
  }

  /**
   * 前缀和如果出现取模一样的，说明这中间的和能被整除
   */
  public boolean checkSubarraySum2(int[] nums, int k) {
    if (nums.length <= 1) {
      return false;
    }

    int[] preSums = new int[nums.length];
    preSums[0] = nums[0];

    Map<Integer, Integer> cache = new HashMap<>(nums.length);
    if (k != 0) {
      cache.put(preSums[0] % k, 0);
    }

    for (int i = 1; i < nums.length; i++) {
      if (k == 0) {
        if (nums[i] == 0 && nums[i - 1] == 0) {
          return true;
        }
        continue;
      }

      preSums[i] = nums[i] + preSums[i - 1];
      if (cache.containsKey(preSums[i] % k) && i - cache.get(preSums[i] % k) > 1) {
        return true;
      }
      cache.put(preSums[i] % k, i);

    }

    return false;
  }

  public static void main(String[] args) {
    int[] nums = {23, 2, 6, 4, 7};
    int k = 0;
    System.out.println(new Solution523().checkSubarraySum(nums, k));
    System.out.println(new Solution523().checkSubarraySum2(nums, k));

  }
}
