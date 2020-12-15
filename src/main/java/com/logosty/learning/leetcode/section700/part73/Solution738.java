package com.logosty.learning.leetcode.section700.part73;

/**
 * @author logosty(ganyingle) on 2020/12/15 10:42
 * 738. 单调递增的数字 中等
 * 给定一个非负整数 N，找出小于或等于 N 的最大的整数，同时这个整数需要满足其各个位数上的数字是单调递增。
 *
 * （当且仅当每个相邻位数上的数字 x 和 y 满足 x <= y 时，我们称这个整数是单调递增的。）
 *
 * 示例 1:
 *
 * 输入: N = 10
 * 输出: 9
 * 示例 2:
 *
 * 输入: N = 1234
 * 输出: 1234
 * 示例 3:
 *
 * 输入: N = 332
 * 输出: 299
 * 说明: N 是在 [0, 10^9] 范围内的一个整数。
 */
public class Solution738 {

  int res;
  char[] chars;

  /**
   * 执行用时：
   * 1 ms
   * , 在所有 Java 提交中击败了
   * 97.96%
   * 的用户
   * 内存消耗：
   * 35 MB
   * , 在所有 Java 提交中击败了
   * 97.43%
   * 的用户
   */
  public int monotoneIncreasingDigits(int N) {
    if (N < 10) {
      return N;
    }
    chars = String.valueOf(N).toCharArray();
    loop(-1, 0, 0);
    return res;
  }

  public boolean loop(int lastMax, int cur, int offset) {
    if (offset >= chars.length) {
      res = cur;
      return true;
    }
    int tmp = chars[offset] - '0';
    if (tmp >= lastMax) {
      boolean match = loop(tmp, cur * 10 + tmp, offset + 1);
      if (match) {
        return true;
      }
    }
    if (tmp - 1 >= lastMax) {
      cur = cur * 10 + (tmp - 1);

      for (int i = offset + 1; i < chars.length; i++) {
        cur = cur * 10 + 9;
      }
      res = cur;
      return true;
    }
    return false;
  }

  public static void main(String[] args) {
    System.out.println(new Solution738().monotoneIncreasingDigits(10));
  }

}
