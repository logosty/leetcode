package com.logosty.learning.leetcode.section600.part69;

/**
 * @author logosty(ganyingle) on 2020/8/10 15:00
 *
 * 696. 计数二进制子串 简单
 * 给定一个字符串 s，计算具有相同数量0和1的非空(连续)子字符串的数量，并且这些子字符串中的所有0和所有1都是组合在一起的。
 *
 * 重复出现的子串要计算它们出现的次数。
 *
 * 示例 1 :
 *
 * 输入: "00110011"
 * 输出: 6
 * 解释: 有6个子串具有相同数量的连续1和0：“0011”，“01”，“1100”，“10”，“0011” 和 “01”。
 *
 * 请注意，一些重复出现的子串要计算它们出现的次数。
 *
 * 另外，“00110011”不是有效的子串，因为所有的0（和1）没有组合在一起。
 * 示例 2 :
 *
 * 输入: "10101"
 * 输出: 4
 * 解释: 有4个子串：“10”，“01”，“10”，“01”，它们具有相同数量的连续1和0。
 * 注意：
 *
 * s.length 在1到50,000之间。
 * s 只包含“0”或“1”字符。
 */
public class Solution696 {

  public int countBinarySubstrings(String s) {
    if (s == null || s.length() < 2) {
      return 0;
    }
    int res = 0;
    char[] chars = s.toCharArray();
    int lastSame = 0;
    for (int i = 1; i < chars.length; i++) {
      if (chars[i] == chars[i - 1]) {
        lastSame++;
        continue;
      }
      int num = getNum(lastSame, chars, i);
      res += num;
      i += (num - 1);
      lastSame = num - 1;
    }
    return res;
  }

  public int getNum(int lastSame, char[] chars, int pos) {
    int num = 1;
    for (; num <= lastSame && pos + num <= chars.length - 1; num++) {
      if (chars[pos + num] != chars[pos]) {
        break;
      }
    }

    return num;
  }

  public static void main(String[] args) {
    String s = "00110";
    System.out.println(new Solution696().countBinarySubstrings(s));
  }
}
