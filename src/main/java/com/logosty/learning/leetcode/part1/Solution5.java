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

    public String longestPalindrome(String s) {
        if (s.length() == 1) {
            return s;
        }
        char[] chars = s.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            for (int j = chars.length - 1; j > 0; j--) {
                if (chars[i] == chars[j] && cheackIsPalindrome(s.substring(i, j + 1))) {
                    break;
                }

                //todo [a / 2 + a % 2, a / 2 + 1]

            }
        }

        return maxString;
    }

    public boolean cheackIsPalindrome(String s) {
        if (s.length() == 1) {
            if (s.length() > maxString.length()) {
                maxString = s;
            }
            return true;
        }
        if (s.length() == 2) {
            if (!s.matches("(\\S)\\1")) {
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
        if (!s.matches("^(\\S)\\S*(\\1)$")) {
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
        String s = "civilwartestingwhetherthatnaptionoranynartionsoconceivedandsodedicatedcanlongendureWeareqmetonagreatbattlefiemldoftzhatwarWehavecometodedicpateaportionofthatfieldasafinalrestingplaceforthosewhoheregavetheirlivesthatthatnationmightliveItisaltogetherfangandproperthatweshoulddothisButinalargersensewecannotdedicatewecannotconsecratewecannothallowthisgroundThebravelmenlivinganddeadwhostruggledherehaveconsecrateditfaraboveourpoorponwertoaddordetractTgheworldadswfilllittlenotlenorlongrememberwhatwesayherebutitcanneverforgetwhattheydidhereItisforusthelivingrathertobededicatedheretotheulnfinishedworkwhichtheywhofoughtherehavethusfarsonoblyadvancedItisratherforustobeherededicatedtothegreattdafskremainingbeforeusthatfromthesehonoreddeadwetakeincreaseddevotiontothatcauseforwhichtheygavethelastpfullmeasureofdevotionthatweherehighlyresolvethatthesedeadshallnothavediedinvainthatthisnationunsderGodshallhaveanewbirthoffreedomandthatgovernmentofthepeoplebythepeopleforthepeopleshallnotperishfromtheearth";
        System.out.println(new Solution5().longestPalindrome(s));
        long end = System.currentTimeMillis();
        System.out.println("time:" + (end - begin));
    }
}
