package com.logosty.learning.leetcode.section200.part22;

import com.logosty.learning.util.pojo.TreeNode;

/**
 * @author logosty(ganyingle) on 2020/11/24 11:05
 * 222. 完全二叉树的节点个数 中等
 * 给出一个完全二叉树，求出该树的节点个数。
 *
 * 说明：
 *
 * 完全二叉树的定义如下：在完全二叉树中，除了最底层节点可能没填满外，其余每层节点数都达到最大值，并且最下面一层的节点都集中在该层最左边的若干位置。
 * 若最底层为第 h 层，则该层包含 1~ 2h 个节点。
 *
 * 示例:
 *
 * 输入:
 *     1
 *    / \
 *   2   3
 *  / \  /
 * 4  5 6
 *
 * 输出: 6
 */
public class Solution222 {

  private int res;

  /**
   * 执行用时：
   * 0 ms
   * , 在所有 Java 提交中击败了
   * 100.00%
   * 的用户
   * 内存消耗：
   * 41 MB
   * , 在所有 Java 提交中击败了
   * 78.47%
   * 的用户
   * @param root
   * @return
   */
  public int countNodes(TreeNode root) {
    loop(root);
    return res;
  }

  private void loop(TreeNode root) {
    if (root == null) {
      return;
    }
    loop(root.left);
    res++;
    loop(root.right);
  }
}
