package com.logosty.learning.leetcode.section300.part37;

/**
 * @author logosty(ganyingle) on 2025/10/20 18:09
 * description: 374. 猜数字大小 简单
 * 我们正在玩猜数字游戏。猜数字游戏的规则如下：
 * <p>
 * 我会从 1 到 n 随机选择一个数字。 请你猜选出的是哪个数字。（我选的数字在整个游戏中保持不变）。
 * <p>
 * 如果你猜错了，我会告诉你，我选出的数字比你猜测的数字大了还是小了。
 * <p>
 * 你可以通过调用一个预先定义好的接口 int guess(int num) 来获取猜测结果，返回值一共有三种可能的情况：
 * <p>
 * -1：你猜的数字比我选出的数字大 （即 num > pick）。
 * 1：你猜的数字比我选出的数字小 （即 num < pick）。
 * 0：你猜的数字与我选出的数字相等。（即 num == pick）。
 * 返回我选出的数字。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 10, pick = 6
 * 输出：6
 * 示例 2：
 * <p>
 * 输入：n = 1, pick = 1
 * 输出：1
 * 示例 3：
 * <p>
 * 输入：n = 2, pick = 1
 * 输出：1
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= n <= 231 - 1
 * 1 <= pick <= n
 */


public class Solution374 {
    private int guess(int num) {
        return num;
    }

    ;


    public int guessNumber(int n) {
        return find(1, n);
    }

    private int find(int start, int end) {
        if (start == end) {
            return start;
        }

        int mid = start + (end - start) / 2;
        int guessed = guess(mid);
        if (guessed == 0) {
            return mid;
        } else if (guessed == 1) {  //mid < target
            return find(mid + 1, end);
        } else {
            return find(start, mid - 1);
        }

    }
}
