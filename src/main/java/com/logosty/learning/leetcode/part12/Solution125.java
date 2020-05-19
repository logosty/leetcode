package com.logosty.learning.leetcode.part12;

/**
 * Created with IDEA by logosty
 * Date:2019/4/16 Time:14:12
 * Description: 简单 125. 验证回文串
 * <p>
 * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
 * <p>
 * 说明：本题中，我们将空字符串定义为有效的回文串。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "A man, a plan, a canal: Panama"
 * 输出: true
 * 示例 2:
 * <p>
 * 输入: "race a car"
 * 输出: false
 * <p>
 * "A man
 */
public class Solution125 {
    public boolean isPalindrome(String s) {
        if (s.length() == 0) {
            return true;
        }
        int begin = 0;
        int end = s.length() - 1;

        while (begin != end && begin != end + 1) {
            if (!isEntity(s.charAt(begin))) {
                begin++;
                continue;
            }
            if (!isEntity(s.charAt(end))) {
                end--;
                continue;
            }

            if (!isEqual(s.charAt(begin), s.charAt(end))) {
                return false;
            }
            begin++;
            end--;
        }

        return true;
    }

    private boolean isEntity(char c) {
        return (c >= 48 && c <= 57) || (c >= 65 && c <= 90) || (c >= 97 && c <= 122);
    }

    private boolean isEqual(char a, char b) {
        if (a >= 48 && a <= 57) {
            return (a == b);
        }
        return (a == b) || (a + 32 == b) || (a == b + 32);
    }

    public static void main(String[] args) {
        String s = "aa";
        System.out.println(new Solution125().isPalindrome(s));
    }
}
