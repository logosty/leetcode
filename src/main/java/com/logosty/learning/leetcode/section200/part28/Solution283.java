package com.logosty.learning.leetcode.section200.part28;

import com.alibaba.fastjson.JSON;

/**
 * @author logosty(ganyingle) on 2020/11/19 10:59
 * 283. 移动零 简单
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 *
 * 示例:
 *
 * 输入: [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 * 说明:
 *
 * 必须在原数组上操作，不能拷贝额外的数组。
 * 尽量减少操作次数。
 */
public class Solution283 {

  /**
   * 执行用时：
   * 0 ms
   * , 在所有 Java 提交中击败了
   * 100.00%
   * 的用户
   * 内存消耗：
   * 38.7 MB
   * , 在所有 Java 提交中击败了
   * 83.22%
   * 的用户
   */
  public void moveZeroes(int[] nums) {
    int fillIndex = 0;
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] == 0) {
        continue;
      }
      if (fillIndex == i) {
        fillIndex++;
        continue;
      }
      nums[fillIndex] = nums[i];
      nums[i] = 0;
      fillIndex++;
    }

  }

  public static void main(String[] args) {
    int[] ints = {1, 0, 2, 3, 4};
    new Solution283().moveZeroes(ints);
    System.out.println(JSON.toJSONString(ints));
  }
}
