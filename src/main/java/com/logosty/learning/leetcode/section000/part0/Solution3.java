package com.logosty.learning.leetcode.section000.part0;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with IDEA by logosty
 * Date:2018/11/8 Time:20:16
 * Description: 3. 无重复字符的最长子串 中等
 * 示例 1:
 * <p>
 * 输入: s = "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 * <p>
 * 输入: s = "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 * <p>
 * 输入: s = "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 * 请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 0 <= s.length <= 5 * 104
 * s 由英文字母、数字、符号和空格组成
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
        String s = "aabaab!bb";
        //        String s = "pwwkew";
        //        String s = "tmmzuxt";
        System.out.println(new Solution3().lengthOfLongestSubstring2(s));
    }

    public int lengthOfLongestSubstring2(String s) {
        if (s == null) {
            return 0;
        }
        if (s.length() <= 1) {
            return s.length();
        }

        Map<Character, Integer> cache = new HashMap<>();
        char[] chars = s.toCharArray();
        int start = 0;
        int end = 0;
        int res = 1;
        cache.put(chars[0], 0);

        for (int i = 1; i < chars.length; i++) {
            if (!cache.containsKey(chars[i])) {
                cache.put(chars[i], i);
                end++;
                res = Math.max(res, end - start + 1);
                continue;
            }

            int index = cache.get(chars[i]);
            for (int j = start; j <= index; j++) {
                cache.remove(chars[j]);
            }
            cache.put(chars[i], i);
            start = index + 1;
            end = i;
        }

        return res;
    }
}
