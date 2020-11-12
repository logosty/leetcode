package com.logosty.learning.leetcode.section900.part97;

/**
 * @author logosty(ganyingle) on 2020/11/12 16:43
 * 978. 最长湍流子数组 中等
 * 当 A 的子数组 A[i], A[i+1], ..., A[j] 满足下列条件时，我们称其为湍流子数组：
 *
 * 若 i <= k < j，当 k 为奇数时， A[k] > A[k+1]，且当 k 为偶数时，A[k] < A[k+1]；
 * 或 若 i <= k < j，当 k 为偶数时，A[k] > A[k+1] ，且当 k 为奇数时， A[k] < A[k+1]。
 * 也就是说，如果比较符号在子数组中的每个相邻元素对之间翻转，则该子数组是湍流子数组。
 *
 * 返回 A 的最大湍流子数组的长度。
 *
 *
 *
 * 示例 1：
 *
 * 输入：[9,4,2,10,7,8,8,1,9]
 * 输出：5
 * 解释：(A[1] > A[2] < A[3] > A[4] < A[5])
 * 示例 2：
 *
 * 输入：[4,8,12,16]
 * 输出：2
 * 示例 3：
 *
 * 输入：[100]
 * 输出：1
 *
 *
 * 提示：
 *
 * 1 <= A.length <= 40000
 * 0 <= A[i] <= 10^9
 */
public class Solution978 {

  /**
   * 执行用时：
   * 8 ms
   * , 在所有 Java 提交中击败了
   * 38.18%
   * 的用户
   * 内存消耗：
   * 42.1 MB
   * , 在所有 Java 提交中击败了
   * 76.13%
   * 的用户
   */
  public int maxTurbulenceSize1(int[] A) {
    int res = Integer.MIN_VALUE;
    if (A.length <= 1) {
      return 1;
    }

    Boolean up = null;
    int curLength = 1;

    for (int i = 1; i < A.length; i++) {
      if (A[i] == A[i - 1]) {
        up = null;
        res = Math.max(curLength, res);
        curLength = 1;
        continue;
      }
      if (up == null) {
        up = A[i] > A[i - 1];
        curLength++;
        continue;
      }
      if (A[i] > A[i - 1] == up) {
        res = Math.max(curLength, res);
        curLength = 2;
        continue;
      }

      up = !up;
      curLength++;
    }
    return Math.max(curLength, res);
  }

  /**
   * 执行用时：
   * 6 ms
   * , 在所有 Java 提交中击败了
   * 84.61%
   * 的用户
   * 内存消耗：
   * 44.5 MB
   * , 在所有 Java 提交中击败了
   * 29.38%
   * 的用户
   * @param A
   * @return
   */
  public int maxTurbulenceSize(int[] A) {
    int res = Integer.MIN_VALUE;
    if (A.length <= 1) {
      return 1;
    }


    boolean[] cache = new boolean[A.length];
    cache[0] = !(A[1] > A[0]);

    for (int i = 1; i < A.length; i++) {
      cache[i] = A[i] == A[i-1] ? cache[i - 1] : A[i] > A[i-1];
    }

    int curLength = 1;
    for (int i = 1; i < cache.length; i++) {
      if (cache[i] == cache[i - 1]) {
        res = Math.max(res, curLength);
        curLength = A[i] == A[i - 1] ? 1 : 2;
        continue;
      }
      curLength++;
    }
    return Math.max(curLength, res);
  }
  public static void main(String[] args) {
    int[] ints = {9,4,2,10,7,8,8,1,9};
    System.out.println(new Solution978().maxTurbulenceSize(ints));

  }
}
