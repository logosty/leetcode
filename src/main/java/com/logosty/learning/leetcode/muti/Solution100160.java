package com.logosty.learning.leetcode.muti;

/**
 * @author logosty(ganyingle) on 2025-11-03 13:01:00
 * description: 100160. URL化 [easy]
 * <p>URL化。编写一种方法，将字符串中的空格全部替换为<code>%20</code>。假定该字符串尾部有足够的空间存放新增字符，并且知道字符串的“真实”长度。（注：用<code>Java</code
 * >实现的话，请使用字符数组实现，以便直接在数组上操作。）</p>
 *
 * <p>?</p>
 *
 * <p><strong>示例 1：</strong></p>
 *
 * <pre>
 * <strong>输入</strong>："Mr John Smith    ", 13
 * <strong>输出</strong>："Mr%20John%20Smith"
 * </pre>
 *
 * <p><strong>示例 2：</strong></p>
 *
 * <pre>
 * <strong>输入</strong>："               ", 5
 * <strong>输出</strong>："%20%20%20%20%20"
 * </pre>
 *
 * <p>?</p>
 *
 * <p><strong>提示：</strong></p>
 *
 * <ul>
 * <li>字符串长度在 [0, 500000] 范围内。</li>
 * </ul>
 */
class Solution100160 {

    //IMPORTANT!! Submit Code Region Begin(Do not remove this line)
    class Solution {
        public String replaceSpaces(String S, int length) {
            return S.substring(0, length).replaceAll(" ", "%20");
        }
    }
    //IMPORTANT!! Submit Code Region End(Do not remove this line)
}
