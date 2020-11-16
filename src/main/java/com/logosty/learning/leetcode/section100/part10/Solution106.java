package com.logosty.learning.leetcode.section100.part10;

import com.logosty.learning.util.TreeUtil;
import com.logosty.learning.util.pojo.TreeNode;

/**
 * @author logosty(ganyingle) on 2020/11/16 19:44
 * 106. 从中序与后序遍历序列构造二叉树 中等
 * 根据一棵树的中序遍历与后序遍历构造二叉树。
 *
 * 注意:
 * 你可以假设树中没有重复的元素。
 *
 * 例如，给出
 *
 * 中序遍历 inorder = [9,3,15,20,7]
 * 后序遍历 postorder = [9,15,7,20,3]
 * 返回如下的二叉树：
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 */
public class Solution106 {

  int[] inorder;
  int[] postorder;

  public static void main(String[] args) {
    int[] in = {9, 3, 15, 20, 7};
    int[] post = {9, 15, 7, 20, 3};

    TreeNode node = new Solution106().buildTree(in, post);
    System.out.println(TreeUtil.treeNodeToString(node));
  }


  public TreeNode buildTree(int[] inorder, int[] postorder) {
    if (inorder.length == 0) {
      return null;
    }

    this.inorder = inorder;
    this.postorder = postorder;

//    return loop1(0, postorder.length - 1, 0, inorder.length - 1);
    TreeNode treeNode = new TreeNode(-1);
    loop(treeNode, true, 0, postorder.length - 1, 0, inorder.length - 1);
    return treeNode.left;
  }


  private void loop(TreeNode last, boolean left, int postBegin, int postEnd, int inBegin,
      int inEnd) {
    TreeNode node = postEnd >= postBegin ? new TreeNode(postorder[postEnd]) : null;
    if (left) {
      last.left = node;
    } else {
      last.right = node;
    }

    if (postBegin >= postEnd) {
      return;
    }

    int leftNum = 0;
    for (int i = inBegin; i <= inEnd; i++) {
      if (inorder[i] == node.val) {
        break;
      }
      leftNum++;
    }
    loop(node, true, postBegin, postBegin + leftNum - 1, inBegin, inBegin + leftNum - 1);
    loop(node, false, postBegin + leftNum, postEnd - 1, inBegin + leftNum + 1, inEnd);
  }


  /**
   * 执行结果：
   * 通过
   * 显示详情
   * 执行用时：
   * 7 ms
   * , 在所有 Java 提交中击败了
   * 17.95%
   * 的用户
   * 内存消耗：
   * 38.3 MB
   * , 在所有 Java 提交中击败了
   * 98.24%
   * 的用户
   */
  private TreeNode loop1(int postBegin, int postEnd, int inBegin, int inEnd) {
    TreeNode node = new TreeNode(postorder[postEnd]);
    if (postBegin > postEnd) {
      return null;
    }
    if (postBegin == postEnd) {
      return node;
    }

    int leftNum = 0;
    for (int i = inBegin; i <= inEnd; i++) {
      if (inorder[i] == node.val) {
        break;
      }
      leftNum++;
    }
    node.left = loop1(postBegin, postBegin + leftNum - 1, inBegin, inBegin + leftNum - 1);
    node.right = loop1(postBegin + leftNum, postEnd - 1, inBegin + leftNum + 1, inEnd);
    return node;
  }

}
