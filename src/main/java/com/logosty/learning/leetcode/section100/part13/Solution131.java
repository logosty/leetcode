package com.logosty.learning.leetcode.section100.part13;

import java.util.ArrayList;
import java.util.List;

/**
 * @author logosty(ganyingle) on 2020/10/19 20:40
 * 131. 分割回文串 中等
 * 给定一个字符串 s，将 s 分割成一些子串，使每个子串都是回文串。
 *
 * 返回 s 所有可能的分割方案。
 *
 * 示例:
 *
 * 输入: "aab"
 * 输出:
 * [
 *   ["aa","b"],
 *   ["a","a","b"]
 * ]
 */

/**
 * 执行用时：
 * 36 ms
 * , 在所有 Java 提交中击败了
 * 5.08%
 * 的用户
 * 内存消耗：
 * 40.1 MB
 * , 在所有 Java 提交中击败了
 * 8.99%
 * 的用户
 */
public class Solution131 {

  List<List<String>> res = new ArrayList<>();
  private final String SPLIT = ",";

  public List<List<String>> partition(String s) {
    StringBuilder sb = new StringBuilder();
    func(s, 0, sb);
    return res;
  }

  public void func(String s, int index, StringBuilder sb) {
    if (index >= s.length()) {
      res.add(split(sb));
      return;
    }

    for (int i = 0; i + index < s.length(); i++) {
      StringBuilder toBeSplit = new StringBuilder();
      for (int j = 0; j <= i; j++) {
        toBeSplit.append(s.charAt(index + j));
      }
      if (!check(toBeSplit)) {
        continue;
      }
      sb.append(toBeSplit);
      sb.append(SPLIT);
      func(s, index + i + 1, sb);
      sb.delete(sb.length() - 2 - i, sb.length());
    }
  }

  public List<String> split(StringBuilder sb) {
    StringBuilder cache = new StringBuilder();
    List<String> res = new ArrayList<>();

    for (int i = 0; i < sb.length(); i++) {
      if (SPLIT.equals(String.valueOf(sb.charAt(i)))) {
        res.add(cache.toString());
        cache.delete(0, cache.length());
        continue;
      }
      cache.append(sb.charAt(i));
    }
    return res;

  }

  public boolean check(StringBuilder sb) {
    if (sb.length() == 1) {
      return true;
    }
    for (int i = 0; i < sb.length() / 2; i++) {
      if (sb.charAt(i) != sb.charAt(sb.length() - 1 - i)) {
        return false;
      }
    }
    return true;
  }

  public static void main(String[] args) {
    System.out.println(new Solution131().partition("efe"));
  }
}
