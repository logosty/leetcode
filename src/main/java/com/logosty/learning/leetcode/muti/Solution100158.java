package com.logosty.learning.leetcode.muti;

/**
 * @author logosty(ganyingle) on 2025-11-03 12:49:58
 * description: 100158. 判定字符是否唯一 [easy]
 * <p>实现一个算法，确定一个字符串 <code>s</code> 的所有字符是否全都不同。</p>
 *
 * <p><strong>示例 1：</strong></p>
 *
 * <pre>
 * <strong>输入:</strong> <code>s</code> = "leetcode"
 * <strong>输出:</strong> false
 * </pre>
 *
 * <p><strong>示例 2：</strong></p>
 *
 * <pre>
 * <strong>输入:</strong> <code>s</code> = "abc"
 * <strong>输出:</strong> true
 * </pre>
 *
 * <p><strong>限制：</strong></p>
 *
 * <ul>
 * <li><code>0 &lt;= len(s) &lt;= 100 </code></li>
 * <li><code>s[i]</code>仅包含小写字母</li>
 * <li>如果你不使用额外的数据结构，会很加分。</li>
 * </ul>
 */
class Solution100158 {

    //IMPORTANT!! Submit Code Region Begin(Do not remove this line)
    class Solution {
        public boolean isUnique(String astr) {
            long bits = 0;
            int size = astr.length();
            for (int i = 0; i < size; i++) {
                int move = astr.charAt(i) - 'A';
                if ((bits & (1L << move)) != 0) {
                    //有重复的，直接返回false
                    return false;
                } else {
                    //标记当前位置有这个字符
                    bits |= (1L << move);
                }
            }
            return true;
        }
    }
    //IMPORTANT!! Submit Code Region End(Do not remove this line)
}
