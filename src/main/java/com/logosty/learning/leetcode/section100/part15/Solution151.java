package com.logosty.learning.leetcode.section100.part15;

/**
 * @author logosty(ganyingle) on 2025/4/29 15:52
 * description: 151. 反转字符串中的单词 中等
 * 给你一个字符串 s ，请你反转字符串中 单词 的顺序。
 * <p>
 * 单词 是由非空格字符组成的字符串。s 中使用至少一个空格将字符串中的 单词 分隔开。
 * <p>
 * 返回 单词 顺序颠倒且 单词 之间用单个空格连接的结果字符串。
 * <p>
 * 注意：输入字符串 s中可能会存在前导空格、尾随空格或者单词间的多个空格。返回的结果字符串中，单词间应当仅用单个空格分隔，且不包含任何额外的空格。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "the sky is blue"
 * 输出："blue is sky the"
 * 示例 2：
 * <p>
 * 输入：s = "  hello world  "
 * 输出："world hello"
 * 解释：反转后的字符串中不能存在前导空格和尾随空格。
 * 示例 3：
 * <p>
 * 输入：s = "a good   example"
 * 输出："example good a"
 * 解释：如果两个单词间有多余的空格，反转后的字符串需要将单词间的空格减少到仅有一个。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 104
 * s 包含英文大小写字母、数字和空格 ' '
 * s 中 至少存在一个 单词
 * <p>
 * <p>
 * 进阶：如果字符串在你使用的编程语言中是一种可变数据类型，请尝试使用 O(1) 额外空间复杂度的 原地 解法。
 */
public class Solution151 {
    public String reverseWords(String s) {
        char[] chars = s.toCharArray();
        int effectPot = 0;
        int start = -1;

        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == ' ') {
                //前面没有单词，直接跳过即可
                if (start == -1) {
                    continue;
                }
                //前面有单词，就需要结束处理
                reverseChars(chars, start, effectPot - 1);
                chars[effectPot++] = chars[i]; //这个空格需要保留过去
                start = -1;
            } else {
                if (start == -1) {
                    start = effectPot;
                }
                //将单词填到有效的位置
                chars[effectPot++] = chars[i];

                //最后一个是字母，也需要视为空格前进行处理
                if (i == chars.length - 1) {
                    reverseChars(chars, start, effectPot - 1);
                }
            }
        }

        if (chars[effectPot - 1] == ' ') {
            effectPot--;
        }

        reverseChars(chars, 0, effectPot - 1);

        return new String(chars, 0, effectPot);
    }

    private void reverseChars(char[] chars, int start, int end) {
        char temp;
        for (int i = 0; i <= (end - start) / 2; i++) {
            temp = chars[start + i];
            chars[start + i] = chars[end - i];
            chars[end - i] = temp;
        }
    }


}
