package com.logosty.learning.leetcode.section000.part0;

/**
 * Created with IDEA by @author:logosty(ganyingle)
 * Date:2019/1/22 Time:17:08
 * Description:9. 回文数 简单
 * 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 *
 * 示例 1:
 *
 * 输入: 121
 * 输出: true
 * 示例 2:
 *
 * 输入: -121
 * 输出: false
 * 解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
 * 示例 3:
 *
 * 输入: 10
 * 输出: false
 * 解释: 从右向左读, 为 01 。因此它不是一个回文数。
 * 进阶:
 *
 * 你能不将整数转为字符串来解决这个问题吗？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/palindrome-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution9 {
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        if (x == 0) {
            return true;
        }
        if (x % 10 == 0) {
            return false;
        }

//        List<Integer> bits = new ArrayList<>();
//        while (x > 0) {
//            bits.add(x % 10);
//            x /= 10;
//        }
//
//        for (int i = 0; i < bits.size() / 2; i++) {
//            if (!bits.get(i).equals(bits.get(bits.size() - 1 - i))) {
//                return false;
//            }
//        }

        int reverseNum = 0;
        while (x > reverseNum) {
            reverseNum = reverseNum * 10 + x % 10;
            x /= 10;
        }

        return x == reverseNum || x == reverseNum / 10;
    }

    public boolean isPalindrome1(int x) {
        if (x < 0) {
            return false;
        }
        if (x < 10) {
            return true;
        }

        int y = 0;
        int tmp = x;

        while (tmp > 0) {
            int bit = tmp % 10;
            y = y * 10 + bit;
            tmp = tmp / 10;
        }

        return y == x;
    }


    public static void main(String[] args) {
        System.out.println(new Solution9().isPalindrome(110));
    }

}
