package com.logosty.learning.leetcode.section2800.part281;

import java.util.ArrayDeque;

/**
 * @author logosty(ganyingle) on 2024/4/1 16:40
 * description: 2810. 故障键盘 简单
 * 你的笔记本键盘存在故障，每当你在上面输入字符 'i' 时，它会反转你所写的字符串。而输入其他字符则可以正常工作。
 * <p>
 * 给你一个下标从 0 开始的字符串 s ，请你用故障键盘依次输入每个字符。
 * <p>
 * 返回最终笔记本屏幕上输出的字符串。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "string"
 * 输出："rtsng"
 * 解释：
 * 输入第 1 个字符后，屏幕上的文本是："s" 。
 * 输入第 2 个字符后，屏幕上的文本是："st" 。
 * 输入第 3 个字符后，屏幕上的文本是："str" 。
 * 因为第 4 个字符是 'i' ，屏幕上的文本被反转，变成 "rts" 。
 * 输入第 5 个字符后，屏幕上的文本是："rtsn" 。
 * 输入第 6 个字符后，屏幕上的文本是： "rtsng" 。
 * 因此，返回 "rtsng" 。
 * 示例 2：
 * <p>
 * 输入：s = "poiinter"
 * 输出："ponter"
 * 解释：
 * 输入第 1 个字符后，屏幕上的文本是："p" 。
 * 输入第 2 个字符后，屏幕上的文本是："po" 。
 * 因为第 3 个字符是 'i' ，屏幕上的文本被反转，变成 "op" 。
 * 因为第 4 个字符是 'i' ，屏幕上的文本被反转，变成 "po" 。
 * 输入第 5 个字符后，屏幕上的文本是："pon" 。
 * 输入第 6 个字符后，屏幕上的文本是："pont" 。
 * 输入第 7 个字符后，屏幕上的文本是："ponte" 。
 * 输入第 8 个字符后，屏幕上的文本是："ponter" 。
 * 因此，返回 "ponter" 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 100
 * s 由小写英文字母组成
 * s[0] != 'i'
 */
public class Solution2810 {
    public String finalString(String s) {
        ArrayDeque<Character> stack1 = new ArrayDeque<>();
        ArrayDeque<Character> stack2 = new ArrayDeque<>();
        ArrayDeque<Character> curStack = stack1;
        ArrayDeque<Character> otherStack = stack2;

        char[] charArray = s.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            if (charArray[i] == 'i') {
                if (i < charArray.length - 1 && charArray[i + 1] == 'i') {
                    i++;
                    continue;
                }

                //翻转
                while (!curStack.isEmpty()) {
                    otherStack.addLast(curStack.pollLast());
                }
                curStack = curStack == stack1 ? stack2 : stack1;
                otherStack = otherStack == stack1 ? stack2 : stack1;
            } else {
                curStack.addLast(charArray[i]);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (Character ch : curStack) {
            sb.append(ch);
        }
        sb.reverse();
        return sb.toString();
    }

}
