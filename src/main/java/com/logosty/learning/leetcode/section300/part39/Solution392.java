package com.logosty.learning.leetcode.section300.part39;

/**
 * @author logosty(ganyingle) on 2025/4/23 21:50
 * description: 392. 判断子序列 简单
 * 简单
 * 相关标签
 * 相关企业
 * 给定字符串 s 和 t ，判断 s 是否为 t 的子序列。
 * <p>
 * 字符串的一个子序列是原始字符串删除一些（也可以不删除）字符而不改变剩余字符相对位置形成的新字符串。（例如，"ace"是"abcde"的一个子序列，而"aec"不是）。
 * <p>
 * 进阶：
 * <p>
 * 如果有大量输入的 S，称作 S1, S2, ... , Sk 其中 k >= 10亿，你需要依次检查它们是否为 T 的子序列。在这种情况下，你会怎样改变代码？
 * <p>
 * 致谢：
 * <p>
 * 特别感谢 @pbrother 添加此问题并且创建所有测试用例。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "abc", t = "ahbgdc"
 * 输出：true
 * 示例 2：
 * <p>
 * 输入：s = "axc", t = "ahbgdc"
 * 输出：false
 * <p>
 * <p>
 * 提示：
 * <p>
 * 0 <= s.length <= 100
 * 0 <= t.length <= 10^4
 * 两个字符串都只由小写字符组成。
 */
public class Solution392 {
    public boolean isSubsequence(String s, String t) {
        if (s.isEmpty()) {
            return true;
        }
        if (t.isEmpty()) {
            return false;
        }

        int indexT = 0;
        for (int i = 0; i < s.length(); i++) {
            if (indexT == t.length()) {
                return false;
            }
            while (true) {
                //              不相等就往下继续遍历，如果遍历到最后一个点就返回错误
                if (t.charAt(indexT) != s.charAt(i)) {
                    if (indexT == t.length() - 1) {
                        return false;
                    }
                    indexT++;
                } else {
                    indexT++;
                    break;
                }
            }
        }
        return true;
    }
}
