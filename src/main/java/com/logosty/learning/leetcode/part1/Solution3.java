package com.logosty.learning.leetcode.part1;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with IDEA by logosty
 * Date:2018/11/8 Time:20:16
 * Description: 给定一个字符串，找出不含有重复字符的最长子串的长度。
 */
public class Solution3 {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || "".equals(s)) {
            return 0;
        }

        int maxLenth = 1;
        byte[] bytes = s.getBytes();
        int startIndex = -1;
        Map<Byte, Integer> map = new HashMap<>(16);
        for (int i = 0; i < bytes.length; i++) {
            Integer pre = map.put(bytes[i], i);
            if (pre != null && pre >= startIndex) {
                startIndex = pre;
                continue;
            }
            maxLenth = Math.max(maxLenth, i - startIndex);
        }

        return maxLenth;
    }


    public static void main(String[] args) {
//        String s = "abcabcbb";
//        String s = "pwwkew";
        String s = "tmmzuxt";
        System.out.println(new Solution3().lengthOfLongestSubstring(s));
    }
}
