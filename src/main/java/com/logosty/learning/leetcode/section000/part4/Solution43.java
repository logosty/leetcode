package com.logosty.learning.leetcode.section000.part4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author logosty(ganyingle) on 2020/8/13 10:34
 * 43. 字符串相乘 中等
 * 给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。
 *
 * 示例 1:
 *
 * 输入: num1 = "2", num2 = "3"
 * 输出: "6"
 * 示例 2:
 *
 * 输入: num1 = "123", num2 = "456"
 * 输出: "56088"
 * 说明：
 *
 * num1 和 num2 的长度小于110。
 * num1 和 num2 只包含数字 0-9。
 * num1 和 num2 均不以零开头，除非是数字 0 本身。
 * 不能使用任何标准库的大数类型（比如 BigInteger）或直接将输入转换为整数来处理。
 * 通过次数83,906提交次数193,972
 */
public class Solution43 {


  public String multiply(String num1, String num2) {
    char[] chars1 = num1.toCharArray();
    char[] chars2 = num2.toCharArray();
    char[] shortOne = chars1.length > chars2.length ? chars2 : chars1;
    char[] longOne = chars1.length > chars2.length ? chars1 : chars2;

    List<char[]> nums = new ArrayList<>();
    for (int i = 0; i < shortOne.length; i++) {
      nums.add(cal(longOne, shortOne[shortOne.length - 1 - i], i));
    }

    char[] res = new char[longOne.length + shortOne.length];
    int last = 0;
    for (int i = 0; i < res.length; i++) {
      int sum = last;
      for (char[] each : nums) {
        if (each.length - 1 - i < 0) {
          continue;
        }
        sum += each[each.length - 1 - i] == 0 ? 0 : each[each.length - 1 - i] - '0';
      }
      res[res.length - 1 - i] = (char) ('0' + sum % 10);
      last = sum / 10;
    }
    if (last != 0) {
      res[0] = (char) (res[0] + last);
    }
    int lead = 0;
    for (int i = 0; i < res.length; i++) {
      if (res[i] != '0') {
        break;
      }
      lead++;

    }
    lead = Math.min(lead, res.length - 1);
    if (lead > 0) {
      res = Arrays.copyOfRange(res, lead, res.length);
    }

    return String.valueOf(res);

  }

  public char[] cal(char[] num1, char c, int offset) {
    int tar = c - '0';

    char[] res = new char[num1.length + 1 + offset];
    int last = 0;

    for (int i = 0; i < num1.length; i++) {
      int sum = tar * (num1[num1.length - 1 - i] - '0') + last;
      res[res.length - 1 - i - offset] = (char) ('0' + sum % 10);
      last = sum / 10;
    }
    res[0] = (char) ('0' + last);
    return res;
  }

  public static void main(String[] args) {
    String num1 = "9133", num2 = "0";

    System.out.println(new Solution43().multiply(num1, num2));
  }
}
