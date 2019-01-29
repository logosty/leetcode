package com.logosty.learning.leetcode.part2;

import java.util.*;

/**
 * Created with IDEA by logosty
 * Date:2019/1/29 Time:15:16
 * Description: 20. 有效的括号
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 *
 * 有效字符串需满足：
 *
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 *
 * 示例 1:
 *
 * 输入: "()"
 * 输出: true
 * 示例 2:
 *
 * 输入: "()[]{}"
 * 输出: true
 * 示例 3:
 *
 * 输入: "(]"
 * 输出: false
 * 示例 4:
 *
 * 输入: "([)]"
 * 输出: false
 * 示例 5:
 *
 * 输入: "{[]}"
 * 输出: true
 */
public class Solution20 {
    public boolean isValid(String s) {
        if (s == null || "".equals(s)) {
            return true;
        }
        List<Character> list = new LinkedList<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '[' || c == '{' || c == '(') {
                list.add(c);
                continue;
            }

            if (list.size() == 0) {
                return false;
            }
            Character removeC = list.remove(list.size() - 1);
            if (c == ']' && removeC != '[') {
                return false;
            }
            if (c == '}' && removeC != '{') {
                return false;
            }
            if (c == ')' && removeC != '(') {
                return false;
            }
        }

        return list.size() == 0;
    }

    public static void main(String[] args) {
        System.out.println(new Solution20().isValid("]"));
    }
}
