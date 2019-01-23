package com.logosty.learning.leetcode.part2;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with IDEA by @author:logosty(ganyingle)
 * Date:2019/1/22 Time:19:58
 * Description:11. 盛最多水的容器
 * 给定 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。
 * 在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 * <p>
 * 说明：你不能倾斜容器，且 n 的值至少为 2。
 * <p>
 * 示例:
 * <p>
 * 输入: [1,8,6,2,5,4,8,3,7]
 * 输出: 49
 */
public class Solution11 {
    public int maxArea(int[] height) {
        int maxArea = 0;

        for (int i = 0; i < height.length; i++) {

            for (int j = Math.max(i, height.length - 1 - i); j > 0; j--) {
                if (i - j >= 0 && height[i - j] >= height[i]) {
                    maxArea = Math.max(maxArea, height[i] * j);
                    break;
                }

                if (i + j < height.length && height[i + j] >= height[i]) {
                    maxArea = Math.max(maxArea, height[i] * j);
                    break;
                }

            }
        }

        return maxArea;
    }

    public static void main(String[] args) {
        int[] height = {2, 1};
        System.out.println(new Solution11().maxArea(height));
    }
}
