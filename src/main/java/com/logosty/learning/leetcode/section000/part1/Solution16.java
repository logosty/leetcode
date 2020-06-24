package com.logosty.learning.leetcode.section000.part1;

import java.util.Arrays;

/**
 * Created with IDEA by logosty
 * Date:2019/1/25 Time:17:22
 * 16. 最接近的三数之和
 * 给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和。假定每组输入只存在唯一答案。
 *
 *
 * 示例：
 *
 * 输入：nums = [-1,2,1,-4], target = 1
 * 输出：2
 * 解释：与 target 最接近的和是 2 (-1 + 2 + 1 = 2) 。
 *
 *
 * 提示：
 *
 * 3 <= nums.length <= 10^3
 * -10^3 <= nums[i] <= 10^3
 * -10^4 <= target <= 10^4
 */
public class Solution16 {

  public int threeSumClosest(int[] nums, int target) {
    Arrays.sort(nums);
    int ret = Integer.MAX_VALUE;
    for (int i = 0; i < nums.length - 2; i++) {
      ret = find(nums, ret, target, i + 1);
      if (ret == 0) {
        return target;
      }
    }
    return ret + target;
  }

  public int find(int[] nums, int ret, int target, int start) {
    int exist = nums[start - 1];
    int end = nums.length - 1;
    int gap;
    while (true) {
      gap = nums[start] + nums[end] - target + exist;
      ret = Math.abs(ret) > Math.abs(gap) ? gap : ret;

      if (gap > 0) {
        end--;
      } else if (gap < 0) {
        start++;
      } else {
        return gap;
      }
      if (start == end) {
        return ret;
      }
    }
  }

  public static void main(String[] args) {
    int[] ints = {-1, 2, 1, -4};
    int target = 1;

    System.out.println(new Solution16().threeSumClosest(ints, target));

  }
}
