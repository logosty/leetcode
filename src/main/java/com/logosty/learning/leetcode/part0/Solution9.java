package com.logosty.learning.leetcode.part0;

/**
 * Created with IDEA by @author:logosty(ganyingle)
 * Date:2019/1/22 Time:17:08
 * Description:9. 回文数
 * 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 * 你能不将整数转为字符串来解决这个问题吗？
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

    public static void main(String[] args) {
        System.out.println(new Solution9().isPalindrome(110));
    }

}
