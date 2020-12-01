package com.logosty.learning.leetcode.section200.part27;

/**
 * @author logosty(ganyingle) on 2020/12/1 10:46
 * 278. 第一个错误的版本 简单
 * 你是产品经理，目前正在带领一个团队开发新的产品。不幸的是，你的产品的最新版本没有通过质量检测。
 * 由于每个版本都是基于之前的版本开发的，所以错误的版本之后的所有版本都是错的。
 *
 * 假设你有 n 个版本 [1, 2, ..., n]，你想找出导致之后所有版本出错的第一个错误的版本。
 *
 * 你可以通过调用 bool isBadVersion(version) 接口来判断版本号 version 是否在单元测试中出错。
 * 实现一个函数来查找第一个错误的版本。你应该尽量减少对调用 API 的次数。
 *
 * 示例:
 *
 * 给定 n = 5，并且 version = 4 是第一个错误的版本。
 *
 * 调用 isBadVersion(3) -> false
 * 调用 isBadVersion(5) -> true
 * 调用 isBadVersion(4) -> true
 *
 * 所以，4 是第一个错误的版本。
 */
/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution278 {

  private static final int ERROR_VERSION = 2147483647;
  private static final int TOTAL = 2147483647;

  public static void main(String[] args) {
    int res = new Solution278().firstBadVersion(TOTAL);
    System.out.println(res);
    System.out.println(res == ERROR_VERSION);
  }

  /**
   * 执行用时：
   * 18 ms
   * , 在所有 Java 提交中击败了
   * 29.15%
   * 的用户
   * 内存消耗：
   * 35.2 MB
   * , 在所有 Java 提交中击败了
   * 79.40%
   * 的用户
   * @param n
   * @return
   */
  public int firstBadVersion(int n) {
    if (n <= 1) {
      return n;
    }
    int res = find(1, n, Integer.MAX_VALUE);
    for (int i = res; i >= 1; i--) {
      if (!isBadVersion(i)) {
        return res;
      }
      res = i;
    }
    return res;
  }

  private int find(int begin, int end, int min) {

    if (begin >= end - 1) {
      if (isBadVersion(begin)) {
        return begin;
      }
      if (isBadVersion(end)) {
        return end;
      }
      return min;
    }

    int middle = begin + (end - begin) / 2;
    if (isBadVersion(middle)) {
      min = Math.min(min, middle);
      return find(begin, middle, min);
    } else {
      return find(middle + 1, end, min);
    }
  }

  boolean isBadVersion(int version) {
    return version >= ERROR_VERSION;
  }
}
