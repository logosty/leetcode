package com.logosty.learning.leetcode.section100.part13;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
 执行用时：
 2 ms
 , 在所有 Java 提交中击败了
 98.38%
 的用户
 内存消耗：
 38.5 MB
 , 在所有 Java 提交中击败了
 100.00%
 的用户
 */
public class Solution131 {

  List<List<String>> res = new ArrayList<>();

  public List<List<String>> partition(String s) {
    func(s, 0, new ArrayList<>());
    return res;
  }

  public void func(String s, int index, List<String> sb) {
    if (index >= s.length()) {
      List<String> list = new ArrayList<>(sb);
      res.add(list);
      return;
    }

    for (int i = 0; i + index < s.length(); i++) {

      if (!check(s, index, index + i)) {
        continue;
      }
      sb.add(s.substring(index, index + i + 1));
      func(s, index + i + 1, sb);
      sb.remove(sb.size() - 1);
    }
  }


  public boolean check(String str, int begin, int end) {
    if (begin == end) {
      return true;
    }
    for (int i = 0; i + begin <= (end + begin) / 2; i++) {
      if (str.charAt(begin + i) != str.charAt(end - i)) {
        return false;
      }
    }
    return true;
  }

  public static void main(String[] args) {
    System.out.println(new Solution131().partition("efe"));
  }
}
