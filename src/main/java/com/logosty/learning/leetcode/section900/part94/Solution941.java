package com.logosty.learning.leetcode.section900.part94;

/**
 * @author logosty(ganyingle) on 2020/11/3 10:16
 * 941. 有效的山脉数组 简单
 * 给定一个整数数组 A，如果它是有效的山脉数组就返回 true，否则返回 false。
 *
 * 让我们回顾一下，如果 A 满足下述条件，那么它是一个山脉数组：
 *
 * A.length >= 3
 * 在 0 < i < A.length - 1 条件下，存在 i 使得：
 * A[0] < A[1] < ... A[i-1] < A[i]
 * A[i] > A[i+1] > ... > A[A.length - 1]
 *
 *
 *
 *
 *
 *
 * 示例 1：
 *
 * 输入：[2,1]
 * 输出：false
 * 示例 2：
 *
 * 输入：[3,5,5]
 * 输出：false
 * 示例 3：
 *
 * 输入：[0,3,2,1]
 * 输出：true
 *
 *
 * 提示：
 *
 * 0 <= A.length <= 10000
 * 0 <= A[i] <= 10000
 */
public class Solution941 {

  /**
   * 执行结果：
   * 通过
   * 显示详情
   * 执行用时：
   * 2 ms
   * , 在所有 Java 提交中击败了
   * 41.65%
   * 的用户
   * 内存消耗：
   * 39.7 MB
   * , 在所有 Java 提交中击败了
   * 36.21%
   * 的用户
   */
  public boolean validMountainArray(int[] A) {
    if (A.length < 3 || A[1] < A[0]) {
      return false;
    }

    boolean decreasing = false;
    for (int i = 1; i < A.length; i++) {
      if (A[i] == A[i - 1]) {
        return false;
      }

      if (decreasing) {
        if (A[i] > A[i - 1]) {
          return false;
        }
      } else {
        if (A[i] < A[i - 1]) {
          decreasing = true;
        }
      }
    }
    return decreasing;
  }
}
