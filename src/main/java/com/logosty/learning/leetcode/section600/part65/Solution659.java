package com.logosty.learning.leetcode.section600.part65;

import java.util.HashMap;
import java.util.Map;
import lombok.extern.slf4j.Slf4j;

/**
 * @author logosty(ganyingle) on 2020/12/4 14:30
 * 659. 分割数组为连续子序列 中等
 * 给你一个按升序排序的整数数组 num（可能包含重复数字），请你将它们分割成一个或多个子序列，其中每个子序列都由连续整数组成且长度至少为 3 。
 *
 * 如果可以完成上述分割，则返回 true ；否则，返回 false 。
 *
 *
 *
 * 示例 1：
 *
 * 输入: [1,2,3,3,4,5]
 * 输出: True
 * 解释:
 * 你可以分割出这样两个连续子序列 :
 * 1, 2, 3
 * 3, 4, 5
 *
 *
 * 示例 2：
 *
 * 输入: [1,2,3,3,4,4,5,5]
 * 输出: True
 * 解释:
 * 你可以分割出这样两个连续子序列 :
 * 1, 2, 3, 4, 5
 * 3, 4, 5
 *
 *
 * 示例 3：
 *
 * 输入: [1,2,3,4,4,5]
 * 输出: False
 *
 *
 * 提示：
 *
 * 输入的数组长度范围为 [1, 10000]
 */
@Slf4j
public class Solution659 {

  public static void main(String[] args) {
    int[] ints = {1, 2, 3, 4, 4, 5};
    System.out.println(new Solution659().isPossible(ints));
  }

  /**
   * 执行用时：
   * 34 ms
   * , 在所有 Java 提交中击败了
   * 48.15%
   * 的用户
   * 内存消耗：
   * 40.5 MB
   * , 在所有 Java 提交中击败了
   * 13.61%
   * 的用户
   */
  public boolean isPossible(int[] nums) {
    Map<Integer, Integer> numCount = new HashMap<>();
    Map<Integer, Integer> listCount = new HashMap<>();

    for (int num : nums) {
      numCount.put(num, numCount.getOrDefault(num, 0) + 1);
    }

    for (int num : nums) {
      if (numCount.getOrDefault(num, 0) <= 0) {
        continue;
      }

      if (listCount.getOrDefault(num - 1, 0) > 0) {
        listCount.put(num - 1, listCount.getOrDefault(num - 1, 0) - 1);
        listCount.put(num, listCount.getOrDefault(num, 0) + 1);
        numCount.put(num, numCount.getOrDefault(num, 0) - 1);
        continue;
      }

      if (numCount.getOrDefault(num + 1, 0) <= 0 || numCount.getOrDefault(num + 2, 0) <= 0) {
        return false;
      }

      numCount.put(num, numCount.getOrDefault(num, 0) - 1);
      numCount.put(num + 1, numCount.getOrDefault(num + 1, 0) - 1);
      numCount.put(num + 2, numCount.getOrDefault(num + 2, 0) - 1);
      listCount.put(num + 2, listCount.getOrDefault(num + 2, 0) + 1);
    }
    return true;
  }


}
