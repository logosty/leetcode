package com.logosty.learning.special.part4;

/**
 * @author logosty(ganyingle) on 2020/6/9 11:10
 * 面试题46. 把数字翻译成字符串 中等
 * 给定一个数字，我们按照如下规则把它翻译为字符串：0 翻译成 “a” ，1 翻译成 “b”，……，11 翻译成 “l”，……，25 翻译成 “z”。一个数字可能有多个翻译。请编程实现一个函数，用来计算一个数字有多少种不同的翻译方法。
 *
 *
 *
 * 示例 1:
 *
 * 输入: 12258
 * 输出: 5
 * 解释: 12258有5种不同的翻译，分别是"bccfi", "bwfi", "bczi", "mcfi"和"mzi"
 *
 *
 * 提示：
 *
 * 0 <= num < 231
 */
public class Solution46 {

  public int translateNum(int num) {
    int current = 1;
    int last = 0;
    int lastBit = 100;

    while (num > 0) {
      int currentBit = num % 10;
      num = num / 10;
      int tmp = current;

      if (currentBit != 0 && currentBit * 10 + lastBit <= 25) {
        current = current + last;
      }

      last = tmp;

      lastBit = currentBit;
    }

    return current;
  }

  public static void main(String[] args) {
    System.out.println(new Solution46().translateNum(506));
  }
}
