package com.logosty.learning.leetcode.section900.part91;

/**
 * @author logosty(ganyingle) on 2020/10/28 11:35
 * 915. 分割数组 中等
 * 给定一个数组 A，将其划分为两个不相交（没有公共元素）的连续子数组 left 和 right， 使得：
 *
 * left 中的每个元素都小于或等于 right 中的每个元素。
 * left 和 right 都是非空的。
 * left 要尽可能小。
 * 在完成这样的分组后返回 left 的长度。可以保证存在这样的划分方法。
 *
 *
 *
 * 示例 1：
 *
 * 输入：[5,0,3,8,6]
 * 输出：3
 * 解释：left = [5,0,3]，right = [8,6]
 * 示例 2：
 *
 * 输入：[1,1,1,0,6,12]
 * 输出：4
 * 解释：left = [1,1,1,0]，right = [6,12]
 *
 *
 * 提示：
 *
 * 2 <= A.length <= 30000
 * 0 <= A[i] <= 10^6
 * 可以保证至少有一种方法能够按题目所描述的那样对 A 进行划分。
 */
public class Solution915 {

  /**
   * 执行用时：
   * 4 ms
   * , 在所有 Java 提交中击败了
   * 19.37%
   * 的用户
   * 内存消耗：
   * 38.4 MB
   * , 在所有 Java 提交中击败了
   * 98.37%
   * 的用户
   */
  public int partitionDisjoint(int[] A) {
    int leftMax = A[0];
    int rightMax = -1;
    int offset = 0;

    for (int i = 1; i < A.length; i++) {
      int num = A[i];

      rightMax = Math.max(num, rightMax);

      if (leftMax > num) {
        offset = i;
        leftMax = Math.max(leftMax, rightMax);
        rightMax = -1;
      }
    }
    return offset + 1;
  }

  public static void main(String[] args) {
    int[] ints = {12, 75, 26, 38, 56, 59, 83, 55, 49, 52, 27, 48, 77, 21, 27, 79, 54, 15, 59, 22,
        34, 35, 81, 67, 2, 41, 40, 0, 73, 61, 75, 8, 86, 42, 49, 83, 43, 16, 2, 54, 26, 35, 15, 63,
        31, 24, 51, 86, 6, 35, 42, 37, 83, 51, 34, 21, 71, 57, 61, 76, 50, 1, 43, 32, 19, 13, 67,
        87, 3, 33, 38, 34, 34, 84, 38, 76, 52, 7, 27, 49, 2, 78, 56, 28, 70, 6, 64, 87, 100, 97, 99,
        97, 97, 100, 100, 100, 97, 89, 98, 100};
    System.out.println(new Solution915().partitionDisjoint(ints));
  }
}
