package com.logosty.learning.leetcode.section300.part36;

/**
 * @author ganyingle <ganyingle@kuaishou.com>
 * Created on 2022-07-27
 * description: 367. 有效的完全平方数 简单
 * 给定一个 正整数 num ，编写一个函数，如果 num 是一个完全平方数，则返回 true ，否则返回 false 。
 * <p>
 * 进阶：不要 使用任何内置的库函数，如  sqrt 。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：num = 16
 * 输出：true
 * 示例 2：
 * <p>
 * 输入：num = 14
 * 输出：false
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= num <= 2^31 - 1
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/valid-perfect-square
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution367 {
    public boolean isPerfectSquare(int num) {
        return isPerfectSquare(num, 1, num / 2 + 1);
    }

    public boolean isPerfectSquare(int num, int start, int end) {
        if (start > end) {
            return false;
        }

        int mid = start + (end - start) / 2;
       // int res = mid * mid;
        int res = num / mid;

        if (res == mid) {
            return num % mid == 0;
        }

        if (res < mid) {
            return isPerfectSquare(num, start, mid - 1);
        }
        return isPerfectSquare(num, mid + 1, end);

    }

    public static void main(String[] args) {
        new Solution367().isPerfectSquare(16);
    }

}
