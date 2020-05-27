package com.logosty.learning.leetcode.section000.part9;

import com.logosty.learning.util.pojo.TreeNode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * @author logosty(ganyingle) on 2020/5/20 14:50
 * 94. 二叉树的中序遍历 中等
 * 给定一个二叉树，返回它的中序 遍历。
 *
 * 示例:
 *
 * 输入: [1,null,2,3]
 *    1
 *     \
 *      2
 *     /
 *    3
 *
 * 输出: [1,3,2]
 * 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-inorder-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution94 {

  public List<Integer> inorderTraversal(TreeNode root) {
    if (root == null) {
      return Collections.emptyList();
    }
    List<Integer> ret = new ArrayList<>();
    ret.addAll(inorderTraversal(root.left));
    ret.add(root.val);
    ret.addAll(inorderTraversal(root.right));

    return ret;
  }

  public List<Integer> inorderTraversal2(TreeNode root) {
    List<Integer> ret = new ArrayList<>();
    if (root == null) {
      return ret;
    }

    Stack<TreeNode> stack = new Stack<>();
    stack.push(root);
    boolean isBacktrack = false;
    while (!stack.empty()) {
      TreeNode node = stack.pop();

      if (isBacktrack) {
        ret.add(node.val);
        if (node.right != null) {
          isBacktrack = false;
        }
        continue;
      }

      if (node.right == null && node.left == null) {
        ret.add(node.val);
        isBacktrack = true;
        continue;
      }

      if (node.right != null) {
        stack.push(node.right);
      }

      stack.push(node);

      if (node.left != null) {
        stack.push(node.left);
      } else {
        isBacktrack = true;
      }

    }

    return ret;
  }

  public static void main(String[] args) {

  }

}
