package com.logosty.learning.leetcode.part1;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with IDEA by logosty
 * Date:2018/11/12 Time:15:16
 * Description: 最长的回文子串 中等    掉在了string.substring()里面，千万不要随便创建string对象
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为1000。
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba"也是一个有效答案。
 */
public class Solution5 {
    private Map<String, String> storyMap = new HashMap<>();

    private String maxString = "";
    private static final String REGEX_STR = "^(\\S).*(\\1)$";

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


    public String longestPalindrome(String s) {
        if (s.length() == 0) {
            return "";
        }
        if (s.length() == 1) {
            return s;
        }
        if (s.length() == 2) {
            if (s.charAt(0) != s.charAt(1)) {
                return s.substring(0, 1);
            }
            return s;
        }
        int maxLenth = 1;
        int maxStringLeftIndex = 0;

        //基数遍历 1位
        for (int i = 0; i <= s.length() - 1; i++) {
            int longestReach = Math.min(i, s.length() - i - 1) * 2 + 1;
            if (longestReach <= maxLenth) {
                continue;
            }
            for (int j = 0; i - j >= 0 && i + j <= s.length() - 1; j++) {
                if (s.charAt(i - j) != s.charAt(i + j)) {
                    break;
                }
                int currentLenth = 2 * j  + 1;
                if (currentLenth > maxLenth) {
                    maxLenth = currentLenth;
                    maxStringLeftIndex = i - j;
                }
            }
        }

        //偶数遍历 2位
        for (int i = 0; i < s.length() - 1; i++) {
            int longestReach = Math.min(i, s.length() - 1 - (i + 1)) * 2 + 2;
            if (longestReach <= maxLenth) {
                continue;
            }
            for (int j = 0; i - j >= 0 && i + 1 + j <= s.length() - 1; j++) {
                if (s.charAt(i - j) != s.charAt(i + 1 + j)) {
                    break;
                }
                int currentLenth = 2 * j  + 2;
                if (currentLenth > maxLenth) {
                    maxLenth = currentLenth;
                    maxStringLeftIndex = i - j;
                }
            }
        }

        return s.substring(maxStringLeftIndex, maxStringLeftIndex + maxLenth);
    }


    public static void main(String[] args) {
        long begin = System.currentTimeMillis();
//        String s = "ffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggg";
        String s = "abcdbbfcba";
        System.out.println(new Solution5().longestPalindrome(s));
        long end = System.currentTimeMillis();
        System.out.println("time:" + (end - begin));
    }
}
