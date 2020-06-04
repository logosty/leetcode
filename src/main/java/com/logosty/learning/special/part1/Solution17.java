package com.logosty.learning.special.part1;

/**
 * @author logosty(ganyingle) on 2020/6/4 19:59
 * 面试题17. 打印从1到最大的n位数 简单
 * 输入数字 n，按顺序打印出从 1 到最大的 n 位十进制数。比如输入 3，则打印出 1、2、3 一直到最大的 3 位数 999。
 *
 * 示例 1:
 *
 * 输入: n = 1
 * 输出: [1,2,3,4,5,6,7,8,9]
 *
 *
 * 说明：
 *
 * 用返回一个整数列表来代替打印
 * n 为正整数
 */
public class Solution17 {

  public int[] printNumbers(int n) {
    int max = 10;
    for (int i = 1; i < n; i++) {
      max = max * 10;
    }

    int[] ret = new int[max - 1];
    for (int i = 1; i < max; i++) {
      ret[i - 1] = i;
    }
    return ret;
  }
}
