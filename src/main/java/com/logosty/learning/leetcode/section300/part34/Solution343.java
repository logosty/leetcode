package com.logosty.learning.leetcode.section300.part34;

/**
 * @author logosty(ganyingle) on 2020/10/29 19:43
 * 343. 整数拆分 中等
 * 给定一个正整数 n，将其拆分为至少两个正整数的和，并使这些整数的乘积最大化。 返回你可以获得的最大乘积。
 *
 * 示例 1:
 *
 * 输入: 2
 * 输出: 1
 * 解释: 2 = 1 + 1, 1 × 1 = 1。
 * 示例 2:
 *
 * 输入: 10
 * 输出: 36
 * 解释: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36。
 * 说明: 你可以假设 n 不小于 2 且不大于 58。
 */
public class Solution343 {

  /**
   * 执行用时：
   * 0 ms
   * , 在所有 Java 提交中击败了
   * 100.00%
   * 的用户
   * 内存消耗：
   * 35.5 MB
   * , 在所有 Java 提交中击败了
   * 66.68%
   * 的用户
   */
  public int integerBreak(int n) {
    int[] cache = new int[n + 1];
    cache[1] = 1;

    if (n <= 3) {
      return n - 1;
    }

    cache[2] = 2;
    cache[3] = 3;

    for (int i = 4; i <= n; i++) {
      for (int j = 2; j <= i / 2; j++) {
        cache[i] = Math.max(cache[i], cache[j] * cache[i - j]);
      }
    }

    return cache[n];
  }

  public static void main(String[] args) {
    System.out.println(new Solution343().integerBreak(8));
  }
}
