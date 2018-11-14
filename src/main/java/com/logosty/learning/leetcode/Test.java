package com.logosty.learning.leetcode;

/**
 * Created with IDEA by logosty
 * Date:2018/11/12 Time:16:38
 * Description:
 */
public class Test {
    public static void main(String[] args) {
        System.out.println(Integer.toBinaryString( -2147483648));
        System.out.println(Integer.toBinaryString( -2147483648 - 1));
        System.out.println(Integer.toBinaryString( ~(-2147483648 - 1)));


    }
}
//01111111111111111111111111111111
//10000000000000000000000000000000