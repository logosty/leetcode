package com.logosty.learning.leetcode.section300.part34;

import java.util.ArrayDeque;
import java.util.Set;

/**
 * @author logosty(ganyingle) on 2020/8/21 17:56
 * 345. 反转字符串中的元音字母 简单
 * 编写一个函数，以字符串作为输入，反转该字符串中的元音字母。
 *
 *
 *
 * 示例 1：
 *
 * 输入："hello"
 * 输出："holle"
 * 示例 2：
 *
 * 输入："leetcode"
 * 输出："leotcede"
 *
 *
 * 提示：
 *
 * 元音字母不包含字母 "y" 。
 */
public class Solution345 {
  public String reverseVowels(String s) {
    if(s.length()<=1) return s;
    char[] chars = s.toCharArray();
    Set<Character> set = Set.of('a', 'o','e','i','u','A','O','E','I','U');

    ArrayDeque<Integer> deque = new ArrayDeque<>();
    for (int i = 0; i < chars.length; i++) {
      if (set.contains(chars[i])) {
        deque.push(i);
      }
    }
    while (deque.size() > 1) {
      int begin = deque.removeFirst();
      int end = deque.removeLast();
      char tmp = chars[begin];
      chars[begin] = chars[end];
      chars[end] = tmp;
    }
    return String.valueOf(chars);
  }
}
