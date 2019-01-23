package com.logosty.learning.leetcode.part2;

/**
 * Created with IDEA by @author:logosty(ganyingle)
 * Date:2019/1/23 Time:17:34
 * Description: 14. 最长公共前缀
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 *
 * 如果不存在公共前缀，返回空字符串 ""。
 *
 * 示例 1:
 *
 * 输入: ["flower","flow","flight"]
 * 输出: "fl"
 * 示例 2:
 *
 * 输入: ["dog","racecar","car"]
 * 输出: ""
 * 解释: 输入不存在公共前缀。
 * 说明:
 *
 * 所有输入只包含小写字母 a-z 。
 */
public class Solution14 {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        if (strs.length == 1) {
            return strs[0];
        }

        StringBuilder prefixsb = new StringBuilder();

        int index = 0;
        while (true) {
            Character currentChar = null;

            for (int i = 0; i < strs.length; i++) {
                if (strs[i].length() - 1 < index) {
                    return prefixsb.toString();
                }
                if (currentChar == null) {
                    currentChar = strs[i].charAt(index);
                }

                if (strs[i].charAt(index) != currentChar) {
                    return prefixsb.toString();
                }
            }
            index++;
            prefixsb.append(currentChar);

        }
    }

    public static void main(String[] args) {
//        String[] strs = {"flower", "flow", "flight"};
        String[] strs = {"", "b"};

        System.out.println(new Solution14().longestCommonPrefix(strs));
    }
}
