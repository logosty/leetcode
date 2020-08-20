package com.logosty.learning.leetcode.section500.part54;

import com.logosty.learning.util.TreeUtil;
import com.logosty.learning.util.pojo.TreeNode;

/**
 * @author logosty(ganyingle) on 2020/8/20 10:31
 * 543. 二叉树的直径 简单
 * 给定一棵二叉树，你需要计算它的直径长度。一棵二叉树的直径长度是任意两个结点路径长度中的最大值。这条路径可能穿过也可能不穿过根结点。
 *
 *
 * 示例 :
 * 给定二叉树
 *
 *           1
 *          / \
 *         2   3
 *        / \
 *       4   5
 * 返回 3, 它的长度是路径 [4,2,1,3] 或者 [5,2,1,3]。
 */
public class Solution543 {

  int max = 0;

  public int diameterOfBinaryTree(TreeNode root) {
    max = 0;
    loop(root);
    return Math.max(0, max - 1);
  }

  public int loop(TreeNode root) {
    if (root == null) {
      return 0;
    }

    int left = loop(root.left);
    int right = loop(root.right);

    max = Math.max(left + right + 1, max);
    return Math.max(right, left) + 1;
  }

  public static void main(String[] args) {
    TreeNode node = TreeUtil.stringToTreeNode("[1,2,3,4,5]");
    System.out.println(new Solution543().diameterOfBinaryTree(node));

  }
}
