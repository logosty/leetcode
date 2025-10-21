package com.logosty.learning.leetcode.section1300.part131;

/**
 * @author logosty(ganyingle) on 2025/10/21 15:03
 * description: 1318. 或运算的最小翻转次数 中等
 * 给你三个正整数 a、b 和 c。
 * <p>
 * 你可以对 a 和 b 的二进制表示进行位翻转操作，返回能够使按位或运算   a OR b == c  成立的最小翻转次数。
 * <p>
 * 「位翻转操作」是指将一个数的二进制表示任何单个位上的 1 变成 0 或者 0 变成 1 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：a = 2, b = 6, c = 5
 * 输出：3
 * 解释：翻转后 a = 1 , b = 4 , c = 5 使得 a OR b == c
 * 示例 2：
 * <p>
 * 输入：a = 4, b = 2, c = 7
 * 输出：1
 * 示例 3：
 * <p>
 * 输入：a = 1, b = 2, c = 3
 * 输出：0
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= a <= 10^9
 * 1 <= b <= 10^9
 * 1 <= c <= 10^9
 */
public class Solution1318 {
    public int minFlips(int a, int b, int c) {
        int result = 0;
        while (a != 0 || b != 0 || c != 0) {
            int littleA = a & 1;
            int littleB = b & 1;
            int littleC = c & 1;
            a = a >> 1;
            b = b >> 1;
            c = c >> 1;

            if ((littleA | littleB) == littleC) {
                continue;
            } else if (littleC == 0 && littleA == 1 && littleB == 1) {
                result += 2;
            } else {
                result++;
            }

        }

        return result;

    }

    public static void main(String[] args) {
        System.out.println(new Solution1318().minFlips(8, 3, 5));
    }
}
