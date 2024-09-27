package com.logosty.learning.leetcode.section1000.part105;

/**
 * @author logosty(ganyingle) on 2024/9/24 17:50
 * description: 1055.形成字符串的最短路径 中等
 * 对于任何字符串，我们可以通过删除其中一些字符（也可能不删除）来构造该字符串的 子序列 。(例如，“ace” 是 “abcde” 的子序列，而 “aec” 不是)。
 * <p>
 * 给定源字符串 source 和目标字符串 target，返回 源字符串 source 中能通过串联形成目标字符串 target 的 子序列 的最小数量 。如果无法通过串联源字符串中的子序列来构造目标字符串，则返回 -1。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：source = "abc", target = "abcbc"
 * 输出：2
 * 解释：目标字符串 "abcbc" 可以由 "abc" 和 "bc" 形成，它们都是源字符串 "abc" 的子序列。
 * 示例 2：
 * <p>
 * 输入：source = "abc", target = "acdbc"
 * 输出：-1
 * 解释：由于目标字符串中包含字符 "d"，所以无法由源字符串的子序列构建目标字符串。
 * 示例 3：
 * <p>
 * 输入：source = "xyz", target = "xzyxz"
 * 输出：3
 * 解释：目标字符串可以按如下方式构建： "xz" + "y" + "xz"。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= source.length, target.length <= 1000
 * source 和 target 仅包含英文小写字母。
 */
public class Solution1055 {
    public int shortestWay(String source, String target) {
        char[] sourceCharArray = source.toCharArray();
        char[] targetCharArray = target.toCharArray();
        int res = 0;
        int curSourceIndex = 0;

        boolean[] hasValue = new boolean[26];
        for (char c : sourceCharArray) {
            hasValue[c - 'a'] = true;
        }

        for (int i = 0; i < targetCharArray.length; i++) {
            char currentChar = targetCharArray[i];
            boolean matched = false;
            //这个字符串一定会有能匹配的地方
            if (!hasValue[currentChar - 'a']) {
                return -1;
            }

            //重新开始取一个新字符串
            if (curSourceIndex == 0) {
                res++;
            }
            for (int j = curSourceIndex; j < sourceCharArray.length; j++) {
                curSourceIndex = (j + 1) % sourceCharArray.length;

                if (sourceCharArray[j] == currentChar) {
                    matched = true;
                    break;
                }
            }

            if (!matched) {
                i--;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Solution1055().shortestWay("xyz", "xzyxz"));
    }
}