package com.logosty.learning.leetcode.section1900.part194;

/**
 * @author ganyingle 
 * Created on 2022-07-18
 * description: 1941. 检查是否所有字符出现次数相同 简单
 * 给你一个字符串 s ，如果 s 是一个 好 字符串，请你返回 true ，否则请返回 false 。
 *
 * 如果 s 中出现过的 所有 字符的出现次数 相同 ，那么我们称字符串 s 是 好 字符串。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：s = "abacbc"
 * 输出：true
 * 解释：s 中出现过的字符为 'a'，'b' 和 'c' 。s 中所有字符均出现 2 次。
 * 示例 2：
 *
 * 输入：s = "aaabb"
 * 输出：false
 * 解释：s 中出现过的字符为 'a' 和 'b' 。
 * 'a' 出现了 3 次，'b' 出现了 2 次，两者出现次数不同。
 *  
 *
 * 提示：
 *
 * 1 <= s.length <= 1000
 * s 只包含小写英文字母。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/check-if-all-characters-have-equal-number-of-occurrences
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution1941 {
    public boolean areOccurrencesEqual(String s) {
        char[] nums = new char[26];
        for (char c : s.toCharArray()) {
            nums[c - 'a']++;
        }

        char c = 0;
        for (char num : nums) {
            if (num == 0) {
                continue;
            }
            if (c == 0) {
                c = num;
                continue;
            }
            if (num != c) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Solution1941().areOccurrencesEqual("abacbc"));
    }
}
