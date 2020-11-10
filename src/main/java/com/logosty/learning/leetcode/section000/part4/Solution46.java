package com.logosty.learning.leetcode.section000.part4;

import com.alibaba.fastjson.JSON;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author logosty(ganyingle) on 2020/11/10 19:43
 * 46. 全排列 中等
 * 给定一个 没有重复 数字的序列，返回其所有可能的全排列。
 *
 * 示例:
 *
 * 输入: [1,2,3]
 * 输出:
 * [
 *   [1,2,3],
 *   [1,3,2],
 *   [2,1,3],
 *   [2,3,1],
 *   [3,1,2],
 *   [3,2,1]
 * ]
 */
public class Solution46 {

  private List<List<Integer>> res = new ArrayList<>();

  public static void main(String[] args) {
    int[] ints = {1, 2, 3};
    System.out.println(JSON.toJSONString(new Solution46().permute(ints)));
  }

  /**
   * 执行用时：
   * 2 ms
   * , 在所有 Java 提交中击败了
   * 79.33%
   * 的用户
   * 内存消耗：
   * 38.6 MB
   * , 在所有 Java 提交中击败了
   * 91.15%
   * 的用户
   * @param nums
   * @return
   */
  public List<List<Integer>> permute(int[] nums) {
    Deque<Integer> deque = new ArrayDeque<>(nums.length);

    for (int num : nums) {
      deque.push(num);
    }

    loop(new LinkedList<>(), deque);
    return res;
  }

  private void loop(List<Integer> cache, Deque<Integer> deque) {
    if (deque.isEmpty()) {
      res.add(List.copyOf(cache));
      return;
    }

    int size = deque.size();
    for (int i = 0; i < size; i++) {
      Integer first = deque.pollFirst();
      cache.add(first);

      loop(cache, deque);
      deque.add(first);
      cache.remove(first);
    }
  }




}
