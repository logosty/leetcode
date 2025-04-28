package com.logosty.learning.leetcode.section100.part13;

/**
 * @author logosty(ganyingle) on 2020/12/24 10:08
 * 135. 分发糖果 困难
 * 老师想给孩子们分发糖果，有 N 个孩子站成了一条直线，老师会根据每个孩子的表现，预先给他们评分。
 * <p>
 * 你需要按照以下要求，帮助老师给这些孩子分发糖果：
 * <p>
 * 每个孩子至少分配到 1 个糖果。
 * 相邻的孩子中，评分高的孩子必须获得更多的糖果。
 * 那么这样下来，老师至少需要准备多少颗糖果呢？
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,0,2]
 * 输出: 5
 * 解释: 你可以分别给这三个孩子分发 2、1、2 颗糖果。
 * 示例 2:
 * <p>
 * 输入: [1,2,2]
 * 输出: 4
 * 解释: 你可以分别给这三个孩子分发 1、2、1 颗糖果。
 * 第三个孩子只得到 1 颗糖果，这已满足上述两个条件。
 */
public class Solution135 {

    public static void main(String[] args) {
        System.out.println(new Solution135().candy(new int[] {1, 0, 2}));
    }

    public int candy(int[] ratings) {
        int[] cache = new int[ratings.length];
        cache[0] = 1;
        for (int i = 1; i < ratings.length; i++) {
            //后面大于前面的，就加1就行
            if (ratings[i] > ratings[i - 1]) {
                cache[i] = cache[i - 1] + 1;
                continue;
            }
            cache[i] = 1;
        }
        for (int i = ratings.length - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                cache[i] = Math.max(cache[i], cache[i + 1] + 1);
            }
        }
        int sum = 0;
        for (int i : cache) {
            sum += i;
        }
        return sum;
    }

    public int candy1(int[] ratings) {
        int[] cache = new int[ratings.length];
        cache[0] = 1;
        for (int i = 1; i < ratings.length; i++) {
            //后面大于前面的，就加1就行
            if (ratings[i] > ratings[i - 1]) {
                cache[i] = cache[i - 1] + 1;
                continue;
            }

            //后面等于前面的，后面的重置为1
            if (ratings[i] == ratings[i - 1]) {
                cache[i] = 1;
                continue;
            }

            //后面的小于前面的
            //先置为1，后面往前面遍历
            cache[i] = 1;

            for (int j = i - 1; j >= 0; j--) {
                if (ratings[j] <= ratings[j + 1] || cache[j] > cache[j + 1]) {
                    break;
                }
                cache[j] = cache[j + 1] + 1;
            }
        }
        int sum = 0;
        for (int i : cache) {
            sum += i;
        }
        return sum;
    }
}
