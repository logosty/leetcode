package com.logosty.learning.leetcode.section200.part20;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author logosty(ganyingle) on 2025/4/23 22:22
 * description: 202. 快乐数 简单
 * 编写一个算法来判断一个数 n 是不是快乐数。
 * <p>
 * 「快乐数」 定义为：
 * <p>
 * 对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和。
 * 然后重复这个过程直到这个数变为 1，也可能是 无限循环 但始终变不到 1。
 * 如果这个过程 结果为 1，那么这个数就是快乐数。
 * 如果 n 是 快乐数 就返回 true ；不是，则返回 false 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 19
 * 输出：true
 * 解释：
 * 12 + 92 = 82
 * 82 + 22 = 68
 * 62 + 82 = 100
 * 12 + 02 + 02 = 1
 * 示例 2：
 * <p>
 * 输入：n = 2
 * 输出：false
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= n <= 231 - 1
 */
public class Solution202 {
    static Map<Integer, Integer> squareMap = new HashMap<Integer, Integer>();

    static {
        for (int i = 0; i < 10; i++) {
            squareMap.put(i, i * i);
        }
    }

    Set<Integer> loopedSet = new HashSet<Integer>();

    public boolean isHappy(int n) {
        if (loopedSet.contains(n)) {
            return false;
        }
        int disassembled = disassemble(n);
        if (disassembled == 1) {
            return true;
        }
        loopedSet.add(n);
        return isHappy(disassembled);
    }

    private int disassemble(int num) {
        int result = 0;
        while (num > 0) {
            result += squareMap.get(num % 10);
            num /= 10;
        }
        return result;
    }
}
