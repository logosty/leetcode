package com.logosty.learning.leetcode.section2300.part230;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author logosty(ganyingle) on 2025/10/16 17:39
 * description: 2300. 咒语和药水的成功对数 中的
 * 给你两个正整数数组 spells 和 potions ，长度分别为 n 和 m ，其中 spells[i] 表示第 i 个咒语的能量强度，potions[j] 表示第 j 瓶药水的能量强度。
 * <p>
 * 同时给你一个整数 success 。一个咒语和药水的能量强度 相乘 如果 大于等于 success ，那么它们视为一对 成功 的组合。
 * <p>
 * 请你返回一个长度为 n 的整数数组 pairs，其中 pairs[i] 是能跟第 i 个咒语成功组合的 药水 数目。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：spells = [5,1,3], potions = [1,2,3,4,5], success = 7
 * 输出：[4,0,3]
 * 解释：
 * - 第 0 个咒语：5 * [1,2,3,4,5] = [5,10,15,20,25] 。总共 4 个成功组合。
 * - 第 1 个咒语：1 * [1,2,3,4,5] = [1,2,3,4,5] 。总共 0 个成功组合。
 * - 第 2 个咒语：3 * [1,2,3,4,5] = [3,6,9,12,15] 。总共 3 个成功组合。
 * 所以返回 [4,0,3] 。
 * 示例 2：
 * <p>
 * 输入：spells = [3,1,2], potions = [8,5,8], success = 16
 * 输出：[2,0,2]
 * 解释：
 * - 第 0 个咒语：3 * [8,5,8] = [24,15,24] 。总共 2 个成功组合。
 * - 第 1 个咒语：1 * [8,5,8] = [8,5,8] 。总共 0 个成功组合。
 * - 第 2 个咒语：2 * [8,5,8] = [16,10,16] 。总共 2 个成功组合。
 * 所以返回 [2,0,2] 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * n == spells.length
 * m == potions.length
 * 1 <= n, m <= 105
 * 1 <= spells[i], potions[i] <= 105
 * 1 <= success <= 10^10
 */
public class Solution2300 {
    Map<Integer, Integer> retCache = new HashMap<Integer, Integer>();


    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        Arrays.sort(potions);
        int length = potions.length;
        int[] ret = new int[spells.length];
        for (int i = 0; i < spells.length; i++) {
            if (retCache.containsKey(spells[i])) {
                ret[i] = retCache.get(spells[i]);
                continue;
            }

            long target = (long) (success / spells[i] + (success % spells[i] == 0 ? 0 : 1));
            ret[i] = length - find(potions, 0, potions.length - 1, target);
            ret[i] = ret[i] > length ? 0 : ret[i];
            retCache.put(spells[i], ret[i]);
        }
        return ret;
    }

    /**
     * 找到最小的大于等于target的位置
     */
    private int find(int[] potions, int start, int end, long target) {
        if (start == end) {
            return target <= potions[start] ? start : -1;
        }
        if (potions[start] >= target) {
            return start;
        }
        if (potions[end] < target) {
            return -1;
        }

        int mid = start + (end - start) / 2;
        //如果等于，就往前遍历找到最前面的符合
        if (potions[mid] == target) {
            int thisOne = mid;
            while (thisOne >= start) {
                if (potions[thisOne - 1] == target) {
                    thisOne = thisOne - 1;
                } else {
                    break;
                }
            }
            return thisOne;
        }
        //小于
        if (potions[mid] < target) {
            return find(potions, mid + 1, end, target);
        }

        //大于
        return find(potions, start, mid, target);
    }


}
