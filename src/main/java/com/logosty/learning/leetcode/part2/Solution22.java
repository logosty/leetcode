package com.logosty.learning.leetcode.part2;

import java.util.*;

/**
 * Created with IDEA by logosty
 * Date:2019/2/12 Time:14:30
 * Description: 中等 22. 括号生成
 * 给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。
 * <p>
 * 例如，给出 n = 3，生成结果为：
 * <p>
 * [
 * "((()))",
 * "(()())",
 * "(())()",
 * "()(())",
 * "()()()"
 * ]
 * <p>
 * 预期结果
 * ["(((())))","((()()))","((())())","((()))()","(()(()))","(()()())","(()())()","(())(())","(())()()","()((()))","()(()())","()(())()","()()(())","()()()()"]
 */
public class Solution22 {
    Map<Integer,List<String>> map = new HashMap<>(16);

    public List<String> generateParenthesis(int n) {
        if (n == 0) {
            return Collections.emptyList();
        }
        if (n == 1) {
            return Collections.singletonList("()");
        }

        List<String> ret = new ArrayList<>();
        adder(ret, n, 1, 0, "(");
        return ret;
    }


    private void adder(List<String> ret, int n, int leftNum, int rightNum, String str) {
        if (leftNum > n || rightNum > n || rightNum > leftNum) {
            return;
        }
        if (leftNum == n && rightNum == n) {
            ret.add(str);
            return;
        }

        adder(ret, n, leftNum + 1, rightNum, str + "(");
        adder(ret, n, leftNum, rightNum + 1, str + ")");
    }


    public static void main(String[] args) {
        System.out.println(new Solution22().generateParenthesis(3));

    }
}
