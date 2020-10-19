package com.logosty.learning.leetcode.section000.part9;

import java.util.ArrayList;
import java.util.List;

/**
 * @author logosty(ganyingle) on 2020/10/19 20:08
 * 93. 复原IP地址 中等
 * 给定一个只包含数字的字符串，复原它并返回所有可能的 IP 地址格式。
 *
 * 有效的 IP 地址 正好由四个整数（每个整数位于 0 到 255 之间组成，且不能含有前导 0），整数之间用 '.' 分隔。
 *
 * 例如："0.1.2.201" 和 "192.168.1.1" 是 有效的 IP 地址，但是 "0.011.255.245"、"192.168.1.312" 和 "192.168@1.1" 是 无效的 IP 地址。
 *
 *
 *
 * 示例 1：
 *
 * 输入：s = "25525511135"
 * 输出：["255.255.11.135","255.255.111.35"]
 * 示例 2：
 *
 * 输入：s = "0000"
 * 输出：["0.0.0.0"]
 * 示例 3：
 *
 * 输入：s = "1111"
 * 输出：["1.1.1.1"]
 * 示例 4：
 *
 * 输入：s = "010010"
 * 输出：["0.10.0.10","0.100.1.0"]
 * 示例 5：
 *
 * 输入：s = "101023"
 * 输出：["1.0.10.23","1.0.102.3","10.1.0.23","10.10.2.3","101.0.2.3"]
 *
 *
 * 提示：
 *
 * 0 <= s.length <= 3000
 * s 仅由数字组成
 */

/**
 * 执行用时：
 * 1 ms
 * , 在所有 Java 提交中击败了
 * 99.94%
 * 的用户
 * 内存消耗：
 * 36.6 MB
 * , 在所有 Java 提交中击败了
 * 100.00%
 * 的用户
 */
public class Solution93 {

  List<String> res = new ArrayList<>();

  public List<String> restoreIpAddresses(String s) {
    StringBuilder sb = new StringBuilder();
    func(sb, s, 0, 0);
    return res;
  }

  public void func(StringBuilder sb, String s, int index, int dotCount) {
    if (index >= s.length() && dotCount == 4) {
      sb.deleteCharAt(sb.length() - 1);
      res.add(sb.toString());
      sb.append('.');
      return;
    }

    if (s.length() - index < (4 - dotCount) || s.length() - index > (4 - dotCount) * 3) {
      return;
    }

    for (int i = 0; i < 3 && index + i < s.length(); i++) {
      StringBuilder toBeAppend = new StringBuilder();
      for (int j = 0; j <= i; j++) {
        toBeAppend.append(s.charAt(index + j));
      }
      if (!check(toBeAppend)) {
        return;
      }
      sb.append(toBeAppend);
      sb.append(".");
      func(sb, s, index + i + 1, dotCount + 1);

      sb.delete(sb.length() - 2 - i, sb.length());
    }

  }

  private boolean check(StringBuilder toBeAppend) {
    if (toBeAppend.length() == 1) {
      return true;
    }
    if (toBeAppend.charAt(0) == '0') {
      return false;
    }
    int sum = 0;
    for (int i = 0; i < toBeAppend.length(); i++) {
      sum = sum * 10 + (toBeAppend.charAt(i) - '0');
    }

    return sum <= 255;
  }


  public static void main(String[] args) {
    System.out.println(new Solution93().restoreIpAddresses("101023"));
  }

}
