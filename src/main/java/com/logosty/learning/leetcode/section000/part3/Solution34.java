package com.logosty.learning.leetcode.section000.part3;

import java.util.Arrays;

/**
 * @author logosty(ganyingle) on 2020/12/1 10:22
 * 34. 在排序数组中查找元素的第一个和最后一个位置 中等
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 *
 * 如果数组中不存在目标值 target，返回 [-1, -1]。
 *
 * 进阶：
 *
 * 你可以设计并实现时间复杂度为 O(log n) 的算法解决此问题吗？
 *
 *
 * 示例 1：
 *
 * 输入：nums = [5,7,7,8,8,10], target = 8
 * 输出：[3,4]
 * 示例 2：
 *
 * 输入：nums = [5,7,7,8,8,10], target = 6
 * 输出：[-1,-1]
 * 示例 3：
 *
 * 输入：nums = [], target = 0
 * 输出：[-1,-1]
 *
 *
 * 提示：
 *
 * 0 <= nums.length <= 105
 * -109 <= nums[i] <= 109
 * nums 是一个非递减数组
 * -109 <= target <= 109
 */
public class Solution34 {

  public static void main(String[] args) {
    int[] ints = {5, 7, 7, 8, 8, 10};
    System.out.println(Arrays.toString(new Solution34().searchRange(ints, 8)));
  }

  /**
   * 执行用时：
   * 0 ms
   * , 在所有 Java 提交中击败了
   * 100.00%
   * 的用户
   * 内存消耗：
   * 41.4 MB
   * , 在所有 Java 提交中击败了
   * 94.21%
   * 的用户
   */
  public int[] searchRange(int[] nums, int target) {
    int[] res = new int[2];
    res[0] = -1;
    res[1] = -1;
    if (nums.length == 0) {
      return res;
    }

    int index = find(nums, target, 0, nums.length - 1);
    if (index < 0) {
      return res;
    }

    for (int i = index; i >= 0; i--) {
      if (nums[i] != target) {
        break;
      }
      res[0] = i;
    }

    for (int i = index; i < nums.length; i++) {
      if (nums[i] != target) {
        break;
      }
      res[1] = i;
    }

    return res;
  }

  private int find(int[] nums, int target, int begin, int end) {
    if (begin + 1 >= end) {
      if (nums[begin] == target) {
        return begin;
      }
      if (nums[end] == target) {
        return end;
      }
      return -1;
    }

    int middle = (begin + end) / 2;
    if (nums[middle] == target) {
      return middle;
    }
    if (nums[middle] > target) {
      return find(nums, target, begin, middle - 1);
    } else {
      return find(nums, target, middle + 1, end);
    }
  }


  /**
   * 执行用时：
   * 1 ms
   * , 在所有 Java 提交中击败了
   * 15.15%
   * 的用户
   * 内存消耗：
   * 41.9 MB
   * , 在所有 Java 提交中击败了
   * 51.05%
   * 的用户
   */
  public int[] searchRange1(int[] nums, int target) {
    int[] res = new int[2];
    res[0] = -1;
    res[1] = -1;

    for (int i = 0; i < nums.length; i++) {
      if (nums[i] != target) {
        if (res[1] >= 0) {
          return res;
        }
        continue;
      }

      res[1] = i;
      if (res[0] < 0) {
        res[0] = i;
      }
    }
    return res;
  }
}
