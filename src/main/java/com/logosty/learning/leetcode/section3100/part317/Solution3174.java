package com.logosty.learning.leetcode.section3100.part317;

/**
 * @author logosty(ganyingle) on 2024/9/5 11:54
 * description: 3174. 清除数字 简单
 * 给你一个字符串 s 。
 * <p>
 * 你的任务是重复以下操作删除 所有 数字字符：
 * <p>
 * 删除 第一个数字字符 以及它左边 最近 的 非数字 字符。
 * 请你返回删除所有数字字符以后剩下的字符串。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "abc"
 * <p>
 * 输出："abc"
 * <p>
 * 解释：
 * <p>
 * 字符串中没有数字。
 * <p>
 * 示例 2：
 * <p>
 * 输入：s = "cb34"
 * <p>
 * 输出：""
 * <p>
 * 解释：
 * <p>
 * 一开始，我们对 s[2] 执行操作，s 变为 "c4" 。
 * <p>
 * 然后对 s[1] 执行操作，s 变为 "" 。
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 100
 * s 只包含小写英文字母和数字字符。
 * 输入保证所有数字都可以按以上操作被删除。
 */
public class Solution3174 {
    public String clearDigits(String s) {
        char[] charArray = s.toCharArray();
        int length = charArray.length;

        int pointNum = length - 1;
        int pointLetter = length - 1;


        while (pointNum >= 0) {
            if (charArray[pointNum] < '0' || charArray[pointNum] > '9') {
                pointNum--;
                continue;
            }
            charArray[pointNum--] = '-';

            pointLetter = Math.min(pointLetter, pointNum);
            while (pointLetter >= 0) {
                if (charArray[pointLetter] >= 'a' && charArray[pointLetter] <= 'z') {
                    charArray[pointLetter--] = '-';
                    break;
                }
                pointLetter--;
            }
        }

        return new String(charArray).replaceAll("-", "");
    }
}
