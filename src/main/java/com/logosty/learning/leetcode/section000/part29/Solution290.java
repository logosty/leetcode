package com.logosty.learning.leetcode.section000.part29;

import java.util.HashMap;
import java.util.Map;

/**
 * @author logosty(ganyingle) on 2020/12/16 10:09
 * 290. 单词规律 简单
 * 给定一种规律 pattern 和一个字符串 str ，判断 str 是否遵循相同的规律。
 *
 * 这里的 遵循 指完全匹配，例如， pattern 里的每个字母和字符串 str 中的每个非空单词之间存在着双向连接的对应规律。
 *
 * 示例1:
 *
 * 输入: pattern = "abba", str = "dog cat cat dog"
 * 输出: true
 * 示例 2:
 *
 * 输入:pattern = "abba", str = "dog cat cat fish"
 * 输出: false
 * 示例 3:
 *
 * 输入: pattern = "aaaa", str = "dog cat cat dog"
 * 输出: false
 * 示例 4:
 *
 * 输入: pattern = "abba", str = "dog dog dog dog"
 * 输出: false
 * 说明:
 * 你可以假设 pattern 只包含小写字母， str 包含了由单个空格分隔的小写字母。
 */
public class Solution290 {

  public static void main(String[] args) {
    System.out.println(new Solution290().wordPattern("abba", "hha heh heh hha"));
    System.out.println(new Solution290().wordPattern("abba", "hha hha hha hha"));
    System.out.println(new Solution290().wordPattern("abba", "dog cat cat fish"));
    System.out.println(new Solution290().wordPattern("aaa", "aa aa aa aa"));
    System.out.println(new Solution290().wordPattern("aaa", "aa"));



  }

  /**
   * 执行用时：
   * 1 ms
   * , 在所有 Java 提交中击败了
   * 98.94%
   * 的用户
   * 内存消耗：
   * 36.5 MB
   * , 在所有 Java 提交中击败了
   * 71.83%
   * 的用户
   */
  public boolean wordPattern(String pattern, String s) {
    Map<String, Character> cache = new HashMap<>();
    Map<Character, String> cache2 = new HashMap<>();

    int offset = 0;
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < pattern.length(); i++) {
      while (true) {
        if (offset >= s.length() || s.charAt(offset) == ' ') {
          offset++;
          break;
        }
        sb.append(s.charAt(offset));
        offset++;
      }
      if (sb.length() == 0) {
        return false;
      }

      String s2 = sb.toString();
      sb = new StringBuilder();
      Character character = cache.get(s2);
      char c = pattern.charAt(i);
      if (character != null && character != c) {
        return false;
      }
      cache.put(s2, c);

      String s1 = cache2.get(c);
      if (s1 != null && !s1.equals(s2)) {
        return false;
      }
      cache2.put(c, s2);

    }
    return offset >= s.length();
  }
}
