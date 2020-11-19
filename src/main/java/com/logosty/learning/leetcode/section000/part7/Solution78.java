package com.logosty.learning.leetcode.section000.part7;

import com.alibaba.fastjson.JSON;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author logosty(ganyingle) on 2020/11/13 17:45
 * 78. 子集 中等
 * 给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 *
 * 说明：解集不能包含重复的子集。
 *
 * 示例:
 *
 * 输入: nums = [1,2,3]
 * 输出:
 * [
 *   [3],
 *   [1],
 *   [2],
 *   [1,2,3],
 *   [1,3],
 *   [2,3],
 *   [1,2],
 *   []
 * ]
 */
public class Solution78 {

  List<List<Integer>> res = new ArrayList<>();


  /**
   * 回溯
   * 执行用时：
   * 5 ms
   * , 在所有 Java 提交中击败了
   * 6.66%
   * 的用户
   * 内存消耗：
   * 38.6 MB
   * , 在所有 Java 提交中击败了
   * 95.10%
   * 的用户
   */
  public List<List<Integer>> subsets1(int[] nums) {
    ArrayDeque<Integer> deque = new ArrayDeque<>(nums.length);
    for (int num : nums) {
      deque.add(num);
    }
    loop1(new HashSet<>(nums.length), deque);
    res.add(new ArrayList<>());
    return res;
  }

  private void loop1(Set<Integer> cur, Deque<Integer> candidate) {
    int size = candidate.size();
    if (size == 0) {
      return;
    }

    Set<Integer> cache = new HashSet<>();
    for (int i = 0; i < size; i++) {
      Integer first = candidate.pollFirst();
      cache.add(first);

      cur.add(first);
      res.add(List.copyOf(cur));
      loop1(cur, candidate);
      cur.remove(first);
    }
    candidate.addAll(cache);
  }


  /**
   * 动态规划
   * 执行用时：
   * 2 ms
   * , 在所有 Java 提交中击败了
   * 24.08%
   * 的用户
   * 内存消耗：
   * 38.7 MB
   * , 在所有 Java 提交中击败了
   * 92.15%
   * 的用户
   */
  public List<List<Integer>> subsets(int[] nums) {
    List<List<Integer>> res = new ArrayList<>();
    res.add(new ArrayList<>());

    for (int num : nums) {
      int size = res.size();
      for (int i = 0; i < size; i++) {
        List<Integer> list1 = new ArrayList<>(List.copyOf(res.get(i)));
        list1.add(num);
        res.add(list1);
      }
    }
    return res;
  }

  public static void main(String[] args) {
    System.out.println(JSON.toJSONString(new Solution78().subsets(new int[]{1, 2, 3})));
  }
}
