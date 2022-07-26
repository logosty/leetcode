package com.logosty.learning.leetcode.section2100.part215;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ganyingle 
 * Created on 2022-07-18
 * description: 2154. 将找到的值乘以 2 简单
 * 给你一个整数数组 nums ，另给你一个整数 original ，这是需要在 nums 中搜索的第一个数字。
 * <p>
 * 接下来，你需要按下述步骤操作：
 * <p>
 * 如果在 nums 中找到 original ，将 original 乘以 2 ，得到新 original（即，令 original = 2 * original）。
 * 否则，停止这一过程。
 * 只要能在数组中找到新 original ，就对新 original 继续 重复 这一过程。
 * 返回 original 的 最终 值。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [5,3,6,1,12], original = 3
 * 输出：24
 * 解释：
 * - 3 能在 nums 中找到。3 * 2 = 6 。
 * - 6 能在 nums 中找到。6 * 2 = 12 。
 * - 12 能在 nums 中找到。12 * 2 = 24 。
 * - 24 不能在 nums 中找到。因此，返回 24 。
 * 示例 2：
 * <p>
 * 输入：nums = [2,7,9], original = 4
 * 输出：4
 * 解释：
 * - 4 不能在 nums 中找到。因此，返回 4 。
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 1000
 * 1 <= nums[i], original <= 1000
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/keep-multiplying-found-values-by-two">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution2154 {
    public int findFinalValue(int[] nums, int original) {
        Map<Integer, Integer> ratios = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % original == 0) {
                ratios.put(nums[i] / original, nums[i]);
            }
        }

        int i = 1;
        int point = -1;
        while (ratios.containsKey(i)) {
            point = i;
            i *= 2;
        }
        return point > 0 ? ratios.get(point) * 2 : original;
    }
}
