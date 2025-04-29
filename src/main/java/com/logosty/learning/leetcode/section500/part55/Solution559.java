package com.logosty.learning.leetcode.section500.part55;


import com.logosty.learning.util.pojo.Node;

/**
 * @author logosty(ganyingle) on 2020/11/19 11:28
 * 559. N叉树的最大深度 简单
 * 给定一个 N 叉树，找到其最大深度。
 *
 * 最大深度是指从根节点到最远叶子节点的最长路径上的节点总数。
 *
 * 例如，给定一个 3叉树 :
 *
 *
 *
 *
 *
 *
 *
 * 我们应返回其最大深度，3。
 *
 * 说明:
 *
 * 树的深度不会超过 1000。
 * 树的节点总不会超过 5000。
 */


public class Solution559 {

  /**
   * 执行用时：
   * 0 ms
   * , 在所有 Java 提交中击败了
   * 100.00%
   * 的用户
   * 内存消耗：
   * 38.4 MB
   * , 在所有 Java 提交中击败了
   * 90.60%
   * 的用户
   */
  public int maxDepth(Node root) {
    if (root == null) {
      return 0;
    }
    if (root.children == null || root.children.size() == 0) {
      return 1;
    }
    int max = 0;
    for (Node node : root.children) {
      max = Math.max(max, maxDepth(node));
    }
    return 1 + max;
  }
}
