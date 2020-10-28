package com.logosty.learning.leetcode.section1200.part120;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * @author logosty(ganyingle) on 2020/10/28 10:14
 * 1207. 独一无二的出现次数 简单
 * 给你一个整数数组 arr，请你帮忙统计数组中每个数的出现次数。
 *
 * 如果每个数的出现次数都是独一无二的，就返回 true；否则返回 false。
 *
 *
 *
 * 示例 1：
 *
 * 输入：arr = [1,2,2,1,1,3]
 * 输出：true
 * 解释：在该数组中，1 出现了 3 次，2 出现了 2 次，3 只出现了 1 次。没有两个数的出现次数相同。
 * 示例 2：
 *
 * 输入：arr = [1,2]
 * 输出：false
 * 示例 3：
 *
 * 输入：arr = [-3,0,1,-3,1,1,1,-3,10,0]
 * 输出：true
 *
 *
 * 提示：
 *
 * 1 <= arr.length <= 1000
 * -1000 <= arr[i] <= 1000
 */

/**
 * 执行用时：
 * 2 ms
 * , 在所有 Java 提交中击败了
 * 91.43%
 * 的用户
 * 内存消耗：
 * 36.5 MB
 * , 在所有 Java 提交中击败了
 * 88.06%
 * 的用户
 */
public class Solution1207 {
  public boolean uniqueOccurrences(int[] arr) {
    HashMap<Integer, Integer> cache = new HashMap<>();

    for (int i : arr) {
      cache.put(i, cache.getOrDefault(i, 0)+1);
    }

    Set<Integer> set = new HashSet<>();
    for (int i : cache.values()) {
      if (i == 0) {
        continue;
      }
      if (!set.add(i)) {
        return false;
      }
    }
    return true;
  }

  public static void main(String[] args) {
    int[] ints = {1, 2, 2, 1, 1, 3};
    System.out.println(new Solution1207().uniqueOccurrences(ints));
  }
}
