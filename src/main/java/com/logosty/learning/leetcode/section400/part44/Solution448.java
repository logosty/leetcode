package com.logosty.learning.leetcode.section400.part44;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author logosty(ganyingle) on 2020/11/13 16:17
 * 448. 找到所有数组中消失的数字 简单
 * 给定一个范围在  1 ≤ a[i] ≤ n ( n = 数组大小 ) 的 整型数组，数组中的元素一些出现了两次，另一些只出现一次。
 *
 * 找到所有在 [1, n] 范围之间没有出现在数组中的数字。
 *
 * 您能在不使用额外空间且时间复杂度为O(n)的情况下完成这个任务吗? 你可以假定返回的数组不算在额外空间内。
 *
 * 示例:
 *
 * 输入:
 * [4,3,2,7,8,2,3,1]
 *
 * 输出:
 * [5,6]
 */
public class Solution448 {

  public static void main(String[] args) {
    System.out.println(new Solution448().findDisappearedNumbers(new int[]{4, 3, 2, 7, 8, 2, 3, 1}));
  }

  /**
   * 执行用时：
   * 11 ms
   * , 在所有 Java 提交中击败了
   * 24.24%
   * 的用户
   * 内存消耗：
   * 47.3 MB
   * , 在所有 Java 提交中击败了
   * 73.74%
   * 的用户
   * @param nums
   * @return
   */
  public List<Integer> findDisappearedNumbers1(int[] nums) {
    List<Integer> res = new ArrayList<>();
    for (int num : nums) {
      res.add(num);
    }
    Arrays.fill(nums, 0);
    for (Integer integer : res) {
      nums[integer - 1] = 1;
    }
    res.clear();
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] == 0) {
        res.add(i + 1);
      }
    }

    return res;
  }

  /**
   * 执行用时：
   * 6 ms
   * , 在所有 Java 提交中击败了
   * 89.63%
   * 的用户
   * 内存消耗：
   * 47.5 MB
   * , 在所有 Java 提交中击败了
   * 62.39%
   * 的用户
   */
  public List<Integer> findDisappearedNumbers(int[] nums) {
    List<Integer> res = new ArrayList<>();
    for (int num : nums) {
      int index = Math.abs(num) - 1;
      if (nums[index] > 0) {
        nums[index] = -nums[index];
      }
    }
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] >= 0) {
        res.add(i + 1);
      }
    }

    return res;
  }
}
