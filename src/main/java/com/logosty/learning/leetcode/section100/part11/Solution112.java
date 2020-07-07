package com.logosty.learning.leetcode.section100.part11;

import com.logosty.learning.util.pojo.TreeNode;

/**
 * @author logosty(ganyingle) on 2020/7/7 15:12
 * 112. 路径总和 简单
 * 给定一个二叉树和一个目标和，判断该树中是否存在根节点到叶子节点的路径，这条路径上所有节点值相加等于目标和。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 示例:
 * 给定如下二叉树，以及目标和 sum = 22，
 *
 *               5
 *              / \
 *             4   8
 *            /   / \
 *           11  13  4
 *          /  \      \
 *         7    2      1
 * 返回 true, 因为存在目标和为 22 的根节点到叶子节点的路径 5->4->11->2。
 */
public class Solution112 {

  public boolean hasPathSum(TreeNode root, int sum) {
    return loop(root, sum, 0);
  }

  public boolean loop(TreeNode node, int sum, int current) {
    if (node == null) {
      return false;
    }
    if (node.left == null && node.right == null) {
      return sum == current + node.val;
    }
    return loop(node.left, sum, current + node.val)
        || loop(node.right, sum, current + node.val);
  }

}
