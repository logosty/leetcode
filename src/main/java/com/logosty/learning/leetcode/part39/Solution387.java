package com.logosty.learning.leetcode.part39;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created with IDEA by logosty
 * Date:2019/4/4 Time:17:28
 * Description: 简单 387. 字符串中的第一个唯一字符
 *
 * 给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。
 *
 * 案例:
 *
 * s = "leetcode"
 * 返回 0.
 *
 * s = "loveleetcode",
 * 返回 2.
 *
 *
 * 注意事项：您可以假定该字符串只包含小写字母。
 */
public class Solution387 {
    public int firstUniqChar(String s) {
        if (s.length() == 0) {
            return -1;
        }
        int[] arr = new int[26];
        char[] chars = s.toCharArray();

        for (char c : chars) {
            arr[c - 97]++;
        }

        for (int i = 0; i < chars.length; i++) {
            if (arr[chars[i] - 97] == 1) {
                return i;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new Solution387().firstUniqChar("loveleetcode"));

    }
}
