package com.logosty.learning.leetcode.section2000.part200;

import java.util.ArrayList;
import java.util.List;

/**
 * @author logosty(ganyingle) on 2024/4/18 23:08
 * description: 2007. 从双倍数组中还原原数组 中等
 * 一个整数数组 original 可以转变成一个 双倍 数组 changed ，转变方式为将 original 中每个元素 值乘以 2 加入数组中，然后将所有元素 随机打乱 。
 * <p>
 * 给你一个数组 changed ，如果 change 是 双倍 数组，那么请你返回 original数组，否则请返回空数组。original 的元素可以以 任意 顺序返回。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：changed = [1,3,4,2,6,8]
 * 输出：[1,3,4]
 * 解释：一个可能的 original 数组为 [1,3,4] :
 * - 将 1 乘以 2 ，得到 1 * 2 = 2 。
 * - 将 3 乘以 2 ，得到 3 * 2 = 6 。
 * - 将 4 乘以 2 ，得到 4 * 2 = 8 。
 * 其他可能的原数组方案为 [4,3,1] 或者 [3,1,4] 。
 * 示例 2：
 * <p>
 * 输入：changed = [6,3,0,1]
 * 输出：[]
 * 解释：changed 不是一个双倍数组。
 * 示例 3：
 * <p>
 * 输入：changed = [1]
 * 输出：[]
 * 解释：changed 不是一个双倍数组。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= changed.length <= 105
 * 0 <= changed[i] <= 105
 */
public class Solution2007 {
    public int[] findOriginalArray(int[] changed) {
        int[] errorRes = new int[0];
        int length = changed.length;
        if (length % 2 == 1) {
            return errorRes;
        }

        int[] cache = new int[(int) (1e5 + 1)];
        for (int num : changed) {
            cache[num]++;
        }

        List<Integer> res = new ArrayList<>();

        for (int i = 0; i < cache.length; i++) {
            //i: 数字
            //cache[i] 数字出现的个数
            if (cache[i] == 0) {
                continue;
            }

            int doubleOne = 2 * i;
            if (doubleOne >= cache.length) {
                return errorRes;
            }
            while (cache[i] > 0) {
                if (cache[doubleOne] == 0) {
                    return errorRes;
                }
                cache[doubleOne]--;
                res.add(i);
                cache[i]--;
            }
        }
        return res.stream().mapToInt(value -> value).toArray();
    }
}
