package com.logosty.learning.leetcode.section000.part0;

/**
 * Created with IDEA by logosty
 * Date:2018/11/10 Time:14:12
 *
 * 4. 寻找两个正序数组的中位数 困难
 * 给定两个大小为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的中位数。
 *
 * 进阶：你能设计一个时间复杂度为 O(log (m+n)) 的算法解决此问题吗？
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums1 = [1,3], nums2 = [2]
 * 输出：2.00000
 * 解释：合并数组 = [1,2,3] ，中位数 2
 * 示例 2：
 *
 * 输入：nums1 = [1,2], nums2 = [3,4]
 * 输出：2.50000
 * 解释：合并数组 = [1,2,3,4] ，中位数 (2 + 3) / 2 = 2.5
 * 示例 3：
 *
 * 输入：nums1 = [0,0], nums2 = [0,0]
 * 输出：0.00000
 * 示例 4：
 *
 * 输入：nums1 = [], nums2 = [1]
 * 输出：1.00000
 * 示例 5：
 *
 * 输入：nums1 = [2], nums2 = []
 * 输出：2.00000
 *
 *
 * 提示：
 *
 * nums1.length == m
 * nums2.length == n
 * 0 <= m <= 1000
 * 0 <= n <= 1000
 * 1 <= m + n <= 2000
 * -106 <= nums1[i], nums2[i] <= 106
 */
public class Solution4 {

  public static void main(String[] args) {
    System.out.println(new Solution4().findMedianSortedArrays(new int[]{1, 2}, new int[]{3, 4}));
  }

  /**
   * 执行用时：
   * 3 ms
   * , 在所有 Java 提交中击败了
   * 82.51%
   * 的用户
   * 内存消耗：
   * 39.9 MB
   * , 在所有 Java 提交中击败了
   * 20.97%
   * 的用户
   */
  public double findMedianSortedArrays(int[] nums1, int[] nums2) {
    int res = 0;
    int totalLength = nums1.length + nums2.length;
    int second = totalLength / 2;
    int first = (totalLength & 1) == 1 ? second : second - 1;

    int curOffset = 0;

    int index1 = 0;
    int index2 = 0;
    while (index1 < nums1.length || index2 < nums2.length) {
      int num = 0;
      if (index1 < nums1.length && index2 < nums2.length) {
        if (nums1[index1] <= nums2[index2]) {
          num = nums1[index1];
          index1++;
        } else {
          num = nums2[index2];
          index2++;
        }
      } else if (index1 < nums1.length) {
        num = nums1[index1];
        index1++;
      } else {
        num = nums2[index2];
        index2++;
      }

      if (curOffset == first) {
        res = num;
      }
      if (curOffset == second) {
        return (res + num) / 2.0;
      }
      curOffset++;
    }
    return -1;
  }


}
