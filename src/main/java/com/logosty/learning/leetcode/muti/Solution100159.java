package com.logosty.learning.leetcode.muti;

/**
 * @author logosty(ganyingle) on 2025-11-03 12:58:46
 * description: 100159. 判定是否互为字符重排 [easy]
 * <p>给定两个由小写字母组成的字符串 <code>s1</code> 和 <code>s2</code>，请编写一个程序，确定其中一个字符串的字符重新排列后，能否变成另一个字符串。</p>
 *
 * <p><strong>示例 1：</strong></p>
 *
 * <pre>
 * <strong>输入:</strong> <code>s1</code> = "abc", <code>s2</code> = "bca"
 * <strong>输出:</strong> true
 * </pre>
 *
 * <p><strong>示例 2：</strong></p>
 *
 * <pre>
 * <strong>输入:</strong> <code>s1</code> = "abc", <code>s2</code> = "bad"
 * <strong>输出:</strong> false
 * </pre>
 *
 * <p><strong>说明：</strong></p>
 *
 * <ul>
 * <li><code>0 &lt;= len(s1) &lt;= 100 </code></li>
 * <li><code>0 &lt;= len(s2) &lt;= 100 </code></li>
 * </ul>
 */
class Solution100159 {

    //IMPORTANT!! Submit Code Region Begin(Do not remove this line)
    class Solution {
        public boolean CheckPermutation(String s1, String s2) {
            int[] record1 = new int[26];
            int[] record2 = new int[26];

            for (char c : s1.toCharArray()) {
                record1[c - 'a']++;
            }
            for (char c : s2.toCharArray()) {
                record2[c - 'a']++;
            }

            for (int i = 0; i < record1.length; i++) {
                if (record1[i] != record2[i]) {
                    return false;
                }
            }
            return true;
        }
    }
    //IMPORTANT!! Submit Code Region End(Do not remove this line)
}
