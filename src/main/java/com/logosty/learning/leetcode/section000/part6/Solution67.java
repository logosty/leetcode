package com.logosty.learning.leetcode.section000.part6;

/**
 * @author logosty(ganyingle) on 2020/6/23 11:43
 * 67. 二进制求和 简单
 * 给你两个二进制字符串，返回它们的和（用二进制表示）。
 *
 * 输入为 非空 字符串且只包含数字 1 和 0。
 *
 *
 *
 * 示例 1:
 *
 * 输入: a = "11", b = "1"
 * 输出: "100"
 * 示例 2:
 *
 * 输入: a = "1010", b = "1011"
 * 输出: "10101"
 *
 *
 * 提示：
 *
 * 每个字符串仅由字符 '0' 或 '1' 组成。
 * 1 <= a.length, b.length <= 10^4
 * 字符串如果不是 "0" ，就都不含前导零。
 */
public class Solution67 {

  public String addBinary(String a, String b) {
    char char0 = '0';
    char[] charsA = a.toCharArray();
    char[] charsB = b.toCharArray();
    int lengthA = charsA.length;
    int lengthB = charsB.length;
    char[] chars = new char[Math.max(lengthA, lengthB)];

    int last = 0;
    for (int i = 0; i < Math.max(lengthA, lengthB); i++) {

      char aa = i < lengthA ? charsA[lengthA - 1 - i] : char0;
      char bb = i < lengthB ? charsB[lengthB - 1 - i] : char0;

      int offset = aa + bb + last - 2 * char0;
      last = offset / 2;
      chars[Math.max(lengthA, lengthB) - i - 1] = offset % 2 == 0 ? '0' : '1';
    }
    String s = String.valueOf(chars);
    if (last > 0) {
      s = last + s;
    }
    return s;
  }

  public static void main(String[] args) {
    String s = "1010";
    String s1 = "1011";
    System.out.println(new Solution67().addBinary(s, s1));

  }

}
