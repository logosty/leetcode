package com.logosty.learning.leetcode.section000.part1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author logosty(ganyingle) on 2020/8/26 15:43
 * 17. 电话号码的字母组合 中等
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
 *
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 *
 *
 *
 * 示例:
 *
 * 输入："23"
 * 输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 * 说明:
 * 尽管上面的答案是按字典序排列的，但是你可以任意选择答案输出的顺序。
 */
public class Solution17 {

  List<String> res = new ArrayList<>();
  String[] map = {"", "", "abc", "edf", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

  /**
   * 执行结果：
   * 通过
   * 显示详情
   * 执行用时：
   * 1 ms
   * , 在所有 Java 提交中击败了
   * 87.39%
   * 的用户
   * 内存消耗：
   * 36.9 MB
   * , 在所有 Java 提交中击败了
   * 99.76%
   * 的用户
   */
  public List<String> letterCombinations(String digits) {
    if (digits.length() == 0) {
      return new ArrayList<>();
    }

    StringBuilder sb = new StringBuilder();
    fun(sb, digits, 0);
    return res;
  }

  public void fun(StringBuilder sb, String digits, int index) {
    char c = digits.charAt(index);
    String s = map[c - '0'];

    for (char cc : s.toCharArray()) {
      sb.append(cc);
      if (index == digits.length() - 1) {
        res.add(sb.toString());
      } else {
        fun(sb, digits, index + 1);
      }
      sb.deleteCharAt(sb.length() - 1);
    }

  }

  public static void main(String[] args) {
    System.out.println(new Solution17().letterCombinations("23"));
  }
}
