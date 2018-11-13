package com.logosty.learning.leetcode.part1;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with IDEA by logosty
 * Date:2018/11/12 Time:15:16
 * Description: 最长的回文子串 中等
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为1000。
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba"也是一个有效答案。
 */
public class Solution5 {
    private Map<String, String> storyMap = new HashMap<>();

    private String maxString = "";
    private static final String REGEX_STR = "^(\\S).*(\\1)$";

    public String longestPalindrome(String s) {
        if (s.length() == 0) {
            return "";
        }
        if (s.length() == 1) {
            return s;
        }
        if (s.length() == 2) {
            if (!s.matches(REGEX_STR)) {
                return s.substring(0, 1);
            }
            return s;
        }
        char[] chars = s.toCharArray();
        maxString = String.valueOf(chars[0]);

        //偶数遍历 2位
        for (int i = 0; i < chars.length - 1; i++) {
            int longestReach = Math.min(i + 1, chars.length - i - 1) * 2;
            if (longestReach <= maxString.length()) {
                continue;
            }
            for (int j = 0; j <= i && j + i + 1 <= chars.length - 1; j++) {
                if (!cheackIsPalindrome(s.substring(i - j, i + 1 + j + 1))) {
                    break;
                }
            }
        }

        //偶数遍历 2位
        for (int i = 0; i < chars.length - 2; i++) {
            int longestReach = Math.min(i + 1, chars.length - i - 2) * 2 + 1;
            if (longestReach <= maxString.length()) {
                continue;
            }
            for (int j = 0; j <= i && j + i + 2 <= chars.length - 1; j++) {
                if (!cheackIsPalindrome(s.substring(i - j, i + 2 + j + 1))) {
                    break;
                }
            }
        }

        return maxString;
    }

    private boolean cheackIsPalindrome(String s) {
        if (s.length() == 1) {
            if (s.length() > maxString.length()) {
                maxString = s;
            }
            return true;
        }
        if (s.length() == 2) {
            if (!s.matches(REGEX_STR)) {
                return false;
            }
            if (s.length() > maxString.length()) {
                maxString = s;
            }
            return true;
        }
        if (storyMap.get(s) != null) {
            return true;
        }
        if (!s.matches(REGEX_STR)) {
            return false;
        }
        if (!cheackIsPalindrome(s.substring(1, s.length() - 1))) {
            return false;
        }
        storyMap.put(s, "");
        if (s.length() > maxString.length()) {
            maxString = s;
        }
        return true;
    }


    public static void main(String[] args) {
        long begin = System.currentTimeMillis();
        String s = "ffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggg";
//        String s = "abba";
        System.out.println(new Solution5().longestPalindrome(s));
        long end = System.currentTimeMillis();
        System.out.println("time:" + (end - begin));
    }
}
