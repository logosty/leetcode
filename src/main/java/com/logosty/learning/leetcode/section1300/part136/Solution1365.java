package com.logosty.learning.leetcode.section1300.part136;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author logosty(ganyingle) on 2020/10/28 10:31
 * 1365. 有多少小于当前数字的数字 简单
 * 给你一个数组 nums，对于其中每个元素 nums[i]，请你统计数组中比它小的所有数字的数目。
 *
 * 换而言之，对于每个 nums[i] 你必须计算出有效的 j 的数量，其中 j 满足 j != i 且 nums[j] < nums[i] 。
 *
 * 以数组形式返回答案。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [8,1,2,2,3]
 * 输出：[4,0,1,1,3]
 * 解释：
 * 对于 nums[0]=8 存在四个比它小的数字：（1，2，2 和 3）。
 * 对于 nums[1]=1 不存在比它小的数字。
 * 对于 nums[2]=2 存在一个比它小的数字：（1）。
 * 对于 nums[3]=2 存在一个比它小的数字：（1）。
 * 对于 nums[4]=3 存在三个比它小的数字：（1，2 和 2）。
 * 示例 2：
 *
 * 输入：nums = [6,5,4,8]
 * 输出：[2,1,0,3]
 * 示例 3：
 *
 * 输入：nums = [7,7,7,7]
 * 输出：[0,0,0,0]
 *
 *
 * 提示：
 *
 * 2 <= nums.length <= 500
 * 0 <= nums[i] <= 100
 */
public class Solution1365 {

  /**
   * 执行用时：
   * 8 ms
   * , 在所有 Java 提交中击败了
   * 62.99%
   * 的用户
   * 内存消耗：
   * 38.5 MB
   * , 在所有 Java 提交中击败了
   * 93.93%
   * 的用户
   */
  public int[] smallerNumbersThanCurrent(int[] nums) {
    Map<Integer, List<Integer>> cache = new HashMap<>();
    int[] res = new int[nums.length];

    for (int i = 0; i < nums.length; i++) {
      int num = nums[i];
      if (!cache.containsKey(num)) {
        cache.put(num, new ArrayList<>());
      }
      cache.get(num).add(i);
    }

    Arrays.sort(nums);
    for (int i = 0; i < nums.length; i++) {
      if (i > 0 && nums[i] == nums[i - 1]) {
        continue;
      }
      List<Integer> list = cache.get(nums[i]);
      int last = i;
      list.forEach(integer -> res[integer] = last);
    }
    return res;
  }

  /**
   * 执行用时：
   * 6 ms
   * , 在所有 Java 提交中击败了
   * 66.25%
   * 的用户
   * 内存消耗：
   * 38.4 MB
   * , 在所有 Java 提交中击败了
   * 95.80%
   * 的用户
   */
  public int[] smallerNumbersThanCurrent2(int[] nums) {
    int[] res = new int[nums.length];

    Map<Integer, List<Integer>> cache = new HashMap<>();
    int[] counts = new int[101];
    for (int i = 0; i < nums.length; i++) {
      int num = nums[i];
      if (!cache.containsKey(num)) {
        cache.put(num, new ArrayList<>());
      }
      cache.get(num).add(i);
      counts[num]++;
    }

    int last = 0;
    for (int i = 0; i < counts.length; i++) {
      if (counts[i] == 0) {
        continue;
      }

      List<Integer> list = cache.get(i);
      int fix = last;
      list.forEach(integer -> res[integer] = fix);

      last = counts[i] + last;
    }
    return res;
  }
}
