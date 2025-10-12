package com.logosty.learning.leetcode.section1400.part145;

/**
 * @author logosty(ganyingle) on 2025/10/12 19:26
 * description: 1456. 定长子串中元音的最大数目 中等
 * 给你字符串 s 和整数 k 。
 * <p>
 * 请返回字符串 s 中长度为 k 的单个子字符串中可能包含的最大元音字母数。
 * <p>
 * 英文中的 元音字母 为（a, e, i, o, u）。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "abciiidef", k = 3
 * 输出：3
 * 解释：子字符串 "iii" 包含 3 个元音字母。
 * 示例 2：
 * <p>
 * 输入：s = "aeiou", k = 2
 * 输出：2
 * 解释：任意长度为 2 的子字符串都包含 2 个元音字母。
 * 示例 3：
 * <p>
 * 输入：s = "leetcode", k = 3
 * 输出：2
 * 解释："lee"、"eet" 和 "ode" 都包含 2 个元音字母。
 * 示例 4：
 * <p>
 * 输入：s = "rhythms", k = 4
 * 输出：0
 * 解释：字符串 s 中不含任何元音字母。
 * 示例 5：
 * <p>
 * 输入：s = "tryhard", k = 4
 * 输出：1
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 10^5
 * s 由小写英文字母组成
 * 1 <= k <= s.length
 */
public class Solution1456 {
    public int maxVowels(String s, int k) {
        char[] charArray = s.toCharArray();
        int res = 0;
        int cur = 0;

        int start = 0;
        int end = 0;

        if (checked(charArray[0])) {
            res = 1;
            cur = 1;
        }

        while (end < charArray.length - 1) {
            end++;
            if (checked(charArray[end])) {
                cur++;
            }
            if (end - start == k) {
                if (checked(charArray[start])) {
                    cur--;
                }
                start++;
            }
            res = Math.max(res, cur);
        }

        return res;
    }

    private boolean checked(char a) {
        return a == 'a' || a == 'e' || a == 'i' || a == 'o' || a == 'u';
    }
}
