package com.logosty.learning.leetcode.section800.part86;

/**
 * @author logosty(ganyingle) on 2020/12/7 11:21
 * 861. 翻转矩阵后的得分 中等
 * 有一个二维矩阵 A 其中每个元素的值为 0 或 1 。
 *
 * 移动是指选择任一行或列，并转换该行或列中的每一个值：将所有 0 都更改为 1，将所有 1 都更改为 0。
 *
 * 在做出任意次数的移动后，将该矩阵的每一行都按照二进制数来解释，矩阵的得分就是这些数字的总和。
 *
 * 返回尽可能高的分数。
 *
 *
 *
 * 示例：
 *
 * 输入：[[0,0,1,1],[1,0,1,0],[1,1,0,0]]
 * 输出：39
 * 解释：
 * 转换为 [[1,1,1,1],[1,0,0,1],[1,1,1,1]]
 * 0b1111 + 0b1001 + 0b1111 = 15 + 9 + 15 = 39
 *
 *
 * 提示：
 *
 * 1 <= A.length <= 20
 * 1 <= A[0].length <= 20
 * A[i][j] 是 0 或 1
 */
public class Solution861 {


    /**
     * 执行用时：
     * 1 ms
     * , 在所有 Java 提交中击败了
     * 29.27%
     * 的用户
     * 内存消耗：
     * 36.2 MB
     * , 在所有 Java 提交中击败了
     * 72.03%
     * 的用户
     */
  public int matrixScore1(int[][] A) {
    for (int i = 0; i < A.length; i++) {
      if (A[i][0] == 0) {
        reversal(A[i]);
      }
    }
    for (int i = 0; i < A[0].length; i++) {
      int count = 0;
      for (int[] ints : A) {
        if (ints[i] == 0) {
          count++;
          if (count > A.length / 2) {
            break;
          }
        }
      }
      if (count > A.length / 2) {
        reversal(A, i);
      }
    }

    int res = 0;
    for (int j = 0; j < A[0].length; j++) {
      int count = 0;
      for (int i = 0; i < A.length; i++) {
        if (A[i][j] == 1) {
          count++;
        }
      }
      res = res * 2 + count;
    }
    return res;
  }

  private void reversal(int[] ints) {
    for (int i = 0; i < ints.length; i++) {
      ints[i] ^= 1;
    }
  }

  private void reversal(int[][] ints, int index) {
    for (int i = 0; i < ints.length; i++) {
      ints[i][index] ^= 1;
    }
  }

  public static void main(String[] args) {
    int[][] ints = {{0,0,1,1},{1,0,1,0},{1,1,0,0}};
    System.out.println(new Solution861().matrixScore(ints));
  }
}
