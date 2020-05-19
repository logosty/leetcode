package com.logosty.learning.leetcode.part0;

/**
 * Created with IDEA by logosty
 * Date:2018/11/10 Time:16:58
 * Description: 简单
 * 给定一个 32 位有符号整数，将整数中的数字进行反转。
 */
public class Solution7 {
    public int reverse(int x) {
        if (x == 0 || x == Integer.MIN_VALUE || x == Integer.MAX_VALUE) {
            return 0;
        }
        boolean isNegative = x < 0;
        if (isNegative) {
            x = -x;
        }

        int ret = 0;
        while (true) {
            if (ret > Integer.MAX_VALUE / 10 || (ret == Integer.MAX_VALUE / 10 && (x % 10 > Integer.MAX_VALUE % 10))) {
                return 0;
            }
            ret = ret * 10 + x % 10;
            x = x / 10;
            if (x == 0) {
                break;
            }
        }
        if (isNegative) {
            ret = -ret;
        }
        return ret;
    }

    public static void main(String[] args) {
        long begin = System.currentTimeMillis();
//        int x = -2147483648;
        int x = 1463847412;
        System.out.println(new Solution7().reverse(x));
        long end = System.currentTimeMillis();
        System.out.println("time:" + (end - begin));
    }

}
