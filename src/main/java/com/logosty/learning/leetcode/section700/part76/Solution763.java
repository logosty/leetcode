package com.logosty.learning.leetcode.section700.part76;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

/**
 * @author logosty(ganyingle) on 2020/10/22 10:14
 * 763. 划分字母区间 中等
 * 字符串 S 由小写字母组成。我们要把这个字符串划分为尽可能多的片段，同一个字母只会出现在其中的一个片段。返回一个表示每个字符串片段的长度的列表。
 *
 *
 *
 * 示例 1：
 *
 * 输入：S = "ababcbacadefegdehijhklij"
 * 输出：[9,7,8]
 * 解释：
 * 划分结果为 "ababcbaca", "defegde", "hijhklij"。
 * 每个字母最多出现在一个片段中。
 * 像 "ababcbacadefegde", "hijhklij" 的划分是错误的，因为划分的片段数较少。
 *
 *
 * 提示：
 *
 * S的长度在[1, 500]之间。
 * S只包含小写字母 'a' 到 'z' 。
 */

/**
 * 执行用时：
 * 12 ms
 * , 在所有 Java 提交中击败了
 * 20.16%
 * 的用户
 * 内存消耗：
 * 38.8 MB
 * , 在所有 Java 提交中击败了
 * 23.18%
 * 的用户
 */
public class Solution763 {

  public List<Integer> partitionLabels(String S) {
    int[] cache = new int[26];
    ArrayDeque<Integer> deque = new ArrayDeque<>();

    for (int i = 0; i < S.length(); i++) {
      char c = S.charAt(i);
      int firstIndex = cache[c - 'a'];
      if (firstIndex == 0) {
        cache[c - 'a'] = i + 1;
        deque.push(i);
        continue;
      }

      while (!deque.isEmpty()) {
        Integer pop = deque.pop();
        if (pop < firstIndex - 1) {
          deque.push(pop);
          break;
        }
      }
      deque.push(i);
    }
    List<Integer> res = new ArrayList<>();
    int last = -1;
    while (!deque.isEmpty()) {
      Integer pop = deque.pollLast();
      res.add(pop - last);
      last = pop;
    }

    return res;
  }

  public static void main(String[] args) {
    String s = "ababcbacadefegdehijhklij";
    System.out.println(s.length());

    System.out.println(new Solution763().partitionLabels(s));
  }
}
