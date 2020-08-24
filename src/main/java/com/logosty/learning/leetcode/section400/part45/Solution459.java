package com.logosty.learning.leetcode.section400.part45;

import java.util.ArrayList;

/**
 * @author logosty(ganyingle) on 2020/8/24 19:56
 * 459. 重复的子字符串 简单
 * 给定一个非空的字符串，判断它是否可以由它的一个子串重复多次构成。给定的字符串只含有小写英文字母，并且长度不超过10000。
 *
 * 示例 1:
 *
 * 输入: "abab"
 *
 * 输出: True
 *
 * 解释: 可由子字符串 "ab" 重复两次构成。
 * 示例 2:
 *
 * 输入: "aba"
 *
 * 输出: False
 * 示例 3:
 *
 * 输入: "abcabcabcabc"
 *
 * 输出: True
 *
 * 解释: 可由子字符串 "abc" 重复四次构成。 (或者子字符串 "abcabc" 重复两次构成。)
 */
public class Solution459 {

  public boolean repeatedSubstringPattern(String s) {
    char[] chars = s.toCharArray();
    if (s.length() <= 1) {
      return false;
    }
    ArrayList<Integer> candidate = new ArrayList<>();
    candidate.add(0);
    for (int i = 1; i < s.length(); i++) {
      for (int j = candidate.size() - 1; j >= 0; j--) {
        if (chars[i % (candidate.get(j) + 1)] != chars[i]) {
          candidate.remove(j);
        }
      }
      if (i < s.length() / 2) {
        candidate.add(i);
      }
    }
    return candidate.size() > 0
        && candidate.stream().anyMatch(integer -> s.length() % (integer + 1) == 0);
  }

  public static void main(String[] args) {
    System.out.println(new Solution459().repeatedSubstringPattern("aabaab"));
  }
}
