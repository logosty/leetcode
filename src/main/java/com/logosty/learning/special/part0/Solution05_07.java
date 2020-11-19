package com.logosty.learning.special.part0;

/**
 * @author logosty(ganyingle) on 2020/11/19 11:36
 * 05.07. 配对交换 简单
 * 配对交换。编写程序，交换某个整数的奇数位和偶数位，尽量使用较少的指令（也就是说，位0与位1交换，位2与位3交换，以此类推）。
 *
 * 示例1:
 *
 *  输入：num = 2（或者0b10）
 *  输出 1 (或者 0b01)
 * 示例2:
 *
 *  输入：num = 3
 *  输出：3
 * 提示:
 *
 * num 的范围在[0, 2^30 - 1]之间，不会发生整数溢出。
 */
public class Solution05_07 {

  /**
   * 执行用时：
   * 0 ms
   * , 在所有 Java 提交中击败了
   * 100.00%
   * 的用户
   * 内存消耗：
   * 34.9 MB
   * , 在所有 Java 提交中击败了
   * 97.44%
   * 的用户
   */
  public int exchangeBits(int num) {
    int mask1 = Integer.parseInt("0101010101010101010101010101010", 2);
    int mask2 = Integer.parseInt("1010101010101010101010101010101", 2);

    return (((num & mask1) >> 1) | ((num & mask2) << 1));
  }

  public static void main(String[] args) {
    System.out.println(new Solution05_07().exchangeBits(3));
  }
}
