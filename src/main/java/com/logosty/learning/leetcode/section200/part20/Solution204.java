package com.logosty.learning.leetcode.section200.part20;

/**
 * @author logosty(ganyingle) on 2020/12/3 10:30
 * 204. 计数质数 简单
 * 统计所有小于非负整数 n 的质数的数量。
 *
 *
 *
 * 示例 1：
 *
 * 输入：n = 10
 * 输出：4
 * 解释：小于 10 的质数一共有 4 个, 它们是 2, 3, 5, 7 。
 * 示例 2：
 *
 * 输入：n = 0
 * 输出：0
 * 示例 3：
 *
 * 输入：n = 1
 * 输出：0
 *
 *
 * 提示：
 *
 * 0 <= n <= 5 * 10^6
 */
public class Solution204 {

  public static void main(String[] args) {
    System.out.println(new Solution204().countPrimes(499979));
  }

  /**
   * 执行用时：
   * 19 ms
   * , 在所有 Java 提交中击败了
   * 49.28%
   * 的用户
   * 内存消耗：
   * 37.1 MB
   * , 在所有 Java 提交中击败了
   * 59.28%
   * 的用户
   */
  public int countPrimes(int n) {
    boolean[] isComposite = new boolean[n + 1];
    int res = 0;
    if (n <= 2) {
      return 0;
    }
    for (int i = 2; i < n; i++) {
      if (isComposite[i]) {
        continue;
      }

      res++;
      if ((long) i * i > n) {
        continue;
      }
      for (int j = i * i; j < n; j = j + i) {
        isComposite[j] = true;
      }

    }
    return res;

  }

  /**
   * 超时
   */
  public int countPrimes1(int n) {
    int res = 0;
    if (n <= 2) {
      return 0;
    }
    for (int i = 2; i < n; i++) {
      boolean flag = true;
      for (int j = 2; j * j <= i; j++) {
        if (i % j == 0) {
          flag = false;
          break;
        }
      }
      if (flag) {
        res++;
      }
    }
    return res;

  }
}
