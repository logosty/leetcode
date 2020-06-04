package com.logosty.learning.leetcode.section200.part23;

import com.alibaba.fastjson.JSON;

/**
 * @author logosty(ganyingle) on 2020/6/4 15:35
 * 238. 除自身以外数组的乘积 中等
 * 给你一个长度为 n 的整数数组 nums，其中 n > 1，返回输出数组 output ，其中 output[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积。
 *
 *
 *
 * 示例:
 *
 * 输入: [1,2,3,4]
 * 输出: [24,12,8,6]
 *
 *
 * 提示：题目数据保证数组之中任意元素的全部前缀元素和后缀（甚至是整个数组）的乘积都在 32 位整数范围内。
 *
 * 说明: 请不要使用除法，且在 O(n) 时间复杂度内完成此题。
 *
 * 进阶：
 * 你可以在常数空间复杂度内完成这个题目吗？（ 出于对空间复杂度分析的目的，输出数组不被视为额外空间。）
 */
public class Solution238 {

  //空间复杂度 1
  public int[] productExceptSelf(int[] nums) {
    int length = nums.length;
    int[] ret = new int[length];
    ret[0] = nums[0];

    for (int i = 1; i < length - 1; i++) {
      ret[i] = ret[i - 1] * nums[i];
    }


    ret[length - 1] = ret[length - 2];
    int revert = nums[length - 1];
    for (int i = length - 2; i > 0; i--) {
      ret[i] = ret[i - 1] * revert;
      revert = revert * nums[i];
    }
    ret[0] = revert;

    return ret;
  }

  //空间复杂度 n
  public int[] productExceptSelf3(int[] nums) {
    int length = nums.length;
    int[] ret = new int[length];
    ret[0] = nums[0];

    for (int i = 1; i < length; i++) {
      ret[i] = ret[i - 1] * nums[i];
    }

    for (int i = length - 2; i >= 0; i--) {
      nums[i] = nums[i + 1] * nums[i];
    }

//    System.out.println(JSON.toJSONString(ret));
//    System.out.println(JSON.toJSONString(nums));

    int tmp = ret[0];
    ret[0] = nums[1];

    for (int i = 1; i < length - 1; i++) {
      int current = ret[i];
      ret[i] = tmp * nums[i + 1];
      tmp = current;
    }
    ret[length - 1] = tmp;

    return ret;
  }

  //空间复杂度 2n
  public int[] productExceptSelf2(int[] nums) {
    int length = nums.length;
    int[] order = new int[length];
    order[0] = nums[0];
    int[] revert = new int[length];
    revert[length - 1] = nums[length - 1];
    int[] ret = new int[length];

    for (int i = 1; i < length; i++) {
      order[i] = order[i - 1] * nums[i];
    }
    for (int i = length - 2; i >= 0; i--) {
      revert[i] = revert[i + 1] * nums[i];
    }

//    System.out.println(JSON.toJSONString(order));
//    System.out.println(JSON.toJSONString(revert));

    ret[0] = revert[1];
    ret[length - 1] = order[length - 2];

    for (int i = 1; i < length - 1; i++) {
      ret[i] = order[i - 1] * revert[i + 1];
    }

    return ret;
  }

  public static void main(String[] args) {
    int[] ints = {1, 2, 3, 4};
    System.out.println(JSON.toJSONString(new Solution238().productExceptSelf2(ints)));

    System.out.println(JSON.toJSONString(new Solution238().productExceptSelf(ints)));
  }
}
