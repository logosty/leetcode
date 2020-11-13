package com.logosty.learning.leetcode.section400.part46;

/**
 * @author logosty(ganyingle) on 2020/11/13 16:03
 * 461. 汉明距离 简单
 * 两个整数之间的汉明距离指的是这两个数字对应二进制位不同的位置的数目。
 *
 * 给出两个整数 x 和 y，计算它们之间的汉明距离。
 *
 * 注意：
 * 0 ≤ x, y < 2^31.
 *
 * 示例:
 *
 * 输入: x = 1, y = 4
 *
 * 输出: 2
 *
 * 解释:
 * 1   (0 0 0 1)
 * 4   (0 1 0 0)
 *        ↑   ↑
 *
 * 上面的箭头指出了对应二进制位不同的位置。
 */
public class Solution461 {

  /**
   * 执行用时：
   * 0 ms
   * , 在所有 Java 提交中击败了
   * 100.00%
   * 的用户
   * 内存消耗：
   * 35.1 MB
   * , 在所有 Java 提交中击败了
   * 92.22%
   * 的用户
   */
  public int hammingDistance(int x, int y) {
    int i = x ^ y;
    int res = 0;
    while (i != 0) {
      if ((i & 1) == 1) {
        res++;
      }
      i = (i >> 1);
    }
    return res;
  }

  public static void main(String[] args) {
    System.out.println(new Solution461().hammingDistance(1,4));
  }
}
