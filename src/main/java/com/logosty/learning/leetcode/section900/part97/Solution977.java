package com.logosty.learning.leetcode.section900.part97;

/**
 * @author logosty(ganyingle) on 2020/10/16 10:35
 * 977. 有序数组的平方 简单
 * 给定一个按非递减顺序排序的整数数组 A，返回每个数字的平方组成的新数组，要求也按非递减顺序排序。
 *
 *
 *
 * 示例 1：
 *
 * 输入：[-4,-1,0,3,10]
 * 输出：[0,1,9,16,100]
 * 示例 2：
 *
 * 输入：[-7,-3,2,3,11]
 * 输出：[4,9,9,49,121]
 *
 *
 * 提示：
 *
 * 1 <= A.length <= 10000
 * -10000 <= A[i] <= 10000
 * A 已按非递减顺序排序。
 */
public class Solution977 {

  public int[] sortedSquares(int[] A) {
    if (A == null || A.length == 0) {
      return new int[0];
    }
    int[] res = new int[A.length];
    if (A.length == 1) {
      res[0] = A[0] * A[0];
      return res;
    }

    int centerIndex = 0;
    for (int i = 0; i < A.length; i++) {
      if (A[i] >= 0) {
        centerIndex = i;
        break;
      }
    }

    int left = centerIndex - 1;
    int right = centerIndex;
    int offset = 0;
    while (left >= 0 || right < A.length) {
      if (left < 0) {
        res[offset] = A[right] * A[right];
        offset++;
        right++;
        continue;
      }
      if (right >= A.length) {
        res[offset] = A[left] * A[left];
        offset++;
        left--;
        continue;
      }

      if (A[right] <= -A[left]) {
        res[offset] = A[right] * A[right];
        right++;
      } else {
        res[offset] = A[left] * A[left];
        left--;
      }
      offset++;
    }

    return res;
  }

  public static void main(String[] args) {
    int[] ints = {-4, -1, 0, 3, 10};

    System.out.println(new Solution977().sortedSquares(ints));
  }
}
