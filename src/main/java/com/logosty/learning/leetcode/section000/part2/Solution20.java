package com.logosty.learning.leetcode.section000.part2;

import java.util.ArrayDeque;
import java.util.HashMap;

/**
 * Created with IDEA by logosty
 * Date:2019/1/29 Time:15:16
 * Description: 20. 有效的括号 简单
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 * <p>
 * 有效字符串需满足：
 * <p>
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "()"
 * 输出: true
 * 示例 2:
 * <p>
 * 输入: "()[]{}"
 * 输出: true
 * 示例 3:
 * <p>
 * 输入: "(]"
 * 输出: false
 * 示例 4:
 * <p>
 * 输入: "([)]"
 * 输出: false
 * 示例 5:
 * <p>
 * 输入: "{[]}"
 * 输出: true
 */
public class Solution20 {

    public boolean isValid(String s) {
        if (s == null || s.length() == 1) {
            return false;
        }
        if (s.length() == 0) {
            return true;
        }
        char[] arr = s.toCharArray();
        if (arr[0] == ')' || arr[0] == ']' || arr[0] == '}') {
            return false;
        }

        int[] stack = new int[arr.length+1];
        int pt = 0;

        for (int i = 0; i < arr.length; i++) {
            int var = 0;
            switch (arr[i]) {
                case '{':
                    var = 1;
                    break;
                case '}':
                    var = -1;
                    break;
                case '[':
                    var = 2;
                    break;
                case ']':
                    var = -2;
                    break;
                case '(':
                    var = 3;
                    break;
                case ')':
                    var = -3;
                    break;
                default:
                    break;
            }

            if (stack[pt] + var == 0) {
                stack[pt] = 0;
                pt--;
            } else {
                stack[++pt] = var;
            }
        }
        return stack[1] == 0;

    }

    public boolean isValid1(String s){
        if ((s.length() & 1) ==1) {
            return false;
        }
        HashMap<Character, Character> map = new HashMap<>();
        map.put('(', ')');
        map.put('[', ']');
        map.put('{', '}');

        ArrayDeque<Character> deque = new ArrayDeque<>();
        for (char c : s.toCharArray()) {
            if (map.containsKey(c)) {
                deque.push(c);
                continue;
            }
            if (deque.isEmpty()) {
                return false;
            }
            Character cc = deque.pop();
            if (map.get(cc) != c) {
                return false;
            }
        }
        return deque.isEmpty();

    }

    public static void main(String[] args) {
        System.out.println(new Solution20().isValid1("()"));
    }
}
