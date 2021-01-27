package com.logosty.learning.leetcode.section900.part98;

import java.util.LinkedList;
import java.util.List;

/**
 * @author logosty(ganyingle) on 2021/1/27 11:35
 * 989. 数组形式的整数加法 简单
 * 对于非负整数 X 而言，X 的数组形式是每位数字按从左到右的顺序形成的数组。例如，如果 X = 1231，那么其数组形式为 [1,2,3,1]。
 *
 * 给定非负整数 X 的数组形式 A，返回整数 X+K 的数组形式。
 *
 *
 *
 * 示例 1：
 *
 * 输入：A = [1,2,0,0], K = 34
 * 输出：[1,2,3,4]
 * 解释：1200 + 34 = 1234
 * 示例 2：
 *
 * 输入：A = [2,7,4], K = 181
 * 输出：[4,5,5]
 * 解释：274 + 181 = 455
 * 示例 3：
 *
 * 输入：A = [2,1,5], K = 806
 * 输出：[1,0,2,1]
 * 解释：215 + 806 = 1021
 * 示例 4：
 *
 * 输入：A = [9,9,9,9,9,9,9,9,9,9], K = 1
 * 输出：[1,0,0,0,0,0,0,0,0,0,0]
 * 解释：9999999999 + 1 = 10000000000
 *
 *
 * 提示：
 *
 * 1 <= A.length <= 10000
 * 0 <= A[i] <= 9
 * 0 <= K <= 10000
 * 如果 A.length > 1，那么 A[0] != 0
 */
public class Solution989 {

  /**
   * 执行用时：
   * 4 ms
   * , 在所有 Java 提交中击败了
   * 87.67%
   * 的用户
   * 内存消耗：
   * 40.6 MB
   * , 在所有 Java 提交中击败了
   * 21.32%
   * 的用户
   * @param A
   * @param K
   * @return
   */
  public List<Integer> addToArrayForm(int[] A, int K) {
    LinkedList<Integer> res = new LinkedList<>();
    int offset = A.length - 1;
    int last = 0;

    while (offset >= 0 || K != 0) {
      int a = K % 10;
      K /= 10;
      int b = offset >= 0 ? A[offset] : 0;
      offset--;

      res.addFirst((a + b + last) % 10);
      last = (a + b + last) / 10;
    }
    if (last != 0) {
      res.addFirst(last);
    }

    return res;
  }
}
