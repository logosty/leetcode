package com.logosty.learning.leetcode.section100.part14;

import com.logosty.learning.util.pojo.TreeNode;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * @author logosty(ganyingle) on 2020/9/29 16:20
 * 145. 二叉树的后序遍历 中等
 * 给定一个二叉树，返回它的 后序 遍历。
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
 * 输出: [3,2,1]
 * 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
 */
public class Solution145 {

  public List<Integer> postorderTraversal(TreeNode root) {
    List<Integer> res = new LinkedList<>();
    if (root == null) {
      return res;
    }

    Deque<TreeNode> deque = new ArrayDeque<>();
    Set<TreeNode> visited = new HashSet<>();
    deque.push(root);
    while (!deque.isEmpty()) {
      TreeNode node = deque.pop();
      if (visited.contains(node)) {
        res.add(node.val);
        continue;
      }

      deque.push(node);
      visited.add(node);

      if (node.right != null) {
        deque.push(node.right);
      }
      if (node.left != null) {
        deque.push(node.left);
      }
    }

    return res;
  }
}
